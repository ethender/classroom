package org.hawks.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.*;

public class util {

	
	public static Date getDateNow() {
		return (new Date());
	}
	
	public static  ExecutorService getExecutor() {
		ExecutorService service = Executors.newSingleThreadExecutor();
		return service;
	}
	
}
