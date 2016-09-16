package com.mefis.service;

import com.mefis.dto.ImageDTO;

import java.util.List;

/**
 * Created by Lion on 9/15/16.
 */
public interface ImageService {

    void initDefaultImages();
    ImageDTO getImage(Long id);
    ImageDTO addImage(ImageDTO imageDTO);
    List<ImageDTO> getAllImages();

}
