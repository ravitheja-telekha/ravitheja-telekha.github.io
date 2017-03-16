package com.telekha.empinfo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.telekha.empinfo.model.Post;

@Repository
public class PostRepository {
	@Autowired
	private MongoTemplate mongoTemplate;
   private static final String POST_COLLECTION_NAME = "Post";
	
	
   public Post create(Post post) {
		mongoTemplate.insert(post, POST_COLLECTION_NAME);
		return post;
	}
}
