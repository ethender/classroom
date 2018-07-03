package org.hawks.cr.service;

import org.hawks.cr.models.Upload;


public interface UploadService {

	
	public Upload createUpload(Upload upload);
	
	public Upload readUpload(String ref);
	
	public Upload deleteUpload(Upload upload);
	
}
