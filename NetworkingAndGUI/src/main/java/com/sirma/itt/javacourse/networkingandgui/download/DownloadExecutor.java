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
public class DownloadExecutor implements Runnable {

	private String url;
	private FileDownloadUI downloader;
	private int contentLength;
	private int transferred;

	/**
	 * Creates a file downloader using the URL given to download a file.
	 * 
	 * @param url
	 *            the URL to the file.
	 * @param downloader
	 *            the client that uses this worker process.
	 */
	public DownloadExecutor(String url, FileDownloadUI downloader) {
		this.url = url;
		this.downloader = downloader;
	}

	/**
	 * Downloads a file from the given url.
	 */
	public void downloadFile() {
		URL downloadURL;
		URLConnection connection;
		try {
			downloadURL = new URL(url);
			connection = downloadURL.openConnection();
		} catch (MalformedURLException e) {
			downloader.getResult().setText("Invalid URL");
			return;
		} catch (IOException e) {
			downloader.getResult().setText("Could not open the file");
			return;
		}
		String[] splitURL = url.split("[/]");
		String fileName = splitURL[splitURL.length - 1];
		Path path = Paths.get(System.getProperty("user.home"), "Documents", fileName);
		try (BufferedOutputStream out = new BufferedOutputStream(Files.newOutputStream(path,
				StandardOpenOption.CREATE));
				InputStream input = downloadURL.openStream();
				BufferedInputStream in = new BufferedInputStream(input);) {
			contentLength = connection.getContentLength();
			downloader.getProgress().setMaximum(contentLength);
			int step = 1024 * 10;
			int read;
			byte[] buffer = new byte[step];
			transferred = 0;
			while ((read = in.read(buffer)) > 0) {
				transferred += read;
				out.write(buffer, 0, read);
				downloader.getProgress().setValue(transferred);
			}
		} catch (IOException e) {
			throw new RuntimeException("General I/O exception", e);
		}
		downloader.getResult().setText("Done");
	}

	@Override
	public void run() {
		downloadFile();
	}

	/**
	 * @return the contentLength
	 */
	public int getContentLength() {
		return contentLength;
	}

	/**
	 * @return the transferred
	 */
	public int getTransferred() {
		return transferred;
	}

}
