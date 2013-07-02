/**
 * 
 */
package com.sirma.itt.javacourse.neterowkingandgui.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sirma.itt.javacourse.networkingandgui.download.DownloadFile;
import com.sirma.itt.javacourse.networkingandgui.download.Downloader;

/**
 * Tests the logic behind the file download tool.
 * @author Georgi
 *
 */
public class DownloaderTest {
	
	/**
	 * Tests the download agent using a test file.
	 */
	@Test
	public void testDownload(){
		Downloader downloader=new Downloader(0, 0);
		downloader.setVisible(false);
		DownloadFile download=new DownloadFile("http://download.thinkbroadband.com/5MB.zip", downloader);
		download.downloadFile();
		assertEquals(download.getTransferred(),download.getContentLength());
	}
}
