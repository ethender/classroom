package org.hawks.cr.serviceimpl;

import java.util.List;

import org.hawks.cr.models.Project;
import org.hawks.cr.service.ProjectService;
import org.springframework.stereotype.Service;


@Service("projectservice")
public class ProjectServiceImpl implements ProjectService{

	@Override
	public Project createProject(Project project) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Project updateProject(Project project) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Project readProject(String ref) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> readProjectThroughUser(String user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> readProjectThroughUserAndLec(String user, String lecRef) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> readProjectThroughUserAndClass(String user, String classRef) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Project deleteProject(Project project) {
		// TODO Auto-generated method stub
		return null;
	}

}
