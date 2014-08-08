package code.concurrency;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//http://www.javacodegeeks.com/2011/09/java-concurrency-tutorial-reentrant.html
public class ReentrantLockCalculator {
	private int calculatedValue;
	private int value;
	private ReadWriteLock lock = new ReentrantReadWriteLock();

	public void calculate(int value) {
		lock.writeLock().lock();
		try {
			this.value = value;
			// this.calculatedValue = doMySlowCalculation(value);
		} finally {
			lock.writeLock().unlock();
		}
	}

	public int getCalculatedValue() {
		lock.readLock().lock();
		try {
			return calculatedValue;
		} finally {
			lock.readLock().unlock();
		}
	}

	public int getValue() {
		lock.readLock().lock();
		try {
			return value;
		} finally {
			lock.readLock().unlock();
		}
	}
}