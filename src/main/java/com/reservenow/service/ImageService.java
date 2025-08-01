package com.reservenow.service;

import com.reservenow.model.Image;

import java.util.List;

public interface ImageService {
    Image save(Image image);
    List<Image> findByProductId(Long productId);
}