package com.mefis.dto;

import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Created by Lion on 9/15/16.
 */
@Entity
@Table(name = "image")
public class ImageDTO {

    @Id
    @GeneratedValue
    private long id;

    @Lob
    private byte[] imageBytes;
    @Type(type = "text")
    private String name;
    @Type(type = "text")
    private String type;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public byte[] getImageBytes() {
        return imageBytes;
    }

    public void setImageBytes(byte[] imageBytes) {
        this.imageBytes = imageBytes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
