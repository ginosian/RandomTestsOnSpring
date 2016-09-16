package com.mefis.dao;

import com.mefis.dto.ImageDTO;

/**
 * Created by Lion on 7/28/16.
 */
public interface ImageDAO {

    ImageDTO addImage(ImageDTO imageDTO);
    ImageDTO getImage(Long id);


}
