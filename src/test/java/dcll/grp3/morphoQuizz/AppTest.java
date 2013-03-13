package dcll.grp3.morphoQuizz;

import java.io.File;

import org.apache.commons.io.FileUtils;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
    private File testFolder;

    /**
     * . Create the test case
     *
     * @param testName
     *            name of the test case
     */
    public AppTest(final String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        // System.out.println("SetUp");

        // creation du dossier data
        testFolder = new File("data/tmp");
        testFolder.mkdir();

    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();
        // System.out.println("TearDown");

        // suppression des fichiers de tests
        FileUtils.deleteDirectory(testFolder);
    }

    /**
     * . Rigourous Test :-)
     */
    public final void testApp() {
        String[] xmlToJson = {"-xj", "data/quiz-moodle-exemple.xml", testFolder.getPath() + "/testAPP.json"};
        String[] jsonToXml = {"-jx", "data/quiz-moodle-exemple.json", testFolder.getPath() + "/testAPP.xml"};
        String[] illegalArg = {"illegal arg", "data/quiz-moodle-exemple.xml", testFolder.getPath() + "/testAPP.json"};
        String[] illegalNumberArg = {"illegal test arguments"};

        
        App.main(xmlToJson);
        assertTrue(new File(xmlToJson[2]).exists());
        
        App.main(jsonToXml);
        assertTrue(new File(jsonToXml[2]).exists());
        
        try{
            App.main(illegalArg);
        }catch(IllegalArgumentException e){
            assertTrue("IllegalArgumentException",true);
        }
        
        try{
            App.main(illegalNumberArg);
        }catch(IllegalArgumentException e){
            assertTrue("IllegalArgumentException",true);
        }
    }
}
