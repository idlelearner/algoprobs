package code;

/**
 * Singleton pattern example with Double checked Locking
 */
public class DoubleCheckedLockingSingleton {
	private volatile DoubleCheckedLockingSingleton INSTANCE;

	private DoubleCheckedLockingSingleton() {
	}

	public DoubleCheckedLockingSingleton getInstance() {
		if (INSTANCE == null) {
			synchronized (DoubleCheckedLockingSingleton.class) {
				// double checking Singleton instance
				if (INSTANCE == null) {
					INSTANCE = new DoubleCheckedLockingSingleton();
				}
			}
		}
		return INSTANCE;
	}
}

// Read more:
// http://javarevisited.blogspot.com/2012/07/why-enum-singleton-are-better-in-java.html#ixzz2rJ9qHeim