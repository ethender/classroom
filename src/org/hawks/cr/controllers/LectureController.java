package org.hawks.cr.controllers;

import org.hawks.cr.models.Lecture;
import org.hawks.cr.models.Video;
import org.hawks.cr.serviceimpl.LectureServiceImpl;
import org.hawks.cr.serviceimpl.VideoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	
	
	/**
	 * Video Services
	 * 
	 */
	
	/**
	 * 
	 * @param file
	 * @return
	 */

	@RequestMapping(path="/lecture/video/upload",headers="Content-Type= multipart/form-data",method=RequestMethod.POST)
	public @ResponseBody String getUploadVideo(@RequestParam("file") MultipartFile file) {
		System.out.println("comming to upload video");
		return videoservice.uploadVideo(file);
	}
	
	@RequestMapping(path="/lecture/video",method=RequestMethod.POST,produces="application/json",consumes="application/json")
	public @ResponseBody Object getCreateVideo(@RequestBody Video video) {
		return videoservice.createVideo(video);
	}
	
	@RequestMapping(path="/lecture/video",method=RequestMethod.PUT,produces="application/json",consumes="application/json")
	public @ResponseBody Object getUpdateVideo(@RequestBody Video video) {
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
	
	
	
	
	
	/**
	 * Lecture service
	 */
	
	@RequestMapping(path="/lecture",method=RequestMethod.POST,produces="application/json",consumes="application/json")
	public @ResponseBody Object createLecture(@RequestBody Lecture lect) {
		lectureservice.createLecture(lect);
		return lect;
	}
	
	@RequestMapping(path="/lecture",method=RequestMethod.PUT,produces="application/json",consumes="application/json")
	public @ResponseBody Object updateLecture(@RequestBody Lecture lect) {
		lectureservice.updateLecture(lect);
		return lect;
	}
	
	@RequestMapping(path="/lecture/{refnum}/{views}",method=RequestMethod.GET,produces="application/json")
	public @ResponseBody Object updateLectureView(@PathVariable("refnum") String ref, @PathVariable("views") int views) {
		Lecture lect =  new Lecture();
		lect.set_id(ref);
		lect.setViews(views);
		lectureservice.updateLectureView(lect);
		return lect;
	}
	
	
	@RequestMapping(path="/lecture/search/{name}",method=RequestMethod.GET,produces="application/json")
	public @ResponseBody Object searchByName(@PathVariable("name") String name) {
		return lectureservice.searchLectureByName(name);
	}
	
	@RequestMapping(path="/lecture/searchref/{ref}",method=RequestMethod.GET,produces="application/json")
	public @ResponseBody Object searchByRef(@PathVariable("ref") String ref) {
		return lectureservice.searchLecturesByClass(ref);
	}
	
	@RequestMapping(path="/lecture/all",method=RequestMethod.GET,produces="application/json")
	public @ResponseBody Object allClasses() {
		return lectureservice.searchAllLectures();
	}
	
}
