package com.rainchu.college.service.fileservice;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FIleServiceImpl implements FileService{
    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {

        String originalFilename = file.getOriginalFilename();
        String randomId = UUID.randomUUID().toString();
        String concat = randomId.concat(originalFilename.substring(originalFilename.lastIndexOf(".")));
        String filePath = path+File.separator+originalFilename;

        File file1 = new File(path);

        if (!file1.exists()){
            file1.mkdir();
        }

        long copy = Files.copy(file.getInputStream(), Paths.get(filePath));
        return originalFilename;
    }

    @Override
    public InputStream getResources(String path, String filename) throws FileNotFoundException {

        String pathFile = path + File.separator + filename;

        InputStream is = new FileInputStream(pathFile);

        return is;
    }
}
