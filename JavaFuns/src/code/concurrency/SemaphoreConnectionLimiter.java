package code.concurrency;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.Semaphore;

public class SemaphoreConnectionLimiter {
	private final Semaphore semaphore;

	private SemaphoreConnectionLimiter(int maxConcurrentRequests) {
		semaphore = new Semaphore(maxConcurrentRequests);
	}

	public URLConnection acquire(URL url) throws InterruptedException,
			IOException {
		semaphore.acquire();
		return url.openConnection();
	}

	public void release(URLConnection conn) {
		try {
			/*
			 * ... clean up here
			 */
		} finally {
			semaphore.release();
		}
	}
}