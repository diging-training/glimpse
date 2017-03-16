package edu.asu.diging.glimpse.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UploadController {
		@RequestMapping(value="/upload")
		public String UploadCon(){
			return "Upload";
		}
}
