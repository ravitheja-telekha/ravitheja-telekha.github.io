package com.telekha.empinfo.controller;

import java.security.Principal;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.telekha.empinfo.model.Post;
import com.telekha.empinfo.repository.PostRepository;


public class PostController {
	
	@Autowired 
	 private PostRepository  postRepository;
	
	@RequestMapping("/post")
	public String image(Model model)
	{
		return "post";
	}

/*
	@RequestMapping()
	public Post create( @ModelAttribute("Post") Post post ,Model model) {
						
		Date currentdate = new Date();
		post.setCreatedBy(post.getId());
		post.setCreateTS(currentdate);		
		post.setUpdateTS(currentdate);
		post.setCreatedName(post.getCreatedName());
		
		
		PostImage tempPostImg = null;
		if(post.getImages() != null) {
			for(int i = 0 ; i < post.getImages().size() ; i++) {
				
				tempPostImg = post.getImages().get(i);
				
				tempPostImg.setCreatedById(appUser.getId());
				tempPostImg.setCreatedName(appUserName);
				tempPostImg.setCreatedTS(currentdate);
				tempPostImg.setContainerName(AppUserFileContainer.TELEKHA_POST_IMG);
			}
}*/
}
