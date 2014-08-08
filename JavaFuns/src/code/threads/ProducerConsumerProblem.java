package code.threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProducerConsumerProblem {
	public static Object exit = new Object();

	public static void main(String args[]) {
		BlockingQueue sharedBlockingQueue = new LinkedBlockingQueue(1);
		Thread producerThread = new Thread(new Producer(sharedBlockingQueue));
		Thread consumerThread = new Thread(new Consumer(sharedBlockingQueue));
		producerThread.start();
		consumerThread.start();
	}
}

class Producer implements Runnable {
	private final BlockingQueue sharedQueue;

	public Producer(BlockingQueue sharedQueue) {
		this.sharedQueue = sharedQueue;
	}

	@Override
	public void run() {
		int i = 0;
		while (i < 10) {
			try {
				System.out.println("Produced: " + i);
				sharedQueue.put(i);
				TimeUnit.MILLISECONDS.sleep(10);
			} catch (InterruptedException ex) {
				Logger.getLogger(Producer.class.getName()).log(Level.SEVERE,
						null, ex);
			}
			i++;
		}
		try {
			sharedQueue.put(ProducerConsumerProblem.exit);
		} catch (InterruptedException e) {
		}
	}
}

class Consumer implements Runnable {
	private final BlockingQueue sharedQueue;

	public Consumer(BlockingQueue sharedQueue) {
		this.sharedQueue = sharedQueue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Object item = sharedQueue.take();
				System.out.println("Consumed: " + item);
				if (item == ProducerConsumerProblem.exit)
					break;
			} catch (InterruptedException ex) {
				Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}
	}
}