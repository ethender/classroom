package org.hawks.cr.models;

import org.springframework.data.mongodb.core.mapping.Document;
import java.util.*;

@Document(collection="video")
public class Video {
	
	
	private String _id;
	private String classRef;
	private String lecRef;
	private String videoRef;
	private int views;
	private Date createdDate;
	private Date lastModified;
	private String owner;

	

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
	public String getVideoRef() {
		return videoRef;
	}
	public void setVideoRef(String videoRef) {
		this.videoRef = videoRef;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getLastModified() {
		return lastModified;
	}
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_id == null) ? 0 : _id.hashCode());
		result = prime * result + ((classRef == null) ? 0 : classRef.hashCode());
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((lastModified == null) ? 0 : lastModified.hashCode());
		result = prime * result + ((lecRef == null) ? 0 : lecRef.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result + ((videoRef == null) ? 0 : videoRef.hashCode());
	
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
		Video other = (Video) obj;
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
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
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
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (videoRef == null) {
			if (other.videoRef != null)
				return false;
		} else if (!videoRef.equals(other.videoRef))
			return false;
		
		if (views != other.views)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Video [_id=" + _id + ", classRef=" + classRef + ", lecRef=" + lecRef + ", videoRef=" + videoRef
				+ ", views=" + views + ", createdDate=" + createdDate + ", lastModified=" + lastModified + ", owner="
				+ owner + "]";
	}
	
	
	
	
	
	

}
