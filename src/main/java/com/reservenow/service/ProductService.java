package com.reservenow.service;

import com.reservenow.dto.ProductDTO;
import com.reservenow.model.Product;
import com.reservenow.model.Image;
import com.reservenow.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> getProductDTOPage(Pageable pageable) {
        return productRepository.findAll(pageable)
                .getContent()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<ProductDTO> getProductDTOById(Long id) {
        return productRepository.findById(id)
                .map(this::convertToDTO);
    }

    @Transactional
    public List<ProductDTO> getRandomProductDTOs(int count) {
        List<Product> allProducts = productRepository.findAll();
        Collections.shuffle(allProducts);
        return allProducts.stream()
                .limit(count)
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public List<ProductDTO> getProductsByCategoriaNombre(String nombre) {
        List<Product> products = productRepository.findByCategoriaNombre(nombre);
        return products.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<ProductDTO> searchProductsByText(String text) {
        if (text == null || text.trim().isEmpty()) {
            return Collections.emptyList();
        }

        String[] words = text.toLowerCase().trim().split("\\s+");
        Set<Product> resultSet = new HashSet<>();

        for (String word : words) {
            List<Product> productsForWord = productRepository.searchByWord(word);
            resultSet.addAll(productsForWord);
        }

        return resultSet.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        return productRepository.findById(id)
                .map(existingProduct -> {
                    existingProduct.setTitulo(updatedProduct.getTitulo());
                    existingProduct.setDescripcion(updatedProduct.getDescripcion());
                    existingProduct.setImagenUrl(updatedProduct.getImagenUrl());
                    existingProduct.setCategoria(updatedProduct.getCategoria());
                    existingProduct.setCaracteristicas(updatedProduct.getCaracteristicas());
                    existingProduct.setCalificaciones(updatedProduct.getCalificaciones());
                    existingProduct.setUbicacion(updatedProduct.getUbicacion());

                    if (updatedProduct.getImages() != null) {
                        existingProduct.getImages().clear();
                        existingProduct.getImages().addAll(updatedProduct.getImages());
                    }

                    return productRepository.save(existingProduct);
                })
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id " + id));
    }

    private ProductDTO convertToDTO(Product p) {
        Set<String> caracteristicas = p.getCaracteristicas() != null
                ? p.getCaracteristicas().stream()
                    .map(c -> c.getNombre())
                    .collect(Collectors.toSet())
                : Collections.emptySet();

        Set<String> imagenes = p.getImages() != null
                ? p.getImages().stream()
                    .map(Image::getUrl)
                    .collect(Collectors.toSet())
                : Collections.emptySet();

        Set<String> fechasDisponibles = new HashSet<>(); // A implementar si tenés lógica de fechas

        return new ProductDTO(
                p.getId(),
                p.getTitulo(),
                p.getDescripcion(),
                p.getImagenUrl(),
                p.getCategoria() != null ? p.getCategoria().getNombre() : null,
                imagenes,
                caracteristicas,
                fechasDisponibles,
                p.getUbicacion()
        );
    }
}