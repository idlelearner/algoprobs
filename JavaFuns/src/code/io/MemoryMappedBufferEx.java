package code.io;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel.MapMode;

public class MemoryMappedBufferEx {
	public static void main(String[] args) {
		File file = new File("mMapFile.txt");
		String msg = "This is a log message not so small that you can use to test. I hope you have fun and it works well!";
		byte[] msgBytes = msg.getBytes();
		try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
			MappedByteBuffer mappedBuffer = raf.getChannel().map(
					MapMode.READ_WRITE, 0, 80000);

			long start = System.nanoTime();
			for(int i=0;i<100; i++){
				mappedBuffer.put(msgBytes);
				mappedBuffer.flip();
			}
			long end = System.nanoTime();

			System.out.println("Time: " + (end - start));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}//273824
