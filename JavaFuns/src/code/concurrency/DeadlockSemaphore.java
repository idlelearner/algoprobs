package code.concurrency;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class DeadlockSemaphore {
	public static void main(String[] args) throws Exception {
		Semaphore s1 = new Semaphore(1);
		Semaphore s2 = new Semaphore(1);

		Thread t = new Thread(new DoubleResourceGrabber(s1, s2));
		t.setName("t");
		// now reverse them ... here comes trouble!
		Thread t2 = new Thread(new DoubleResourceGrabber(s2, s1));
		t2.setName("t2");

		t.start();
		t2.start();

//		t.join();
//		t2.join();
		System.out.println("We got lucky!");
	}

	private static class DoubleResourceGrabber implements Runnable {
		private Semaphore first;
		private Semaphore second;

		public DoubleResourceGrabber(Semaphore s1, Semaphore s2) {
			first = s1;
			second = s2;
		}

		public void run() {
			try {
				Thread t = Thread.currentThread();
				System.out.println(t.getName());
				first.tryAcquire(100, TimeUnit.MILLISECONDS);
				System.out.println(t + " acquired first " + first);

				Thread.sleep(200); // demonstrate deadlock

				System.out.println(t + " acquired second " + second);
				second.tryAcquire(100, TimeUnit.MILLISECONDS);
				
				first.release();
				System.out.println(t + " released " + first);

				second.release();
				System.out.println(t + " released " + second);

				
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
}