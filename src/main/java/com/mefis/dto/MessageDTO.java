package com.mefis.dto;

import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Created by Lion on 7/28/16.
 */
@Entity
@Table(name = "message")
public class MessageDTO {

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private ProfileDTO author;
    @Type(type = "text")
    private String message;

    public MessageDTO() {
    }
    public MessageDTO(ProfileDTO author, String message) {
        this.author = author;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProfileDTO getAuthor() {
        return author;
    }

    public void setAuthor(ProfileDTO author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
