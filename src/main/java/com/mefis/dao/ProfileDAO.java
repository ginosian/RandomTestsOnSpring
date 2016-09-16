package com.mefis.dao;

import com.mefis.dto.ProfileDTO;

/**
 * Created by Lion on 7/28/16.
 */
public interface ProfileDAO {

    ProfileDTO addProfile(ProfileDTO profileDTO);
    ProfileDTO getProfile(Long id);


}
