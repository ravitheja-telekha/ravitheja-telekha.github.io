package com.telekha.empinfo.model;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Post")
public class Post {

	
	 @Id
	 private String id;
	 private Date createTS;
	 private Date updateTS;
	 private String createdBy;
	 private String createdName;
	

	/*@Size(max = 20)
	List<PostImage> images;*/
	
	public String getId() {
		return id;
	}



	public Date getCreateTS() {
		return createTS;
	}



	public Date getUpdateTS() {
		return updateTS;
	}



	public String getCreatedBy() {
		return createdBy;
	}



	public String getCreatedName() {
		return createdName;
	}



	public void setCreateTS(Date createTS) {
		this.createTS = createTS;
	}



	public void setUpdateTS(Date updateTS) {
		this.updateTS = updateTS;
	}



	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}



	public void setCreatedName(String createdName) {
		this.createdName = createdName;
	}



	


	public void setId(String id) {
		this.id = id;
	}



	


	
}
