package org.hawks.cr.service;

import org.hawks.cr.models.*;
import java.util.*;

public interface ClassService {

	public CRClass createClass(CRClass classObj);
	
	public CRClass updateClass(CRClass classObj);
	
	public CRClass searchClassThroughName(String name);
	
	public List<CRClass> searchClassThroughUsername(String username);
	
	public List<CRClass> allClasses();
	
	public CRClass deleteClass(CRClass classObj);
	
}
