/**
 * 
 */
package com.stepform.stepform.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stepform.stepform.repository.ThreadRepository;
import com.stepform.stepform.model.Thread;


/**
 * @author Gonzalo.Cantos
 * @author Manuel.Vazquez
 */

@Service
public class ThreadServiceImpl implements ThreadService {

	@Autowired
	private ThreadRepository threadRepository;

	@Override
	public Thread saveThread(Thread thread) {
		return threadRepository.save(thread);
	}

	@Override
	public List<Thread> getAllThreads() {
		return threadRepository.findAll();
	}

	@Override
	public Optional<Thread> getThreadById(int id) {
		
		return threadRepository.findById(id);
	}



	
}
