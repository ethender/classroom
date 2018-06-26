package org.hawks.cr.service;

import org.hawks.cr.models.Video;
import org.hawks.cr.models.VideoRequest;
import java.util.*;

public interface VideoService {
	
	
	public Video createVideo(VideoRequest request);
	
	public Video updateVideo(VideoRequest rquest);
	
	public Video readVideoByRef(String ref);
	
	public List<Video> readVideoByLectures(Video video);
	
	public List<Video> readVideoByClass(Video video);
	
	public Video deleteVideo(Video video);

}
