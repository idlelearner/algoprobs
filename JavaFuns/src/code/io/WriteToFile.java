package code.io;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class WriteToFile {
	/**
	 * 
	 * @param limit
	 *            Long
	 * @throws IOException
	 *             IOException
	 */
	public void writeToFileNIOWay(File file) throws IOException {
		FileOutputStream fileOutputStream = new FileOutputStream(file, true);
		FileChannel fileChannel = fileOutputStream.getChannel();
		ByteBuffer byteBuffer = null;
		String messageToWrite = null;
		for (int i = 1; i < 1000000; i++) {
			messageToWrite = "This is a test üüüüüüööööö";
			byteBuffer = ByteBuffer.wrap(messageToWrite.getBytes(Charset
					.forName("ISO-8859-1")));
			fileChannel.write(byteBuffer);

		}

	}

	/**
	 * 
	 * @param limit
	 *            Long
	 * @throws IOException
	 *             IOException
	 */
	public void writeToFileIOWay(File file) throws IOException {
		FileOutputStream fileOutputStream = new FileOutputStream(file, true);
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
				fileOutputStream, 128 * 100);
		String messageToWrite = null;
		for (int i = 1; i < 1000000; i++) {
			messageToWrite = "This is a test üüüüüüööööö";
			bufferedOutputStream.write(messageToWrite.getBytes(Charset
					.forName("ISO-8859-1")));
		}
		bufferedOutputStream.flush();
		fileOutputStream.close();
	}

	private File createFile(String FILE_PATH) throws IOException {
		File file = new File(FILE_PATH + "test_sixth_one.txt");
		file.createNewFile();
		return file;
	}
}
