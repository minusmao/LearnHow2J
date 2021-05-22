package com.example.pojo;

import org.springframework.web.multipart.MultipartFile;

public class UploadedImageFile {
    /* 对象属性 */
    MultipartFile image;

    /* 对象方法 */
    // getter 和 setter
    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
