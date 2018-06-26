package org.hawks.cr.models;

import org.springframework.web.multipart.MultipartFile;

public class VideoRequest {
	
	private String classRef;
	private String lecref;
	
	private String owner;
	private MultipartFile file;
	
	public String getClassRef() {
		return classRef;
	}
	public void setClassRef(String classRef) {
		this.classRef = classRef;
	}
	public String getLecref() {
		return lecref;
	}
	public void setLecref(String lecref) {
		this.lecref = lecref;
	}
	
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((classRef == null) ? 0 : classRef.hashCode());
		result = prime * result + ((file == null) ? 0 : file.hashCode());
		result = prime * result + ((lecref == null) ? 0 : lecref.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		
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
		VideoRequest other = (VideoRequest) obj;
		if (classRef == null) {
			if (other.classRef != null)
				return false;
		} else if (!classRef.equals(other.classRef))
			return false;
		if (file == null) {
			if (other.file != null)
				return false;
		} else if (!file.equals(other.file))
			return false;
		if (lecref == null) {
			if (other.lecref != null)
				return false;
		} else if (!lecref.equals(other.lecref))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		
		return true;
	}
	@Override
	public String toString() {
		return "VideoRequest [classRef=" + classRef + ", lecref=" + lecref + ", owner="
				+ owner + "]";
	}
	
	

}
