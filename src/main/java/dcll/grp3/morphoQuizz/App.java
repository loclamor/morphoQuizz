package dcll.grp3.morphoQuizz;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

/**
 * Classe principale de l'application
 *
 */
public class App {
	/**.
	 * Methode main
	 * @param args stocker les entrées
	 */
    public static void main(final String[] args) {
        try {
        	File xml = new File("quiz-moodle-exemple.xml");
        	File json = new File("test.json");
        	File newXml = new File("test.xml");

        	QuizzConverter.xmlQuizzToJson(xml, json);
			QuizzConverter.jsonQuizzToXML(json, newXml);
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setNamespaceAware(true);
			dbf.setCoalescing(true);
			dbf.setIgnoringElementContentWhitespace(true);
			dbf.setIgnoringComments(true);
			DocumentBuilder db = dbf.newDocumentBuilder();

			Document doc1 = db.parse(xml);
			doc1.normalizeDocument();

			Document doc2 = db.parse(newXml);
			doc2.normalizeDocument();

			//Assert.assertTrue(doc1.isEqualNode(doc2));
			System.out.println(doc1.isEqualNode(doc2));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
