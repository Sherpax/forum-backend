package com.stepform.stepform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stepform.stepform.model.Post;

/**
 * @author Gonzalo.Cantos
 * @author Manuel.Vazquez
 */

@Repository
public interface PostRepository  extends JpaRepository<Post, Integer>{

}
