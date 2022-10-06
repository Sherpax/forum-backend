package com.stepform.stepform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stepform.stepform.model.Post;
import com.stepform.stepform.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService{

	
	@Autowired
	private PostRepository postRepository;

	@Override
	public Post savePost(Post post) {
		return postRepository.save(post);
	}

	@Override
	public List<Post> getAllPosts() {
		return postRepository.findAll();
	}
	
	
}
