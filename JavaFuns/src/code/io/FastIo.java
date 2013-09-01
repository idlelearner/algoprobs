package code.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.MappedByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;
import java.util.zip.CRC32;

public class FastIo {
	public static long calculateCRC(File filename) {
		final int SIZE = 16 * 1024;
		try (FileInputStream in = new FileInputStream(filename);) {
			CRC32 crc = new CRC32();
			FileChannel channel = in.getChannel();
			int length = (int) channel.size();
			MappedByteBuffer mb = channel.map(FileChannel.MapMode.READ_ONLY, 0,
					length);
			byte[] bytes = new byte[SIZE];
			int nGet;
			while (mb.hasRemaining()) {
				nGet = Math.min(mb.remaining(), SIZE);
				mb.get(bytes, 0, nGet);
				crc.update(bytes, 0, nGet);
			}
			return crc.getValue();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		throw new RuntimeException("unknown IO error occurred ");
	}

	public boolean download(String rootUrl, String fileName) throws IOException {
		Path path = Paths.get(fileName);
		long totalBytesRead = 0L;
		HttpURLConnection con = (HttpURLConnection) new URL(rootUrl + fileName)
				.openConnection();
		con.setReadTimeout(10000);
		con.setConnectTimeout(10000);
		try (ReadableByteChannel rbc = Channels
				.newChannel(con.getInputStream());
				FileChannel fileChannel = FileChannel.open(path, EnumSet.of(
						StandardOpenOption.CREATE, StandardOpenOption.WRITE));) {
			// download file with max size 4MB
			totalBytesRead = fileChannel.transferFrom(rbc, 0, 1 << 22);
			System.out.println("Total Bytes Read : " + totalBytesRead);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
	}
}
