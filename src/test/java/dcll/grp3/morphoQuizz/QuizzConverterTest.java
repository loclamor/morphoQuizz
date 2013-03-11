package dcll.grp3.morphoQuizz;

import java.io.File;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class QuizzConverterTest extends TestCase {
	
	protected String[] filesNames = { "quiz-moodle-exemple.xml", "quiz-moodle-exemple.json" };
	protected File testFolder, testInput, testOutput;
	protected String ext;
	
	public QuizzConverterTest (String testName) 
	{
		super(testName);
	}
	
	public static Test suite()
    {
        return new TestSuite(QuizzConverterTest.class);
    }
	
	 public void testQuizzConverter()
	 {
		 assertTrue(true);
	 }
	 
	 public void setUp() throws Exception {
		 super.setUp();
		 System.out.println("SetUp");

		 //creation du dossier data
		 testFolder = new File("data/tmp");
		 testFolder.mkdir(); 
		 
		 
	 }

	 public void tearDown() throws Exception {
		 super.tearDown();
		 System.out.println("TearDown");
		 //suppression des fichiers de tests
		 for (int i=0; i<filesNames.length; i++) {
			 File file = new File(testFolder.getPath() + "/" + filesNames[i]);
			 //file.delete();
		 }
		 //testFolder.delete();
	 }
	 
	public void testXMLQuizzToJson ()
			throws Exception {
		System.out.println("testXMLQuizzToJson");
		 //selection des fichiers xml dans data tmp
		 for (int i=0; i<filesNames.length; i++) {
			 testInput = new File("data/" + filesNames[i]);
			 if (testInput.getName().lastIndexOf(".") > 0) {
				 ext = testInput.getName().substring(testInput.getName().lastIndexOf("."));
				 //traitement selon l'extension
				 if (ext.equals(".xml")) {
					 testOutput = new File(testFolder.getPath() + "/" + filesNames[i].substring(0,filesNames[i].indexOf(".")) + ".json");
					 QuizzConverter.xmlQuizzToJson(testInput, testOutput);
					 assertTrue(testOutput.exists());
				 }
				 //verifie l'egalite entre 2 fichiers
			 }
		 }
	}
	
	public void testJsonQuizzToXML ()
			throws Exception {
		System.out.println("testJsonQuizzToXML");
		//selection des fichiers json dans data tmp
		 for (int i=0; i<filesNames.length; i++) {
			 testInput = new File("data/" + filesNames[i]);
			 if (testInput.getName().lastIndexOf(".") > 0) {
				 ext = testInput.getName().substring(testInput.getName().lastIndexOf("."));
				 //traitement selon l'extension
				 if (ext.equals(".json")) {
					 testOutput = new File(testFolder.getPath() + "/" + filesNames[i].substring(0,filesNames[i].indexOf(".")) + ".xml");
					 QuizzConverter.jsonQuizzToXML(testInput, testOutput);
					 assertTrue(testOutput.exists());
				 }
			 }
		 }
	}
	
	

}