package edu.asu.diging.glimpse.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * This is an interface for storing the file on disk
 * @author vahini mohan
 *
 */
public interface IFileService {

    public boolean saveFile(MultipartFile multipartFile);
}
