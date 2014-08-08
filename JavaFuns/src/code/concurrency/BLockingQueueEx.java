package code.concurrency;

import java.sql.Connection;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class BLockingQueueEx {
	private BlockingQueue<Connection> pool = new ArrayBlockingQueue<Connection>(
			10);
	private AtomicInteger connCount = new AtomicInteger();

	public Connection getConnection() throws InterruptedException {
		Connection conn = pool.poll(5, TimeUnit.SECONDS);
		if (conn == null) {
			synchronized (connCount) {
				if (connCount.get() < 10) {
					// conn = getNewConnection();
					pool.offer(conn);
					connCount.incrementAndGet();
				}
			}
			if (conn == null) {
				// throw new ConnUnavailException();
				return conn;
			} else {
				return conn;
			}
		}
		return conn;
	}
}
