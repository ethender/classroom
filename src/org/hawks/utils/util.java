package org.hawks.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.*;

public class util {

	
	public static String removeSpecialChars(String s) {
		ArrayList<Character> result = new ArrayList<Character>();
		char[] arr = s.toCharArray();
		for(char c: arr) {
			if(Character.isLetterOrDigit(c)) {
				result.add(c);
			}
		}
		
		StringBuffer buf = new StringBuffer();
		for(char c: result) {
			buf.append(c);
		}
		
		return buf.toString();
	}
	
	
	
	
	
	public static Date getDateNow() {
		return (new Date());
	}
	
	public static  ExecutorService getExecutor() {
		ExecutorService service = Executors.newSingleThreadExecutor();
		return service;
	}
	
}
