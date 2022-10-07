/**
 * 
 */
package com.stepform.stepform.controller;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stepform.stepform.model.Post;
import com.stepform.stepform.model.Thread;
import com.stepform.stepform.model.User;
import com.stepform.stepform.service.CategoryService;
import com.stepform.stepform.service.PostService;
import com.stepform.stepform.service.ThreadService;
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

	@Autowired
	private UserService userService;

	@Autowired
	private ThreadService threadService;
	
	@Autowired
	private CategoryService categoryService;

	private final String SUGGESTION = "Suggestion";
	private final String QUESTION = "Question";
	private final String CLARIFICATION = "Clarification";

	@GetMapping(path="/getAll")
	public List<Post> getAllPosts(){
		return postService.getAllPosts();
	}

	@PostMapping(path="/add/{threadId}/{userId}")
	public ResponseEntity<String> addPost(@RequestBody Post post, @PathVariable String threadId, @PathVariable String userId) {

		JSONObject entity = new JSONObject();
		
		int iThreadId = Integer.parseInt(threadId);

		int iUserId = Integer.parseInt(userId);
		Optional<User> user = userService.getUserById(iUserId);
		Optional<Thread> thread = threadService.getThreadById(iThreadId);

		String categoryName = post.getImg();
		String imgPath = "";
		
		try {
			switch (categoryName) {
			case SUGGESTION:
				imgPath = new File(getClass().getResource("/img/idea.png").getFile()).getPath();
				break;

			case QUESTION:
				imgPath = new File(getClass().getResource("/img/conversation.png").getFile()).getPath();
				break;
				
			case CLARIFICATION:				
				imgPath = new File(getClass().getResource("/img/lightbulb.png").getFile()).getPath();
				break;
			default:
				imgPath = new File(getClass().getResource("/img/conversation.png").getFile()).getPath();
				break;
			}
			
			
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		if(!user.isEmpty() && !thread.isEmpty()) {
			post.setUser(user.get());
			post.setThread(thread.get());
			post.setCategory(categoryService.getCategoryByTitle(post.getImg()));
			post.setImg(imgPath);
		}

		if(post != null) {
			postService.savePost(post);
			entity.put("msg", "Post succesfully published");
			return ResponseEntity.status(HttpStatus.CREATED).body(entity.toString());
		} 

		entity.put("msg", "Unable to publish post");
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(entity.toString());
	}

	@GetMapping(path="/get/{id}")
	public List<Post> getPostsFromThread(@PathVariable String id){
		int threadId = Integer.parseInt(id);

		return postService.getPostsByThread(threadId);
	}

}
