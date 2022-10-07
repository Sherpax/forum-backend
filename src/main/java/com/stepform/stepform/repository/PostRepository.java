package com.stepform.stepform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stepform.stepform.model.Post;

/**
 * @author Gonzalo.Cantos
 * @author Manuel.Vazquez
 */

@Repository
public interface PostRepository  extends JpaRepository<Post, Integer>{

	@Query(value="SELECT * FROM Post p WHERE p.thread_id = :id", nativeQuery = true)
	List<Post> findByThread(int id);
	
}
