package edu.asu.diging.glimpse.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import edu.asu.diging.glimpse.web.UploadController;

import java.io.File;
import java.io.IOException;

@Configuration
@PropertySource("classpath:config.properties")
@Service("fileService")
public class FileService implements FileInterface {

    @Value("${file_location}")
    private String location;

    private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

    public boolean saveFile(MultipartFile multipartFile) {
        boolean result = false;
        // set the saved location and create a directory location
        String fileName = multipartFile.getOriginalFilename();
        File pathFile = new File(location);
        // check if directory exist, if not, create directory
        if (!pathFile.exists()) {
            pathFile.mkdir();
        }

        // create the actual file
        pathFile = new File(location + fileName);
        // save the actual file
        try {
            multipartFile.transferTo(pathFile);
            result = true;
        } catch (IOException e) {
            logger.error("Unable to upload", " ", e);
        }
        return result;
    }
}
