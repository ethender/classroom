package org.hawks.cr.controllers;

import org.hawks.cr.models.Upload;
import org.hawks.cr.serviceimpl.UploadServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
@RequestMapping(path="/upload")
public class UploadController {

	
	@Autowired
	private UploadServiceimpl uploadservice;
	@Value("${UPLOADFOLDER}")
	private String myvalues;
	
	
	@RequestMapping(path="/multipart",headers="Content-Type= multipart/form-data",method=RequestMethod.POST)
	public @ResponseBody Object createUpload(@RequestParam("file") MultipartFile file) {
		Upload result = uploadservice.uploadFile(file);
		return uploadservice.createUpload(result);
	}
	
	
	@RequestMapping(path="/multipart/{ref}",method=RequestMethod.GET,produces="application/json")
	public @ResponseBody Object readUpload(@PathVariable("ref") String ref) {
		return  uploadservice.readUpload(ref);
	}
	
	@RequestMapping(path="/multipart/del/{ref}",method=RequestMethod.DELETE,produces="application/json")
	public @ResponseBody Object deleteUpload(@PathVariable("ref") String ref) {
		Upload up = new Upload();
		up.set_id(ref);
		return  uploadservice.deleteUpload(up);
	}
	
	
	@RequestMapping(path="/sample",method=RequestMethod.GET)
	public @ResponseBody Object checkPropertiesFiles() {
		System.out.println("@@@ myvalues:"+myvalues);
		return myvalues;
	}
	
}
