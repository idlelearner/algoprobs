package code;

public class ProducerConsumer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String tasks[] = { "test", "test1", "test2", "test3", "test4" };
		ProducerConsumerTest test = new ProducerConsumerTest(tasks);
		new Thread(test.producer, "Producer").start();
		new Thread(test.consumer, "Consumer").start();
	}

	private static class ProducerConsumerTest {

		private String currentTask;
		final String[] producerTasks;
		final Producer producer;
		final Consumer consumer;

		public ProducerConsumerTest(String[] producerTasks) {
			this.producerTasks = producerTasks;
			producer = new Producer();
			consumer = new Consumer();
		}

		private class Producer implements Runnable {

			Producer() {
			}

			public void run() {
				synchronized (ProducerConsumerTest.this) {
					int i = 0;
					while (i < producerTasks.length) {
						if (currentTask == null) {
							currentTask = producerTasks[i++];
							System.out.println("Producing:" + currentTask);
							ProducerConsumerTest.this.notify();
						}
						try {
							ProducerConsumerTest.this.wait();
						} catch (InterruptedException e) {
							// do Nothing
						}
					}
				}
			}
		}

		private class Consumer implements Runnable {

			Consumer() {
			}

			public void run() {
				synchronized (ProducerConsumerTest.this) {
					int i = 0;
					while (i < producerTasks.length) {
						if (currentTask != null) {
							System.out.println("Consuming:" + currentTask);
							i++;
							currentTask = null; // *
							ProducerConsumerTest.this.notify();
						}
						try {
							ProducerConsumerTest.this.wait();
						} catch (InterruptedException e) {
							// do Nothing
						}
					}
				}
			}
		}
	}

}