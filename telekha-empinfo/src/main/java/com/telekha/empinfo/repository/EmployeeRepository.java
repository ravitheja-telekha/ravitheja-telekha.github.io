package com.telekha.empinfo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.telekha.empinfo.model.Employee;
import com.telekha.empinfo.model.Leaverequest;


@Repository
public class EmployeeRepository {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	private static final String EMPLOYEE_COLLECTION_NAME="Employee";


	public void create(Employee employee) {
		//System.out.println("Repository:"+employee.getFname());
		mongoTemplate.insert(employee, EMPLOYEE_COLLECTION_NAME);

	    }
	
	public Employee  findByempId(String searchbyid){
		
	    Query query = new Query(Criteria.where("empid").is(searchbyid));
		 return mongoTemplate.findOne(query, Employee.class, EMPLOYEE_COLLECTION_NAME);	 
		}
	
	 public List<Employee> getallemployeesList(){
			return mongoTemplate.findAll(Employee.class,EMPLOYEE_COLLECTION_NAME);
		}
	 
	 
	 public void deleteById(String id) {
			Query query = new Query(Criteria.where("id").is(id));
			mongoTemplate.remove(query, Employee.class,EMPLOYEE_COLLECTION_NAME);
		}
	 
	 public Employee  findbyid(String id){
		 Query query = new Query(Criteria.where("id").is(id));
         return mongoTemplate.findOne(query, Employee.class,EMPLOYEE_COLLECTION_NAME);		    	
			}
	 
	  public void update(Employee employee) {
			mongoTemplate.save(employee, EMPLOYEE_COLLECTION_NAME);	
		}
	  
	  
	  
		public Employee  findByEmailId(String email){			
		    Query query = new Query(Criteria.where("email").is(email));
			 return mongoTemplate.findOne(query, Employee.class, EMPLOYEE_COLLECTION_NAME);	 
			}
		
		
		
}



