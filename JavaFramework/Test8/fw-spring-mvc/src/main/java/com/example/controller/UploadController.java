package com.example.controller;

import com.example.pojo.UploadedImageFile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class UploadController {
    @RequestMapping("/uploadImage")
    public ModelAndView upload(UploadedImageFile uploadedImageFile) {
        // 文件重新取名
        String newFileName = UUID.randomUUID() + ".png";

        // 本地文件对象
        File imageFile = new File("F:/images", newFileName);
        imageFile.getParentFile().mkdirs();    // 如果没有目录，则创建目录

        // 保存文件到本地
        try {
            uploadedImageFile.getImage().transferTo(imageFile);
        } catch (IOException e) {
            System.out.println("图片文件保存失败");
            e.printStackTrace();
        }

        // 视图对象
        ModelAndView mav = new ModelAndView("showUploadFile");
        mav.addObject("imageName", newFileName);

        return mav;
    }
}
