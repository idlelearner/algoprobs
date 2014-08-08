package code.threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Message {
	private String msg;

	public Message(String str) {
		this.msg = str;
	}

	public String getMsg() {
		return msg;
	}

}

class ProducerService implements Runnable {

	private BlockingQueue<Message> queue;

	public ProducerService(BlockingQueue<Message> q) {
		this.queue = q;
	}

	@Override
	public void run() {
		// produce messages
		for (int i = 0; i < 100; i++) {
			Message msg = new Message("" + i);
			try {
				Thread.sleep(i);
				queue.put(msg);
				System.out.println("Produced " + msg.getMsg());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// adding exit message
		Message msg = new Message("exit");
		try {
			queue.put(msg);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

class ConsumerService implements Runnable {

	private BlockingQueue<Message> queue;

	public ConsumerService(BlockingQueue<Message> q) {
		this.queue = q;
	}

	@Override
	public void run() {
		try {
			Message msg;
			// consuming messages until exit message is received
			while ((msg = queue.take()).getMsg() != "exit") {
				Thread.sleep(10);
				System.out.println("Consumed " + msg.getMsg());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class ProducerConsumerService {

	public static void main(String[] args) {
		// Creating BlockingQueue of size 10
		BlockingQueue<Message> queue = new ArrayBlockingQueue<>(10);
		ProducerService producer = new ProducerService(queue);
		ConsumerService consumer = new ConsumerService(queue);
		// starting producer to produce messages in queue
		new Thread(producer).start();
		// starting consumer to consume messages from queue
		new Thread(consumer).start();
		System.out.println("Producer and Consumer has been started");
	}

}