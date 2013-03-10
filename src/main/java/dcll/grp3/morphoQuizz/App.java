package dcll.grp3.morphoQuizz;
import java.io.File;

/**
 * Hello world!
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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
