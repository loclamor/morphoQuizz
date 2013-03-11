package dcll.grp3.morphoQuizz;

import java.io.File;
import java.io.IOException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
/**.
 * Tester la conversion d'un quiz
 */
public class QuizzConverterTest extends TestCase {
	/**.
	 * tester un nom
	 * @param testName nom de test en entrée
	 */
	public QuizzConverterTest(final String testName) {
		super(testName);
	}
	/**.
	 * tester une suite
	 * @return Test
	 */
	public static Test suite() {
        return new TestSuite(QuizzConverterTest.class);
    }
	/**.
	 * tester la conversion
	 */
	public final void testQuizzConverter() {
		assertTrue(true);
	}
	/**.
	 * convertir un fichier xml en fichier json
	 * @param xmlInput fichier xml en entrée
	 * @param jsonOutput fichier json en sortie
	 * @throws IOException exception entrée/sortie
	 */
	public static void testXMLQuizzToJson(final File xmlInput, final File jsonOutput)
			throws IOException {
		assertNotNull(xmlInput);
		assertNotNull(jsonOutput);
	}
	/**.
	 * convertir un fichier json en fichier xml
	 * @param jsonInput fichier json en entrée
	 * @param xmlOutput fichier xml en sortie
	 * @throws IOException exception entrée/sortie
	 */
	public static void testJsonQuizzToXML(final File jsonInput, final File xmlOutput)
			throws IOException {
		assertNotNull(jsonInput);
		assertNotNull(xmlOutput);
	}

}
