package org.hawks.cr.models;

import org.springframework.data.mongodb.core.mapping.Document;
import java.util.*;

import javax.persistence.Id;

@Document(collection="lecture")
public class Lecture {

	@Id
	private String _id;
	private String classRef;
	private String letureName;
	private String desc;
	private Date dateCeated;
	private String username;
	private int views;
	
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
	public String getLetureName() {
		return letureName;
	}
	public void setLetureName(String letureName) {
		this.letureName = letureName;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public Date getDateCeated() {
		return dateCeated;
	}
	public void setDateCeated(Date dateCeated) {
		this.dateCeated = dateCeated;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_id == null) ? 0 : _id.hashCode());
		result = prime * result + ((classRef == null) ? 0 : classRef.hashCode());
		result = prime * result + ((dateCeated == null) ? 0 : dateCeated.hashCode());
		result = prime * result + ((desc == null) ? 0 : desc.hashCode());
		result = prime * result + ((letureName == null) ? 0 : letureName.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + views;
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
		Lecture other = (Lecture) obj;
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
		if (dateCeated == null) {
			if (other.dateCeated != null)
				return false;
		} else if (!dateCeated.equals(other.dateCeated))
			return false;
		if (desc == null) {
			if (other.desc != null)
				return false;
		} else if (!desc.equals(other.desc))
			return false;
		if (letureName == null) {
			if (other.letureName != null)
				return false;
		} else if (!letureName.equals(other.letureName))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (views != other.views)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Lecture [_id=" + _id + ", classRef=" + classRef + ", letureName=" + letureName + ", desc=" + desc
				+ ", dateCeated=" + dateCeated + ", username=" + username + ", views=" + views + "]";
	}
		
	
}
