package org.hawks.cr.dao;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

@SuppressWarnings("all")
public interface DAO {
	
	public Object create(Object object);
	
	public Object delete(Object object);
	
	public Object readWithQuery(Query query, Class entity);
	
	public Object read(Class entity);
	
	public boolean update(Query query, Update update, Class entity);
	
	public boolean updateEveryOccurrence(Query query, Update update, Class entity);
	

}
