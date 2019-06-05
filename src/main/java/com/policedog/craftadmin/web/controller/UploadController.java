package com.policedog.craftadmin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class UploadController {

    @ResponseBody
    @RequestMapping(value = "upload",method = RequestMethod.POST)
    public Map<String,Object> upload(MultipartFile dropFile, HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        String fileName = dropFile.getOriginalFilename();
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."));
        String filePath = request.getSession().getServletContext().getRealPath("/assets/upload/");
        //判断文件路径是否存在
        File file = new File(filePath);
        if (!file.exists()){
            file.mkdir();
        }
        //将文件写入目标文件夹
        file = new File(filePath, UUID.randomUUID()+fileSuffix);
        try {
            dropFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        result.put("fileName","/assets/upload/"+file.getName());
        return  result;
    }
}
