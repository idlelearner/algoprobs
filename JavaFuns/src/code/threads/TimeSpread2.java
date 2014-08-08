package code.threads;

import java.util.concurrent.TimeUnit;

public class TimeSpread2 {
	int i;
	int threads;
	long startTime;
	long stopTime;
	boolean started = false;

	public TimeSpread2(int threads) {
		this.threads = threads;
	}

	public synchronized void start() {
		System.out.println("startthread" + (i++));
		if (!started) {
			started = true;
			startTime = System.currentTimeMillis();
		}
	}

	public synchronized void stop() {
		System.out.println("thread" + (i++));
		if (--threads <= 0) {
			stopTime = System.currentTimeMillis();
			notifyAll();
		}
	}

	public synchronized long timeSpread() throws InterruptedException {
		while (threads > 0) {
			wait();
		}
		return stopTime - startTime;
	}

	public static void main(String[] args) throws InterruptedException {
		int threads1 = 100;
		final TimeSpread2 timeSpread = new TimeSpread2(threads1);
		Runnable t = new Runnable() {
			public void run() {
				timeSpread.start();
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
				}
				timeSpread.stop();
			}
		};
		for (int i = 0; i < threads1; i++) {
			Thread thread = new Thread(t);
			thread.start();
		}
		System.out.println("time spread = " + timeSpread.timeSpread());
	}
}