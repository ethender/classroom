package org.hawks.cr.models;

import java.util.*;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="task")
public class Task {

	
	private String _id;
	private String classRef;
	private String lecRef;
	private String taskName;
	private String taskDesc;
	private boolean isTaskComplete;
	private Date  dateCreated;
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
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getTaskDesc() {
		return taskDesc;
	}
	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}
	public boolean isTaskComplete() {
		return isTaskComplete;
	}
	public void setTaskComplete(boolean isTaskComplete) {
		this.isTaskComplete = isTaskComplete;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
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
		result = prime * result + (isTaskComplete ? 1231 : 1237);
		result = prime * result + ((lecRef == null) ? 0 : lecRef.hashCode());
		result = prime * result + ((taskDesc == null) ? 0 : taskDesc.hashCode());
		result = prime * result + ((taskName == null) ? 0 : taskName.hashCode());
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
		Task other = (Task) obj;
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
		if (isTaskComplete != other.isTaskComplete)
			return false;
		if (lecRef == null) {
			if (other.lecRef != null)
				return false;
		} else if (!lecRef.equals(other.lecRef))
			return false;
		if (taskDesc == null) {
			if (other.taskDesc != null)
				return false;
		} else if (!taskDesc.equals(other.taskDesc))
			return false;
		if (taskName == null) {
			if (other.taskName != null)
				return false;
		} else if (!taskName.equals(other.taskName))
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
		return "Task [_id=" + _id + ", classRef=" + classRef + ", lecRef=" + lecRef + ", taskName=" + taskName
				+ ", taskDesc=" + taskDesc + ", isTaskComplete=" + isTaskComplete + ", dateCreated=" + dateCreated
				+ ", user=" + user + "]";
	}
	
	
	
}
