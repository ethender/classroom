package org.hawks.cr.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="upload")
public class Upload {

	
	private String _id;
	private String fileLocation;
	private String fileOriginalPath;
	private String mediaType;
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getFileLocation() {
		return fileLocation;
	}
	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}
	public String getFileOriginalPath() {
		return fileOriginalPath;
	}
	public void setFileOriginalPath(String fileOriginalPath) {
		this.fileOriginalPath = fileOriginalPath;
	}
	public String getMediaType() {
		return mediaType;
	}
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_id == null) ? 0 : _id.hashCode());
		result = prime * result + ((fileLocation == null) ? 0 : fileLocation.hashCode());
		result = prime * result + ((fileOriginalPath == null) ? 0 : fileOriginalPath.hashCode());
		result = prime * result + ((mediaType == null) ? 0 : mediaType.hashCode());
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
		Upload other = (Upload) obj;
		if (_id == null) {
			if (other._id != null)
				return false;
		} else if (!_id.equals(other._id))
			return false;
		if (fileLocation == null) {
			if (other.fileLocation != null)
				return false;
		} else if (!fileLocation.equals(other.fileLocation))
			return false;
		if (fileOriginalPath == null) {
			if (other.fileOriginalPath != null)
				return false;
		} else if (!fileOriginalPath.equals(other.fileOriginalPath))
			return false;
		if (mediaType == null) {
			if (other.mediaType != null)
				return false;
		} else if (!mediaType.equals(other.mediaType))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Upload [_id=" + _id + ", fileLocation=" + fileLocation + ", fileOriginalPath=" + fileOriginalPath
				+ ", mediaType=" + mediaType + "]";
	}
	
	
}
