package dcll.grp3.morphoQuizz;

import java.io.File;
import java.io.IOException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * . Tester la conversion d'un quiz
 */
public class QuizzConverterTest extends TestCase {

	protected String[] filesNames = { "quiz-moodle-exemple.xml",
			"quiz-moodle-exemple.json" };
	protected File testFolder, testInput, testOutput;
	protected String ext;

	/**
	 * . tester un nom
	 * 
	 * @param testName
	 *            nom de test en entrée
	 */
	public QuizzConverterTest(final String testName) {
		super(testName);
	}

	/**
	 * . tester une suite
	 * 
	 * @return Test
	 */
	public static Test suite() {
		return new TestSuite(QuizzConverterTest.class);
	}

	/**
	 * . tester la conversion
	 */
	public final void testQuizzConverter() {
		assertTrue(true);
	}

	public void setUp() throws Exception {
		super.setUp();
		System.out.println("SetUp");

		// creation du dossier data
		testFolder = new File("data");
		testFolder.mkdir();

		// lecture des fichiers dans data
		for (int i = 0; i < filesNames.length; i++) {
			testInput = new File(testFolder.getPath() + "/" + filesNames[i]);
			if (testInput.getName().lastIndexOf(".") > 0) {
				ext = testInput.getName().substring(
						testInput.getName().lastIndexOf("."));
				// traitement selon l'extension
				if (ext.equals(".xml")) {
					testOutput = new File(testFolder.getPath()
							+ "/"
							+ filesNames[i].substring(0,
									filesNames[i].indexOf(".")) + ".json");
					QuizzConverter.xmlQuizzToJson(testInput, testOutput);
					assertTrue(testOutput.exists());
				} else if (ext.equals(".json")) {
					testOutput = new File(testFolder.getPath()
							+ "/"
							+ filesNames[i].substring(0,
									filesNames[i].indexOf(".")) + ".xml");
					QuizzConverter.jsonQuizzToXML(testInput, testOutput);
					assertTrue(testOutput.exists());
				} else {
					System.out
							.println("Aucun fichier a convertir n'est present ! (.xml ou .json)");
				}
			}
		}

	}

	public void tearDown() throws Exception {
		super.tearDown();
		System.out.println("TearDown");
		// suppression des fichiers de tests
		for (int i = 0; i < filesNames.length; i++) {
			File file = new File(testFolder.getPath() + "/" + filesNames[i]);
			file.delete();
		}
		testFolder.delete();
	}

	/**
	 * . convertir un fichier xml en fichier json
	 * 
	 * @param xmlInput
	 *            fichier xml en entrée
	 * @param jsonOutput
	 *            fichier json en sortie
	 * @throws IOException
	 *             exception entrée/sortie
	 */
	public static void testXMLQuizzToJson(final File xmlInput,
			final File jsonOutput) throws IOException {
		System.out.println("testXMLQuizzToJson");
	}

	/**
	 * . convertir un fichier json en fichier xml
	 * 
	 * @param jsonInput
	 *            fichier json en entrée
	 * @param xmlOutput
	 *            fichier xml en sortie
	 * @throws IOException
	 *             exception entrée/sortie
	 */
	public static void testJsonQuizzToXML(final File jsonInput,
			final File xmlOutput) throws IOException {
		System.out.println("testJsonQuizzToXML");
	}

}
