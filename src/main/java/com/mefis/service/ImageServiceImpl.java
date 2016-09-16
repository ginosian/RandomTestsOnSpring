package com.mefis.service;

import com.mefis.dao.ImageDAO;
import com.mefis.dto.ImageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Lion on 9/15/16.
 */
@Service
@Transactional
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageDAO imageDAO;

    @Override
    public void initDefaultImages() {
    }

    @Override
    public ImageDTO addImage(ImageDTO imageDTO) {
        return imageDAO.addImage(imageDTO);
    }

    @Override
    public ImageDTO getImage(Long id) {
        return imageDAO.getImage(id);
    }

    @Override
    public List<ImageDTO> getAllImages() {
        return null;
    }
}
