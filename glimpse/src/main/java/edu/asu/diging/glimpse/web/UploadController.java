package edu.asu.diging.glimpse.web;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import edu.asu.diging.glimpse.service.FileService;

@Controller
public class UploadController {

    @Autowired
    private FileService fileService;

    @RequestMapping(value = "/upload")
    public String Upload() {
        return "upload";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ModelAndView uploadFile(@RequestParam("file") MultipartFile multipartFile) {
        long fileSize = multipartFile.getSize();
        String fileName = multipartFile.getOriginalFilename();
        ModelAndView modelAndView = new ModelAndView("upload");
        if (fileService.saveFile(multipartFile)) {
            Map<String, Object> modelMap = new HashMap<>();
            modelMap.put("fileName", fileName);
            modelMap.put("fileSize", fileSize);
            modelAndView.addAllObjects(modelMap);
            return modelAndView;
        }
        return new ModelAndView("upload-failed");
    }

}