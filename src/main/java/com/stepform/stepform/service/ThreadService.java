
package com.stepform.stepform.service;
import com.stepform.stepform.model.Thread;

import java.util.List;


/**
 * @author Gonzalo.Cantos
 * @author Manuel.Vazquez
 */

public interface ThreadService {

	public Thread saveThread(Thread thread);
	public List<Thread> getAllThreads();

}
