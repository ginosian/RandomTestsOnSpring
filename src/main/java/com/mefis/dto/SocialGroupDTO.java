package com.mefis.dto;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Lion on 7/28/16.
 */
@Entity
@Table (name = "social_group")
public class SocialGroupDTO {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToMany (mappedBy = "groups")
//    @JoinTable ( name = "group_profile",
//            joinColumns = { @JoinColumn(name = "group_id")},
//            inverseJoinColumns = { @JoinColumn(name = "profile_id")})
    List<ProfileDTO> profiles;

    public SocialGroupDTO() {
    }
    public SocialGroupDTO(String name, List<ProfileDTO> profiles) {
        this.name = name;
        this.profiles = profiles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProfileDTO> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<ProfileDTO> profiles) {
        this.profiles = profiles;
    }
}
