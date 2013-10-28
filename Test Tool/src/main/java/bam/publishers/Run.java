package bam.publishers;

/**
 * @author gdimitrov
 */
public class Run {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestToolDataPublisher publisher = new TestToolDataPublisher();
		publisher.publishData("C:\\Users\\user\\Desktop\\data.csv");
	}
}
