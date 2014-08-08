package code.io;

import java.nio.ByteBuffer;

public class ByteBufferEx {

	public static void main(String[] args) {
		String msg = "This is a log message not so small that you can use to test. I hope you have fun and it works well!";
		byte[] msgBytes = msg.getBytes();

		ByteBuffer bb = ByteBuffer.allocate(1024);

		long start = System.nanoTime();
		bb.put(msgBytes);
		long end = System.nanoTime();

		System.out.println("Time: " + (end - start));
	}

}
