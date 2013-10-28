package bam.publishers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Logger;

import org.wso2.carbon.databridge.agent.thrift.DataPublisher;
import org.wso2.carbon.databridge.agent.thrift.exception.AgentException;
import org.wso2.carbon.databridge.commons.exception.AuthenticationException;
import org.wso2.carbon.databridge.commons.exception.DifferentStreamDefinitionAlreadyDefinedException;
import org.wso2.carbon.databridge.commons.exception.MalformedStreamDefinitionException;
import org.wso2.carbon.databridge.commons.exception.StreamDefinitionException;
import org.wso2.carbon.databridge.commons.exception.TransportException;

public class TestToolDataPublisher {
	private DataPublisher dataPublisher = null;
	private String stream = null;
	private static final String SEPARATOR = ",";
	private static final Logger LOGGER = Logger.getLogger(TestToolDataPublisher.class.getName());

	/**
	 * @see http ://wso2.com/library/articles/2012/07/creating-custom-agents-publish -events-bamcep/
	 * @param args
	 * @throws Exception
	 */

	/**
	 * Initializes the data publisher and the data stream.
	 */
	private void initPublisherAndStream() {
		System.setProperty(
				"javax.net.ssl.trustStore",
				"C:\\Users\\user\\workspace\\BAM\\wso2bam-2.3.0\\wso2bam-2.3.0\\repository\\resources\\security\\client-truststore.jks");
		System.setProperty("javax.net.ssl.trustStorePassword", "wso2carbon");

		try {
			dataPublisher = new DataPublisher("ssl://10.131.2.223:7711", "tcp://10.131.2.223:7611",
					"admin", "admin");
		} catch (MalformedURLException e) {
			LOGGER.severe("BAM server not found");
		} catch (AgentException e) {
			LOGGER.severe("The data publisher failed to start");
			e.printStackTrace();
		} catch (AuthenticationException e) {
			LOGGER.severe("Connecting to the server failed due to wrong user credentials.");
		} catch (TransportException e) {
			LOGGER.severe("Connection timed out");
		}

		String streamDefinition = "{'name':'TestToolData','version':'1.0.1',"
				+ " 'nickName': 'Test data','description': 'This is the data sent from the test tool.',"
				+ " 'metaData':[{'name':'fieldID','type':'STRING'} ]," + " 'payloadData':["
				+ "           {'name':'Username','type':'STRING'},"
				+ "           {'name':'Activity','type':'STRING'},"
				+ "           {'name':'Date','type':'STRING'} ] }";

		try {
			stream = dataPublisher.defineStream(streamDefinition);
		} catch (AgentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedStreamDefinitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (StreamDefinitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DifferentStreamDefinitionAlreadyDefinedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void publishData(String filePath) {
		initPublisherAndStream();
		Path path = Paths.get(filePath);
		String line = "";
		try (Scanner scanner = new Scanner(path)) {
			while (scanner.hasNextLine()) {
				line = scanner.nextLine();
				Object[] payload = createPayload(line);
				dataPublisher.publish(stream, new Object[] { "127.0.0.1" }, null, payload);
			}
		} catch (IOException e) {
			System.out.println("File not found");
		} catch (AgentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dataPublisher.stop();
	}

	private Object[] createPayload(String data) {
		String[] fields = data.split(SEPARATOR);
		Object[] payloadObject = new Object[] { fields[0], fields[1], fields[2] };
		return payloadObject;
	}

}
