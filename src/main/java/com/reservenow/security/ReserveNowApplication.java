package com.reservenow.security;

import com.reservenow.model.Categoria;
import com.reservenow.model.Image;
import com.reservenow.model.Product;
import com.reservenow.service.CategoriaService;
import com.reservenow.service.ImageService;
import com.reservenow.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ReserveNowApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReserveNowApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(
            ProductService productService,
            CategoriaService categoriaService,
            ImageService imageService
    ) {
        return args -> {
            Categoria turismo = categoriaService.findByNombre("turismo").orElseGet(() -> categoriaService.save(new Categoria("turismo")));
            Categoria aventura = categoriaService.findByNombre("aventura").orElseGet(() -> categoriaService.save(new Categoria("aventura")));
            Categoria cultural = categoriaService.findByNombre("cultural").orElseGet(() -> categoriaService.save(new Categoria("cultural")));

            // Paquete Playa Caribe - imágenes adicionales
            Product playa = productService.saveProduct(new Product(
                    "Paquete Playa Caribe",
                    "Vacaciones de 7 noches en el Caribe con todo incluido: hotel, comidas, excursiones y traslado.",
                    "https://miro.medium.com/v2/resize:fit:1200/1*YO5yJgwx4kHUu_RlF8I-kQ.jpeg",
                    turismo,
                    "Caribe"
            ));
            imageService.save(new Image("https://image-tc.galaxy.tf/wijpeg-azn37ddjngqh9i7ep264ej4qu/para-rrhh2.jpg?width=280&height=280", playa));
            imageService.save(new Image("https://media.istockphoto.com/id/1464746052/es/foto/joven-rubia-sentada-en-el-restaurante-de-la-playa-disfrutando-de-un-c%C3%B3ctel-rojo-con-el-mar.jpg?s=612x612&w=0&k=20&c=Gdmh4_F_smG1-OHoSe4HEJM0AVxw8ptw2UGwkEGpyes=", playa));
           

            // Aventura en Patagonia - imágenes adicionales
            Product patagonia = productService.saveProduct(new Product(
                    "Aventura en Patagonia",
                    "Tour de 5 días con trekking, cabalgatas y visita a glaciares en la Patagonia argentina.",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTJv3L5jB3Y7QXWxnge2IoFMpK1ca1cveZczQ&s",
                    aventura,
                    "Patagonia, Argentina"
            ));
            imageService.save(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTadbBk6L5HThr7Xg7gfdeZtkppi19DWxuXrg&s", patagonia));
            imageService.save(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQDyvJAX52Ud0vTRWVRY28Yz7ZUo9u0G4Xoh4DGWo4AHv5N_qWXDPxpYw_TlpskCWR6-Ek&usqp=CAU", patagonia));
           
            // City Tour Europa - imágenes adicionales
            Product europa = productService.saveProduct(new Product(
                    "City Tour Europa",
                    "Viaje de 10 días visitando París, Roma y Barcelona con guía y alojamiento en hoteles 4 estrellas.",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTLakFfK0oMeWqWWAPE7V-HLBCRdK0emNx_1Q&s",
                    cultural,
                    "Europa"
            ));
            imageService.save(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRxyNEqLASpI5rrH1ssVm7Dsm2OZZ5s-cONrA&s" , europa));
            imageService.save(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS6Rc1YO7KYHQMDQdl59ITp4qZcN00_HclUFA&s", europa));
            imageService.save(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQpinBW0RHV0J17buUXwPJpXWmkwR8bfTo0uWQmMf-dWhIr8rQ196TVy12Fhc0tKMnnnKw&usqp=CAU", europa));  // extra

            // Relax en Bali - imágenes adicionales
            Product bali = productService.saveProduct(new Product(
                    "Relax en Bali",
                    "Escapada de 8 días en Bali, incluye spa, playas y actividades culturales.",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRSHKACJb-mtGbqZIx6gUxmfuWDGnZgzPPtuw&s",
                    turismo,
                    "Bali, Indonesia"
            ));
            imageService.save(new Image("https://media.digitalnomads.world/wp-content/uploads/2021/01/20120709/bali-for-digital-nomads.jpg", bali));
            imageService.save(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSCLdweUUHPY7PKsSRg9ZJWr7V4EXly5Qe1TA&s", bali));
            imageService.save(new Image("https://media.cntraveler.com/photos/6882f023532abbeceb449889/16:9/w_2560%2Cc_limit/072425-Unwritten-Rules-Bali-GettyImages-1469116195.jpg", bali));  // extra

            // Expedición en la Selva Amazónica - imágenes adicionales
            Product amazonia = productService.saveProduct(new Product(
                    "Expedición en la Selva Amazónica",
                    "Explora la biodiversidad única con guías expertos y alojamiento en lodges ecológicos.",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTizJ74F4WlMATuMJaH6DgaM3pF-Lu5PTHupA&s",
                    aventura,
                    "Selva Amazónica"
            ));
            imageService.save(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQWOZEZN1-DHEK_6lHo5vNMsReJf2zDWWHo5g&s", amazonia));
            imageService.save(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQeFzweeY-076q0VQi7Q--oZM6ZVgWhkFWNvQxL4SZ-vZyeFQd9qmgOgyl628JxFQ1TsTY&usqp=CAU", amazonia));

            // Circuito Histórico en Roma - imágenes adicionales
            Product roma = productService.saveProduct(new Product(
                    "Circuito Histórico en Roma",
                    "Descubre los monumentos y la historia del Imperio Romano con tours guiados.",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTwWyq_eKnfHFkKRUUDfUE5AVSS-kYfHAg1Tg&s",
                    cultural,
                    "Roma, Italia"
            ));
            imageService.save(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQlKp1Nsea6oeEeSOtEyvZ1CJvacVsjiE_lCQ&s", roma));
            imageService.save(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSPJ_OAyCatDMKVo6cMX4cX1hMWeyGNDExnRQ&s", roma));
            imageService.save(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRolRoPE8UrPWwAezKXP70jjRDCj3-IMO-YPQ&s", roma));  // extra

            // Safari en Kenia - imágenes adicionales
            Product kenia = productService.saveProduct(new Product(
                    "Safari en Kenia",
                    "Avistaje de animales salvajes en reservas naturales con alojamiento en campamentos.",
                    "https://safariafricano.es/wp-content/uploads/sites/8/2025/02/kenya-zebra-jeep.jpg",
                    aventura,
                    "Kenia"
            ));
            imageService.save(new Image("https://a.travel-assets.com/findyours-php/viewfinder/images/res70/50000/50773-Nairobi.jpg", kenia));
            imageService.save(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTY6dV5JV99gJmSFqHzY54Lcf3HsNulLuSVNw&s", kenia));

            // Ruta de los Castillos del Loira - imágenes adicionales
            Product loira = productService.saveProduct(new Product(
                    "Ruta de los Castillos del Loira",
                    "Tour romántico por los castillos franceses con guía y catas de vino.",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQnqi6Zm3f1DedKBxTM83nw-0IfdF6V71CiUA&s",
                    cultural,
                    "Loira, Francia"
            ));
            imageService.save(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT3RbEI855ZATAbTjVtXk_18yKgzwnl0R6laQ&s", loira));
            imageService.save(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSLvd8IDl2ApbCGs5rz02k705J2l8COxaPOlA&s", loira));

            // Senderismo en Machu Picchu - imágenes adicionales
            Product machuPicchu = productService.saveProduct(new Product(
                    "Senderismo en Machu Picchu",
                    "Trekking por el Camino Inca hasta llegar a la ciudadela sagrada.",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRBRrvqaL2YxeqXTvuls_FZegMZ5CtaHQvWYA&s",
                    aventura,
                    "Machu Picchu, Perú"
            ));
            imageService.save(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQN79dxms9hTtygQWNBpeKl884MYj_PB-NLJg&s", machuPicchu));
            imageService.save(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTpddbSkfodKi2mr-K3fO3hLUDx4-t5xN9bOw&s", machuPicchu));

            // Tour gastronómico por Tailandia - imágenes adicionales
            Product tailandia = productService.saveProduct(new Product(
                    "Tour gastronómico por Tailandia",
                    "Descubre la comida tailandesa con chefs locales y visita a mercados flotantes.",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQo2LxCUHEUiOvxqg_Xq4EBDaRwVDF4AkYgrg&s",
                    cultural,
                    "Tailandia"
            ));
            imageService.save(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRovn4Sm1ciLvIYOFQ79vrDdM8_jfGcc8dWUw&s", tailandia));
            imageService.save(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRO5DQhMtCLnK3ryrh57eYF5ELM8eO0ZSdSWA&s", tailandia));

            // Esquí en los Alpes Suizos - imágenes adicionales
            Product alpes = productService.saveProduct(new Product(
                    "Esquí en los Alpes Suizos",
                    "Vacaciones de invierno en estación de esquí con forfaits y clases incluidas.",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSsfyxXFOr9OTeUJGvsCKIgrd_q8vUWG2czuA&s",
                    aventura,
                    "Alpes Suizos"
            ));
            imageService.save(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfYGOHpVzlnZSGTLFbNvtC67cgr33Cv5bZCg&s", alpes));
            imageService.save(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSSeUxKTcmDC478Enl_n7Jl_oYC2m9qXsicWw&s", alpes));

            // Descanso en las playas de Grecia - imágenes adicionales
            Product grecia = productService.saveProduct(new Product(
                    "Descanso en las playas de Grecia",
                    "Relájate en las islas griegas con aguas cristalinas y hotel frente al mar.",
                    "https://www.costacruceros.com/content/dam/costa/costa-magazine/articles-magazine/beaches/greece-beaches/greche-spiagge_m.jpg.image.694.390.low.jpg",
                    turismo,
                    "Grecia"
            ));
            imageService.save(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRedfqo3zfMHsUtk34ZRMKTU342T8zR2XHHNw&s", grecia));
            imageService.save(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjpEhDKXeEKvfAwDZzWKkDDGxC46UJmLuYFA&s", grecia));
        };
    }
}