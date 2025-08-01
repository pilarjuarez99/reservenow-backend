package com.reservenow.service;

import com.reservenow.model.Image;
import com.reservenow.repository.ImageRepository;
import com.reservenow.service.ImageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public Image save(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public List<Image> findByProductId(Long productId) {
        return imageRepository.findByProductId(productId);
    }
}
