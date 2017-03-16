package com.telekha.empinfo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.telekha.empinfo.model.Leaverequest;
@Repository
public class LeaveRepository {
	@Autowired
	private MongoTemplate mongoTemplate;
	
	private static final String LEAVEREQUEST_COLLECTION_NAME="Leave";
	
	
	public void create(Leaverequest leaverequest) {
		mongoTemplate.insert(leaverequest, LEAVEREQUEST_COLLECTION_NAME);

	    }
	 public Leaverequest  createdid(String createdid){
		 Query query = new Query(Criteria.where("createdid").is(createdid));
         return mongoTemplate.findOne(query, Leaverequest.class,LEAVEREQUEST_COLLECTION_NAME);		    	
			}

	public void update(Leaverequest emp) {
		mongoTemplate.save(emp, LEAVEREQUEST_COLLECTION_NAME);	
		
	}
}
