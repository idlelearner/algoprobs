package code.concurrency;

import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileLockTest {

	public static void main(String[] args) throws Exception {

		FileLock fileLock = null;

		try (RandomAccessFile file = new RandomAccessFile("FileToBeLocked",
				"rw");) {
			FileChannel fileChannel = file.getChannel();

			fileLock = fileChannel.tryLock();
			if (fileLock != null) {
				System.out.println("File is locked");
				accessTheLockedFile();
			}
		} finally {
			if (fileLock != null) {
				fileLock.release();
			}
		}
	}

	static void accessTheLockedFile() {

		try {
			FileInputStream input = new FileInputStream("FileToBeLocked");
			int data = input.read();
			System.out.println(data);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}