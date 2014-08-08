package code.designpatterns;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;
import java.util.concurrent.ConcurrentHashMap;

interface HttpDownloader {
	public File download(URI uri, String fileName) throws IOException;
}

class RealHttpDownloader implements HttpDownloader {
	@Override
	public File download(URI uri, String fileName) throws IOException {
		Path path = Paths.get(fileName);
		long totalBytesRead = 0L;
		HttpURLConnection con = (HttpURLConnection) uri.resolve(fileName)
				.toURL().openConnection();
		con.setReadTimeout(10000);
		con.setConnectTimeout(10000);
		try (ReadableByteChannel rbc = Channels
				.newChannel(con.getInputStream());
				FileChannel fileChannel = FileChannel.open(path, EnumSet.of(
						StandardOpenOption.CREATE, StandardOpenOption.READ,
						StandardOpenOption.WRITE));) {
			// download file with max size 4MB
			totalBytesRead = fileChannel.transferFrom(rbc, 0, 1 << 22);
			System.out.println("totalBytesRead = " + totalBytesRead);
			
			// save the downloaded file
			File oFilePath = new File("C:\\tmp\\downloads\\" + fileName);
			FileOutputStream fos = new FileOutputStream(oFilePath);
			FileChannel saveFileChannel = fos.getChannel();
			fileChannel.transferTo(0, fileChannel.size(), saveFileChannel);

			saveFileChannel.close();
			fileChannel.close();
			rbc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return path.toFile();
	}
}

class CachedHttpDownloader implements HttpDownloader {
	private final HttpDownloader delegate;
	private final ConcurrentHashMap<URI, File> cache = new ConcurrentHashMap<>(
			100);

	public CachedHttpDownloader(HttpDownloader delegate) {
		this.delegate = delegate;
	}

	@Override
	public File download(URI uri, String fileName) throws IOException {
		if (cache.contains(uri))
			return cache.get(uri);
		return delegate.download(uri, fileName);
	}
}

public class DecoratorDesignPattern {
	public static void main(String[] args) throws URISyntaxException,
			IOException {
		CachedHttpDownloader downloader = new CachedHttpDownloader(
				new RealHttpDownloader());
		URI uri = new URI("http://eofdreams.com/data_images/dreams/tiger/");
		downloader.download(uri, "tiger-02.jpg");

	}
}
