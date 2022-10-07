package com.stepform.stepform.service;

import java.util.List;


import com.stepform.stepform.model.Post;

/**
 * @author Gonzalo.Cantos
 * @author Manuel.Vazquez
 */

public interface PostService {

	public Post savePost(Post post);
	public List<Post> getAllPosts();
	public Post getPostById(int id);
	public List<Post> getPostsByThread(int id);
}
