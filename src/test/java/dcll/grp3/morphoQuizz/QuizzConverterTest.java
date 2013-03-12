package dcll.grp3.morphoQuizz;

import java.io.File;
import java.io.FileInputStream;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.custommonkey.xmlunit.XMLTestCase;

public class QuizzConverterTest extends XMLTestCase {
	
	protected String[] filesNames = { "quiz-moodle-exemple.xml", "quiz-moodle-exemple.json" };
	protected File testFolder, testInput, testOutput, testOutput2;
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
		 FileUtils.deleteDirectory(testFolder);
	 }
	 
	public void testXMLQuizzToJson ()
			throws Exception {
		System.out.println("testXMLQuizzToJson");
		testInput = new File("data/quiz-moodle-exemple.xml");
		testOutput = new File(testFolder.getPath() + "/testXML2JSON_xml2json.json");
		testOutput2 = new File(testFolder.getPath() + "/testXML2JSON_json2xml.xml");
		
		//conversion XML2JSON
		System.out.println("conversion XML à JSON");
		QuizzConverter.xmlQuizzToJson(testInput, testOutput);
		assertTrue("Conversion XML en JSON faite", testOutput.exists());
		
		//RECONVERSION JSON2XML pour verifier l'egalite entre les 2 fichiers
		System.out.println("reconversion JSON à XML");
		QuizzConverter.jsonQuizzToXML(testOutput, testOutput2);
		assertTrue("Reconversion JSON en XML faite", testOutput2.exists());
		
		FileInputStream original = new FileInputStream(testInput);
		FileInputStream converti = new FileInputStream(testOutput2);
		
		try{			
			String inputXML = IOUtils.toString(original);
			String outputXML = IOUtils.toString(converti);
			
			String myControlXML = "<msg><uuid>0x00435A8C</uuid></msg>";
			String myTestXML = "<msg><uuid>0x00435A8C</uuid></msg>";
			assertXMLEqual(myControlXML, myTestXML);
	
			assertXMLEqual("fichiers XML egaux", inputXML, outputXML);
		}finally{
			original.close();
			converti.close();
		}
	}
	
	public void testJsonQuizzToXML ()
			throws Exception {
		System.out.println("testJsonQuizzToXML");
		//selection des fichiers json dans data tmp
		 
		 testInput = new File("data/quiz-moodle-exemple.json");
		 testOutput = new File(testFolder.getPath() + "/testJSON2XML_json2xml.xml");
		 testOutput2 = new File(testFolder.getPath() + "/testJSON2XML_xml2json.json");
		 
		 System.out.println("conversion JSON à XML");
		 QuizzConverter.jsonQuizzToXML(testInput, testOutput);
		 assertTrue("Conversion JSON en XML faite", testOutput.exists());
		 
		 System.out.println("reconversion XML à JSON");
		 QuizzConverter.xmlQuizzToJson(testOutput, testOutput2);
		 assertTrue("Reconversion XML en JSON faite", testOutput2.exists());
		 
		 FileInputStream inputStream = new FileInputStream(testInput);
		 FileInputStream outputStream = new FileInputStream(testOutput2);
		 
		 try{
			 String inputJSON = IOUtils.toString(inputStream);
			 String outputJSON = IOUtils.toString(outputStream);
			 
			 //nettoyage des JSON
			 inputJSON = inputJSON.replaceAll("[\r\n\t]+", "");
			 outputJSON = outputJSON.replaceAll("[\r\n\t]+", "");
			 
			 assertEquals("JSON origine et JSON générés egaux", inputJSON, outputJSON);
		 }finally{
			 inputStream.close();
			 outputStream.close();
		 }
		 
	}
	
	

}