package com.subh.app.h2db.service;

import com.subh.app.h2db.configuration.FileStorageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileStorageService {

    private Path fileStorageLoc;

    @Autowired
    public FileStorageService(FileStorageProperties fileStorageProperties) {
        System.out.println("relative upload path: " + fileStorageProperties.getUploadDir());
        fileStorageLoc = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();

        try {
            Files.createDirectories(fileStorageLoc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String storeFile(MultipartFile file) throws Exception {
        String fileName = file.getOriginalFilename();

        Path resolve = this.fileStorageLoc.resolve(fileName);
        try {
            Files.copy(file.getInputStream(), resolve, StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        } catch (IOException e) {
            throw new Exception("file can't be created");
        }
    }
}
