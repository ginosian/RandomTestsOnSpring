package com.mefis.service;

import com.mefis.dao.ProfileDAO;
import com.mefis.dto.MessageDTO;
import com.mefis.dto.ProfileDTO;
import com.mefis.dto.SocialGroupDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lion on 7/28/16.
 */
@Service
@Transactional
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    ProfileDAO profileDAO;

    @Override
    public void initDefaultProfiles() {
        ProfileDTO profileDTO = new ProfileDTO("John");
        ProfileDTO profileDTO2 = new ProfileDTO("Alex");
        ProfileDTO profileDTO3 = new ProfileDTO("Ragnar");
        ProfileDTO profileDTO4 = new ProfileDTO("Robert");
        ProfileDTO profileDTO5 = new ProfileDTO("Jerry");

        List<ProfileDTO> addictList = new ArrayList<>();
        addictList.add(profileDTO);
        addictList.add(profileDTO2);

        List<ProfileDTO> alcoholicList = new ArrayList<>();
        alcoholicList.add(profileDTO);
        alcoholicList.add(profileDTO2);
        alcoholicList.add(profileDTO3);
        alcoholicList.add(profileDTO4);
        alcoholicList.add(profileDTO5);

        SocialGroupDTO alcoholics = new SocialGroupDTO("Alcoholics", alcoholicList);
        SocialGroupDTO addicts = new SocialGroupDTO("Addicts", addictList);

        List<SocialGroupDTO> groups = new ArrayList<>();
        groups.add(alcoholics);
        groups.add(addicts);

        profileDTO.setGroups(groups);
        profileDTO2.setGroups(groups);

        List<SocialGroupDTO> groups2 = new ArrayList<>();
        groups2.add(alcoholics);

        profileDTO3.setGroups(groups2);
        profileDTO4.setGroups(groups2);
        profileDTO5.setGroups(groups2);

        List<MessageDTO> messages = new ArrayList<>();
        messages.add(new MessageDTO(profileDTO, "This is message 1"));
        messages.add(new MessageDTO(profileDTO, "This is message 2"));
        messages.add(new MessageDTO(profileDTO, "This is message 3"));
        messages.add(new MessageDTO(profileDTO, "This is message 4"));


        profileDTO.setMessages(messages);




        profileDAO.addProfile(profileDTO);
        profileDAO.addProfile(profileDTO2);
        profileDAO.addProfile(profileDTO3);
        profileDAO.addProfile(profileDTO4);
        profileDAO.addProfile(profileDTO5);
    }

    @Override
    public ProfileDTO getProfile(Long id) {
        return profileDAO.getProfile(id);
    }

    @Override
    public List<ProfileDTO> getAllProfiles() {
        return null;
    }
}
