package dcll.grp3.morphoQuizz;

import java.io.File;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
        	File xml = new File("quiz-moodle-exemple.xml");
        	File json = new File("test.json");
        	File newXml = new File("test.xml");
			QuizzConverter.XMLQuizzToJson(xml, json);
			QuizzConverter.JsonQuizzToXML(json, newXml);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
