package com.mefis.dto;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Lion on 7/28/16.
 */
@Entity
@Table(name = "profile")
public class ProfileDTO {

    @Id
    @GeneratedValue
    private long id;
    @Type(type = "text")
    private String name;
    @OneToMany (cascade = CascadeType.ALL)
    private List<MessageDTO> messages;
    @ManyToMany (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable ( name = "profile_group",
//            joinColumns = { @JoinColumn(name = "profile_id")},
//            inverseJoinColumns = { @JoinColumn(name = "group_id")})
    private List<SocialGroupDTO> groups;

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append(id);
        info.append(": ");
        info.append(name);
        info.append("\tSocial Groups:\n");
        if (groups == null || groups.isEmpty()) {
            info.append("NONE");
            return info.toString();
        }
        for (SocialGroupDTO group : groups) {
            info.append(group.getName());
            info.append(":\t");
        }
        return info.toString();
    }

    public ProfileDTO() {
    }
    public ProfileDTO(String name) {
        this.name = name;
    }
    public ProfileDTO(String name, List<MessageDTO> messages) {
        this.name = name;
        this.messages = messages;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<MessageDTO> getMessages() {
        return messages;
    }
    public void setMessages(List<MessageDTO> messages) {
        this.messages = messages;
    }
    public List<SocialGroupDTO> getGroups() {
        return groups;
    }
    public void setGroups(List<SocialGroupDTO> groups) {
        this.groups = groups;
    }
}
