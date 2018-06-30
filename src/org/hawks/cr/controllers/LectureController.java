package org.hawks.cr.controllers;

import org.hawks.cr.models.Video;
import org.hawks.cr.serviceimpl.LectureServiceImpl;
import org.hawks.cr.serviceimpl.VideoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@Autowired
	private LectureServiceImpl lectureservice;

	@RequestMapping(path="/lecture/video/upload",headers="Content-Type= multipart/form-data",method=RequestMethod.POST)
	public @ResponseBody String getUploadVideo(@RequestParam("file") MultipartFile file) {
		System.out.println("comming to upload video");
		return videoservice.uploadVideo(file);
	}
	
	@RequestMapping(path="/lecture/video",method=RequestMethod.POST,produces="application/json",consumes="application/json")
	public @ResponseBody Object getCreateVideo(@RequestParam("video") Video video) {
		return videoservice.createVideo(video);
	}
	
	@RequestMapping(path="/lecture/video",method=RequestMethod.PUT,produces="application/json",consumes="application/json")
	public @ResponseBody Object getUpdateVideo(@RequestParam("video") Video video) {
		return videoservice.updateVideo(video);
	}
	
	@RequestMapping(path="/lecture/video/ref/{refnum}",method=RequestMethod.GET,produces="application/json")
	public @ResponseBody Object getVideoByRef(@PathVariable("refnum") String ref) {
		return videoservice.readVideoByRef(ref);
	}
	
	@RequestMapping(path="/lecture/video/class/{refnum}",method=RequestMethod.GET,produces="application/json")
	public @ResponseBody Object getVideoByClassRef(@PathVariable("refnum") String ref) {
		return videoservice.readVideoByRef(ref);
	}
	
	@RequestMapping(path="/lecture/video/lec/{refnum}",method=RequestMethod.GET,produces="application/json")
	public @ResponseBody Object getVideoByLectureRef(@PathVariable("refnum") String ref) {
		return videoservice.readVideoByRef(ref);
	}
	
	
	@RequestMapping(path="/sample",method=RequestMethod.POST)
	public @ResponseBody String getUploadVideo() {
		System.out.println("comming to upload video");
		return "hello";
	}
	
}
