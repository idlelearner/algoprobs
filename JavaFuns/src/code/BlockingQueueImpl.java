package code;

import java.util.ArrayList;

public class BlockingQueueImpl {
	private final ArrayList<Integer> queue;
	private final int maxSize;

	public BlockingQueueImpl(int maxSize) {
		this.maxSize = maxSize;
		queue = new ArrayList<>(maxSize);
	}

	public synchronized void put(int elmt) throws InterruptedException {
		while (queue.size() == maxSize)
			wait();
		queue.add(elmt);
		notify();
	}

	public synchronized int take() throws InterruptedException {
		while (queue.isEmpty())
			wait();
		int elmt = queue.remove(0);
		notify();
		return elmt;
	}

}