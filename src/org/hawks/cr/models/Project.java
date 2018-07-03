package org.hawks.cr.models;

import java.util.*;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="project")
public class Project {

	
	private String _id;
	private String classRef;
	private String lecRef;
	private String projectRef;
	private Date dateCreated;
	private Date lastModified;
	private String user;
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getClassRef() {
		return classRef;
	}
	public void setClassRef(String classRef) {
		this.classRef = classRef;
	}
	public String getLecRef() {
		return lecRef;
	}
	public void setLecRef(String lecRef) {
		this.lecRef = lecRef;
	}
	public String getProjectRef() {
		return projectRef;
	}
	public void setProjectRef(String projectRef) {
		this.projectRef = projectRef;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Date getLastModified() {
		return lastModified;
	}
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_id == null) ? 0 : _id.hashCode());
		result = prime * result + ((classRef == null) ? 0 : classRef.hashCode());
		result = prime * result + ((dateCreated == null) ? 0 : dateCreated.hashCode());
		result = prime * result + ((lastModified == null) ? 0 : lastModified.hashCode());
		result = prime * result + ((lecRef == null) ? 0 : lecRef.hashCode());
		result = prime * result + ((projectRef == null) ? 0 : projectRef.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		if (_id == null) {
			if (other._id != null)
				return false;
		} else if (!_id.equals(other._id))
			return false;
		if (classRef == null) {
			if (other.classRef != null)
				return false;
		} else if (!classRef.equals(other.classRef))
			return false;
		if (dateCreated == null) {
			if (other.dateCreated != null)
				return false;
		} else if (!dateCreated.equals(other.dateCreated))
			return false;
		if (lastModified == null) {
			if (other.lastModified != null)
				return false;
		} else if (!lastModified.equals(other.lastModified))
			return false;
		if (lecRef == null) {
			if (other.lecRef != null)
				return false;
		} else if (!lecRef.equals(other.lecRef))
			return false;
		if (projectRef == null) {
			if (other.projectRef != null)
				return false;
		} else if (!projectRef.equals(other.projectRef))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Project [_id=" + _id + ", classRef=" + classRef + ", lecRef=" + lecRef + ", projectRef=" + projectRef
				+ ", dateCreated=" + dateCreated + ", lastModified=" + lastModified + ", user=" + user + "]";
	}
	
	
	
}
