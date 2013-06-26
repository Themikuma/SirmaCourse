package com.sirma.itt.javacourse.networkingandgui.download;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Downloads a file on a different thread.
 * 
 * @author gdimitrov
 */
public class DownloadFile implements Runnable {

	private String url;
	private Downloader downloader;

	/**
	 * Creates a file downloader using the URL given to download a file.
	 * 
	 * @param url
	 *            the URL to the file.
	 * @param downloader
	 *            the client that uses this worker process.
	 */
	public DownloadFile(String url, Downloader downloader) {
		this.url = url;
		this.downloader = downloader;
	}

	/**
	 * Downloads a file from the given url.
	 * 
	 * @param url
	 *            the url of the file.
	 */
	public void downloadFile(String url) {
		try {
			URL downloadURL = new URL(url);
			String[] splitURL = url.split("[/]");
			String fileName = splitURL[splitURL.length - 1];
			Path path = Paths.get(System.getProperty("user.home"), "Documents", fileName);
			BufferedOutputStream out = new BufferedOutputStream(Files.newOutputStream(path,
					StandardOpenOption.CREATE));
			URLConnection connection = downloadURL.openConnection();
			InputStream input = downloadURL.openStream();
			BufferedInputStream in = new BufferedInputStream(input);
			int contentLength = connection.getContentLength();
			downloader.getProgress().setMaximum(contentLength);
			int step = 1024 * 10;
			int read;
			byte[] buffer = new byte[step];
			int transferred = 0;
			try {
				while ((read = in.read(buffer)) > 0) {
					transferred += read;
					out.write(buffer, 0, read);
					downloader.getProgress().setValue(transferred);
				}
				in.close();
				out.close();
			} catch (IOException e) {
				throw new RuntimeException("General I/O exception", e);
			}
			System.out.println(connection.getContentLength());
			System.out.println(transferred);
		} catch (MalformedURLException e) {
			downloader.getResult().setText("Invalid URL");
			return;
		} catch (IOException e) {
			downloader.getResult().setText("Could not open the file");
			return;
		}
		downloader.getResult().setText("Done");
	}

	@Override
	public void run() {
		downloadFile(url);
	}
}
