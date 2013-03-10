package dcll.grp3.morphoQuizz;

import java.io.File;
import java.io.IOException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class QuizzConverterTest extends TestCase {
	public QuizzConverterTest (String testName) {
		super(testName);
	}
	public static Test suite() {
        return new TestSuite(QuizzConverterTest.class);
    }
	public void testQuizzConverter() {
		assertTrue(true);
	}

	public static void testXMLQuizzToJson(File xmlInput, File jsonOutput)
			throws IOException {
		assertNotNull(xmlInput);
		assertNotNull(jsonOutput);
	}
	public static void testJsonQuizzToXML(File jsonInput, File xmlOutput)
			throws IOException {
		assertNotNull(jsonInput);
		assertNotNull(xmlOutput);
	}

}
