package edu.asu.diging.glimpse.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileInterface {

    public boolean saveFile(MultipartFile multipartFile);
}
