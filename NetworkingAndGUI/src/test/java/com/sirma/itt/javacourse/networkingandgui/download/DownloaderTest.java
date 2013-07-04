/**
 * 
 */
package com.sirma.itt.javacourse.networkingandgui.download;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests the logic behind the file download tool.
 * 
 * @author Georgi
 */
public class DownloaderTest {

	/**
	 * Tests the download agent using a test file.
	 */
	@Test
	public void testDownload() {
		FileDownloadUI downloader = new FileDownloadUI(0, 0);
		downloader.setVisible(false);
		DownloadExecutor download = new DownloadExecutor(
				"http://download.thinkbroadband.com/5MB.zip", downloader);
		download.downloadFile();
		assertEquals(download.getTransferred(), download.getContentLength());
	}
}
