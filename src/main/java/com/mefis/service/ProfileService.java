package com.mefis.service;

import com.mefis.dto.ProfileDTO;

import java.util.List;

/**
 * Created by Lion on 7/28/16.
 */
public interface ProfileService {

    void initDefaultProfiles();
    ProfileDTO getProfile(Long id);
    List<ProfileDTO> getAllProfiles();

}
