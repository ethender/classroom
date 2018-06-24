package org.hawks.cr.service;

import org.hawks.cr.models.Lecture;
import java.util.*;

public interface LectureService {

	public Lecture createLecture(Lecture lecture);
	
	public Lecture updateLecture(Lecture lecture);
	
	public Lecture updateLectureView(Lecture lecture);
	
	public Lecture searchLectureByName(String name);
	
	public List<Lecture> searchLecturesByClass(String classRef);
	
	public List<Lecture> searchAllLectures();
	
	public Lecture deleteLecture(Lecture lecture);
	
}
