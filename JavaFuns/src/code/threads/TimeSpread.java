package code.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class TimeSpread {
	final AtomicBoolean started = new AtomicBoolean(false);
	final AtomicInteger stopCounter;
	long startTime;
	long stopTime;

	public TimeSpread(int threads) {
		stopCounter = new AtomicInteger(threads);
	}

	public void start() {
		if (!started.get()) {
			if (started.compareAndSet(false, true)) {
				startTime = System.currentTimeMillis();
			}
		}
	}

	public void stop() {
		if (stopCounter.getAndDecrement() == 1) {
			stopTime = System.currentTimeMillis();
		}
	}

	public long timeConsumed() {
		return stopTime - startTime;
	}

	public static void main(String[] args) throws InterruptedException {
		int threads = 300;
		final TimeSpread timeSpread = new TimeSpread(threads);
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
		List<Thread> list = new ArrayList<>(threads);
		for (int i = 0; i < threads; i++) {
			Thread thread = new Thread(t);
			thread.start();
			list.add(thread);
		}
		for (Thread thread : list) {
			thread.join();
		}
		System.out.println("time spread = " + timeSpread.timeConsumed());
	}
}