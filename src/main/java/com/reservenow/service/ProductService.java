package com.reservenow.service;

import com.reservenow.dto.ProductDTO;
import com.reservenow.model.Product;
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

    // Búsqueda flexible por palabras sueltas en título o descripción
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

    private ProductDTO convertToDTO(Product p) {
        return new ProductDTO(
                p.getId(),
                p.getTitulo(),
                p.getDescripcion(),
                p.getImagenUrl(),
                p.getCategoria() != null ? p.getCategoria().getNombre() : null
        );
    }
}
