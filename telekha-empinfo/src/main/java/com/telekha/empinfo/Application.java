package com.telekha.empinfo;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;



@SpringBootApplication
public class Application 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(Application.class, args);
    }
}

@Configuration
class MongoConfiguration {
	@Value("${telekha.empinfo.mongo.host}")
	private String mongoHost;
	@Value("${telekha.empinfo.mongo.port}")
	private String mongoPort;
	@Value("${telekha.empinfo.mongo.db}")
	private String mongoDB;
	@Value("${telekha.empinfo.mongo.username}")
	private String mongoUserName;
	@Value("${telekha.empinfo.mongo.password}")
	private String mongoPassword;

@Bean
public MongoDbFactory getMongoDbFactory() throws UnknownHostException {
	List<ServerAddress> serverList = new ArrayList<ServerAddress>();
	serverList.add(new ServerAddress(mongoHost, Integer.parseInt(mongoPort)));
	List<MongoCredential> credsList = new ArrayList<MongoCredential>();
	credsList.add(MongoCredential.createCredential(mongoUserName, mongoDB, mongoPassword.toCharArray()));
	MongoClient mongoclient = new MongoClient(serverList, credsList);
	return new SimpleMongoDbFactory(mongoclient, mongoDB);
}

public @Bean
MongoTemplate mongoTemplate() throws Exception {
	
	MongoTemplate mongoTemplate = new MongoTemplate(getMongoDbFactory());
			
	return mongoTemplate;
	
	}
}