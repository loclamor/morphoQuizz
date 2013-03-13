package dcll.grp3.morphoQuizz;

import java.io.File;

/**
 *  Classe principale de l'application.
 *
 */
public class App {
    /**
     * Methode main.
     *
     * @param args
     *            stocker les entrées
     */
    public static void main(final String[] args) {
        if (args.length != 3) {
            throw new IllegalArgumentException(
                    "Usage : app (-xj/-jx) [xmlInput] [jsonOutput]");
        }

        File inputFile = new File(args[1]);
        File outputFile = new File(args[2]);

        try {
            if (args[0].equals("-xj")) {
                QuizzConverter.xmlQuizzToJson(inputFile, outputFile);
            } else {
                if (args[0].equals("-jx")) {
                    QuizzConverter.jsonQuizzToXML(inputFile, outputFile);
                } else {
                    throw new IllegalArgumentException(
                            "Usage : app (-xj/-jx) [xmlInput] [jsonOutput]");
                }
            }

            System.out.println("Quizz convertit dans : "
                    + outputFile.getAbsolutePath());

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
