package code.concurrency;

import java.util.concurrent.atomic.AtomicReference;

public class NonBlockingTradeUpdate {
	/***
	 * This TradeVolume Class must be Immutable otherwise it may create Java
	 * Memory Model Problems while using with Atomic Reference. All the fields
	 * must be final to guarantee the initialization and assignment at the same
	 * time from other thread.
	 */
	private static class TradeVolume {
		final long quantity;
		final long price;

		private TradeVolume(long quantity, long price) {
			this.quantity = quantity;
			this.price = price;
		}
	}

	private final AtomicReference<TradeVolume> tradeVol = new AtomicReference<>(
			new TradeVolume(100, 200));

	public long getQuantity() {
		return tradeVol.get().quantity;
	}

	public long getPrice() {
		return tradeVol.get().price;
	}

	/**
	 * A non-blocking update method which updates the TradeVolume Object using
	 * AtomicReference. This method is likely to perform better under multi-core
	 * environment with low thread contention.
	 * 
	 * @param quantity
	 *            Quantity of the Trade
	 * @param price
	 *            Price of the Trade
	 */
	public void update(long quantity, long price) {
		while (true) {
			TradeVolume oldValue = tradeVol.get();
			TradeVolume newValue = new TradeVolume(quantity, price);
			if (tradeVol.compareAndSet(oldValue, newValue))
				return;
		}
	}
}