package org.hawks.cr.service;

import java.util.*;
import org.hawks.cr.models.Project;

public interface ProjectService {

	
	public Project createProject(Project project);
	
	public Project updateProject(Project project);
	
	public Project readProject(String ref);
	
	public List<Project> readProjectThroughUser(String user);
	
	public List<Project> readProjectThroughUserAndLec(String user, String lecRef);
	
	public List<Project> readProjectThroughUserAndClass(String user, String classRef);
	
	public Project deleteProject(Project project);
}
