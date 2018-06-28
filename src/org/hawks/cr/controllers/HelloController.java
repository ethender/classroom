package org.hawks.cr.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;

@Controller
public class HelloController {
	
	
	@RequestMapping("/hello")
	public String getHello() {
		return "hello";
	}
	
	@RequestMapping(value="/upload", method=RequestMethod.POST,headers = "Content-Type= multipart/form-data")
	public @ResponseBody String sampleFileUpload(@RequestParam("file") MultipartFile file ) {
		if(!file.isEmpty()) {
			try {
				System.out.println("FileName: "+file.getOriginalFilename());
				System.out.println("File Contenet: "+file.getContentType());
				byte[] bytes = file.getBytes();
				File f = new File("/Users/ethender/Sites/uploads/"+file.getOriginalFilename());
				BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream(f));
				bo.write(bytes);
				bo.close();
				System.out.println("File Uploaded successfully");
				return "File Uploaded Successfully";
			}catch(Exception ex) {
				System.err.println("Although file was not empty. Error ocurred at processing");
				return "Although file was not empty. Error ocurred at processing";
			}
		}else {
			System.out.println("failed to upload file");
			return "failed to upload file";
		}
		
	}

}
