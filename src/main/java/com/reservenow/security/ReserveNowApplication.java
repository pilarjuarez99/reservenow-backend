package com.reservenow.security;

import com.reservenow.model.Categoria;
import com.reservenow.model.Product;
import com.reservenow.service.CategoriaService;
import com.reservenow.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReserveNowApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReserveNowApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(ProductService productService, CategoriaService categoriaService) {
        return args -> {
            Categoria turismo = categoriaService.findByNombre("turismo").orElseGet(() -> categoriaService.save(new Categoria("turismo")));
            Categoria aventura = categoriaService.findByNombre("aventura").orElseGet(() -> categoriaService.save(new Categoria("aventura")));
            Categoria cultural = categoriaService.findByNombre("cultural").orElseGet(() -> categoriaService.save(new Categoria("cultural")));

            productService.saveProduct(new Product(
                    "Paquete Playa Caribe",
                    "Vacaciones de 7 noches en el Caribe con todo incluido: hotel, comidas, excursiones y traslado.",
                    "https://miro.medium.com/v2/resize:fit:1200/1*YO5yJgwx4kHUu_RlF8I-kQ.jpeg",
                    turismo
            ));

            productService.saveProduct(new Product(
                    "Aventura en Patagonia",
                    "Tour de 5 días con trekking, cabalgatas y visita a glaciares en la Patagonia argentina.",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTJv3L5jB3Y7QXWxnge2IoFMpK1ca1cveZczQ&s",
                    aventura
            ));

            productService.saveProduct(new Product(
                    "City Tour Europa",
                    "Viaje de 10 días visitando París, Roma y Barcelona con guía y alojamiento en hoteles 4 estrellas.",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTLakFfK0oMeWqWWAPE7V-HLBCRdK0emNx_1Q&s",
                    cultural
            ));

            productService.saveProduct(new Product(
                    "Relax en Bali",
                    "Escapada de 8 días en Bali, incluye spa, playas y actividades culturales.",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRSHKACJb-mtGbqZIx6gUxmfuWDGnZgzPPtuw&s",
                    turismo
            ));

            productService.saveProduct(new Product(
                    "Expedición en la Selva Amazónica",
                    "Explora la biodiversidad única con guías expertos y alojamiento en lodges ecológicos.",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTizJ74F4WlMATuMJaH6DgaM3pF-Lu5PTHupA&s",
                    aventura
            ));

            productService.saveProduct(new Product(
                    "Circuito Histórico en Roma",
                    "Descubre los monumentos y la historia del Imperio Romano con tours guiados.",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTwWyq_eKnfHFkKRUUDfUE5AVSS-kYfHAg1Tg&s",
                    cultural
            ));

            productService.saveProduct(new Product(
                    "Safari en Kenia",
                    "Avistaje de animales salvajes en reservas naturales con alojamiento en campamentos.",
                    "https://safariafricano.es/wp-content/uploads/sites/8/2025/02/kenya-zebra-jeep.jpg",
                    aventura
            ));

            productService.saveProduct(new Product(
                    "Ruta de los Castillos del Loira",
                    "Tour romántico por los castillos franceses con guía y catas de vino.",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQnqi6Zm3f1DedKBxTM83nw-0IfdF6V71CiUA&s",
                    cultural
            ));

            productService.saveProduct(new Product(
                    "Senderismo en Machu Picchu",
                    "Trekking por el Camino Inca hasta llegar a la ciudadela sagrada.",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRBRrvqaL2YxeqXTvuls_FZegMZ5CtaHQvWYA&s",
                    aventura
            ));

            productService.saveProduct(new Product(
                    "Tour gastronómico por Tailandia",
                    "Descubre la comida tailandesa con chefs locales y visita a mercados flotantes.",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQo2LxCUHEUiOvxqg_Xq4EBDaRwVDF4AkYgrg&s",
                    cultural
            ));

            productService.saveProduct(new Product(
                    "Esquí en los Alpes Suizos",
                    "Vacaciones de invierno en estación de esquí con forfaits y clases incluidas.",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSsfyxXFOr9OTeUJGvsCKIgrd_q8vUWG2czuA&s",
                    aventura
            ));

            productService.saveProduct(new Product(
                    "Descanso en las playas de Grecia",
                    "Relájate en las islas griegas con aguas cristalinas y hotel frente al mar.",
                    "https://www.costacruceros.com/content/dam/costa/costa-magazine/articles-magazine/beaches/greece-beaches/greche-spiagge_m.jpg.image.694.390.low.jpg",
                    turismo
            ));
        };
    }
}