package com.xiaozl.initialwork1.entity;

import org.springframework.web.multipart.MultipartFile;

public class Upload {


    private MultipartFile image;
    public Upload(){}

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
