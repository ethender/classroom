package org.hawks.cr.daoimpl;

import org.hawks.cr.dao.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository("dao")
@SuppressWarnings("all")
public class DAOImpl implements DAO{
	
	@Autowired
	@Qualifier("mongoTemplate")
	private MongoTemplate mongo;

	
	public Object create(Object object) {
		mongo.insert(object);
		return object;
	}

	
	public Object delete(Object object) {
		mongo.remove(object);
		return object;
	}

	
	public Object readWithQuery(Query query, Class entity) {
		System.out.println("Found : "+mongo.count(query, entity)+".");
		return mongo.find(query, entity);
	}
	
	

	public Object read(Class entity) {
		return mongo.findAll(entity);
	}



	public boolean update(Query query, Update update, Class entity) {
		try {
			 mongo.updateFirst(query, update, entity);
			 return  true;
		}catch(Exception ex) {
			System.err.println("Exception ocurred while during update");
			return false;
		}
	}



	public boolean updateEveryOccurrence(Query query, Update update, Class entity) {
		try {
			 mongo.updateMulti(query, update, entity);
			 return  true;
		}catch(Exception ex) {
			System.err.println("Exception ocurred while during update");
			return false;
		}
	}

	

	


	

}
