package org.hawks.cr.controllers;

import org.hawks.cr.models.CRClass;
import org.hawks.cr.serviceimpl.ClassServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;


@RestController
@CrossOrigin
@RequestMapping(path="/class")
public class ClassController {
	
	@Autowired
	private ClassServiceImpl classservice;

	@RequestMapping(path="/create",method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public Object createClass(@RequestBody CRClass classObj) {
		Date d = org.hawks.utils.util.getDateNow();
		classObj.setDateOfCreate(d);
		classObj.setLastModified(d);
		classservice.createClass(classObj);
		return classObj;
	}
	
	
	@RequestMapping(path="/{classname}",method=RequestMethod.GET,produces="application/json")
	public Object getClass(@PathVariable("classname") String name) {
		return classservice.searchClassThroughName(name);
	}
	
	@RequestMapping(path="/by/{instructor}",method=RequestMethod.GET,produces="application/json")
	public Object getClassesByInstructor(@PathVariable("instructor") String instructor) {
		return classservice.searchClassThroughUsername(instructor);
	}
	
	@RequestMapping(path="/allclasses",method=RequestMethod.GET,produces="application/json")
	public Object getAllClasses() {
		return classservice.allClasses();
	}
	
	
	@RequestMapping(path="/update",method=RequestMethod.PUT,consumes="application/json",produces="application/json")
	public Object updateClass(@RequestBody CRClass classObj) {
		Date d = org.hawks.utils.util.getDateNow();
		classObj.setLastModified(d);
		classservice.createClass(classObj);
		return classObj;
	}
	
	
}
