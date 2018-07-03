package org.hawks.cr.models;

import java.util.*;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="notes")
public class Notes {

	private String _id;
	private String classRef;
	private String lecRef;
	private String notes;
	private Date dateCreated;
	private Date lastmodified;
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
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Date getLastmodified() {
		return lastmodified;
	}
	public void setLastmodified(Date lastmodified) {
		this.lastmodified = lastmodified;
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
		result = prime * result + ((lastmodified == null) ? 0 : lastmodified.hashCode());
		result = prime * result + ((lecRef == null) ? 0 : lecRef.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
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
		Notes other = (Notes) obj;
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
		if (lastmodified == null) {
			if (other.lastmodified != null)
				return false;
		} else if (!lastmodified.equals(other.lastmodified))
			return false;
		if (lecRef == null) {
			if (other.lecRef != null)
				return false;
		} else if (!lecRef.equals(other.lecRef))
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
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
		return "Notes [_id=" + _id + ", classRef=" + classRef + ", lecRef=" + lecRef + ", notes=" + notes
				+ ", dateCreated=" + dateCreated + ", lastmodified=" + lastmodified + ", user=" + user + "]";
	}
	
	
	
}
