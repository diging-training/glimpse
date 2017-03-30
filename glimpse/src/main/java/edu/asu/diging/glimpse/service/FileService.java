package edu.asu.diging.glimpse.service;

import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.io.File;
import java.io.IOException;
 
@Service("fileService")
public class FileService {
 
    public static final String SAVE_LOCATION = "/users/jaharsh/";
    private static final int BUFFER_SIZE = 4096;
    
    public boolean saveFile(MultipartFile multipartFile) throws IOException{
        boolean result = false;
        //set the saved location and create a directory location
        String fileName  = multipartFile.getOriginalFilename();
        String location = SAVE_LOCATION;
        File pathFile = new File(location);
        //check if directory exist, if not, create directory
        if(!pathFile.exists()){
            pathFile.mkdir();
        }
 
        //create the actual file
        pathFile = new File(location + fileName);
        //save the actual file
        try {
            multipartFile.transferTo(pathFile);
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        String x="/users/jaharsh/"+fileName; 
        unzip(x,"/users/jaharsh/");
        return result; 
    }
    
    public static void unzip(String zipFilePath, String destDirectory) throws IOException {
        File destDir = new File(destDirectory);
        if (!destDir.exists()) {
            destDir.mkdir();
        }
        ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath));
        ZipEntry entry = zipIn.getNextEntry();
        // iterates over entries in the zip file
        while (entry != null) {
            String filePath = destDirectory + File.separator + entry.getName();
            if (!entry.isDirectory()) {
                // if the entry is a file, extracts it
                extractFile(zipIn, filePath);
            } else {
                // if the entry is a directory, make the directory
                File dir = new File(filePath);
                dir.mkdir();
            }
            zipIn.closeEntry();
            entry = zipIn.getNextEntry();
        }
        zipIn.close();
    }
    
    public static void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        byte[] bytesIn = new byte[BUFFER_SIZE];
        int read = 0;
        while ((read = zipIn.read(bytesIn)) != -1) {
            bos.write(bytesIn, 0, read);
        }
        bos.close();
    }
}
