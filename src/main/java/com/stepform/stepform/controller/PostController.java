/**
 * 
 */
package com.stepform.stepform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stepform.stepform.model.Post;
import com.stepform.stepform.model.User;
import com.stepform.stepform.service.PostService;
import com.stepform.stepform.service.UserService;

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
	
	
	private UserService userService;
	
	@GetMapping(path="/getAll")
	public List<Post> getAllPosts(){
		return postService.getAllPosts();
	}
	
	@PostMapping(path="/add")
	public String addPost(Post post, @RequestBody int userId) {
		//TODO 
		User user = new User();
		post.setUser(user);
		post.getUser().setId(userId);
		if(post != null) {
			postService.savePost(post);
			return "New post have been added";
		}
		
		return "Post NOT added";
	}
	
	@GetMapping(path="/get/{id}")
	public List<Post> getPostsFromThread(@PathVariable String id){
		//TODO
		return postService.getAllPosts();
	}
	
}
