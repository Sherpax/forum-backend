/**
 * 
 */
package com.stepform.stepform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stepform.stepform.model.Post;
import com.stepform.stepform.service.PostService;

/**
 * @author Gonzalo.Cantos
 * @author Manuel.Vazquez
 */

@RestController
@RequestMapping("/post")
@CrossOrigin
public class PostController {

	@Autowired
	private PostService postService;
	
	@GetMapping(path="/getAll")
	public List<Post> getAllPosts(){
		return postService.getAllPosts();
	}
	
	@PostMapping(path="/add")
	public String addPost(Post post) {
		
		if(post != null) {
			postService.savePost(post);
			return "New post have been added";
		}
		
		return "Post NOT added";
	}
	
}
