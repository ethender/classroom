package org.hawks.cr.models;

import org.springframework.data.mongodb.core.mapping.Document;
import java.util.*;
import javax.persistence.Id;


@Document(collection="class")
public class CRClass {

	@Id
	private String _id;
	private String name;
	private String creator;
	private Date dateOfCreate;
	private int enrollers;
	private Date lastModified;
	
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public Date getDateOfCreate() {
		return dateOfCreate;
	}
	public void setDateOfCreate(Date dateOfCreate) {
		this.dateOfCreate = dateOfCreate;
	}
	public int getEnrollers() {
		return enrollers;
	}
	public void setEnrollers(int enrollers) {
		this.enrollers = enrollers;
	}
	public Date getLastModified() {
		return lastModified;
	}
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
	

	
	public String toString() {
		return "CRClass [_id=" + _id + ", name=" + name + ", creator=" + creator + ", dateOfCreate=" + dateOfCreate
				+ ", enrollers=" + enrollers + ", lastModified=" + lastModified + "]";
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_id == null) ? 0 : _id.hashCode());
		result = prime * result + ((creator == null) ? 0 : creator.hashCode());
		result = prime * result + ((dateOfCreate == null) ? 0 : dateOfCreate.hashCode());
		result = prime * result + enrollers;
		result = prime * result + ((lastModified == null) ? 0 : lastModified.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CRClass other = (CRClass) obj;
		if (_id == null) {
			if (other._id != null)
				return false;
		} else if (!_id.equals(other._id))
			return false;
		if (creator == null) {
			if (other.creator != null)
				return false;
		} else if (!creator.equals(other.creator))
			return false;
		if (dateOfCreate == null) {
			if (other.dateOfCreate != null)
				return false;
		} else if (!dateOfCreate.equals(other.dateOfCreate))
			return false;
		if (enrollers != other.enrollers)
			return false;
		if (lastModified == null) {
			if (other.lastModified != null)
				return false;
		} else if (!lastModified.equals(other.lastModified))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
		
	
	
	
}
