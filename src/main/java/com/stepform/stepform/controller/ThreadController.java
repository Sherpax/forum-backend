/**
 * 
 */
package com.stepform.stepform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stepform.stepform.service.ThreadService;
import com.stepform.stepform.model.Thread;

/**
 * @author Gonzalo.Cantos
 * @author Manuel.Vazquez
 */

@RestController
@RequestMapping("/thread")
@CrossOrigin
public class ThreadController {

	
	@Autowired
	private ThreadService threadService;
	
	@GetMapping(path = "/getAll")
	public List<Thread> getAllThreads(){
		return threadService.getAllThreads();
	}
}
