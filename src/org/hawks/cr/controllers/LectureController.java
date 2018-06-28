package org.hawks.cr.controllers;

import org.hawks.cr.serviceimpl.VideoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(path="/lecture")
@CrossOrigin
public class LectureController {
	
	@Autowired
	private VideoServiceImpl videoservice;

	@RequestMapping(path="/lectureupload",headers="multipart/form-data",method=RequestMethod.POST)
	public @ResponseBody String getUploadVideo(@RequestParam("file") MultipartFile file) {
		System.out.println("comming to upload video");
		return videoservice.uploadVideo(file);
	}
	
	@RequestMapping(path="/sample",method=RequestMethod.POST)
	public @ResponseBody String getUploadVideo() {
		System.out.println("comming to upload video");
		return "hello";
	}
	
}
