package dcll.grp3.morphoQuizz;

import java.io.File;
/* === This file is part of MorphoQuizz - <http://github.com/loclamor/morphoQuizz/> ===
*
* Copyright 2013, Rémi Benoit <r3m1.benoit@gmail.com>
* Copyright 2013, Akram Mohammed Rhafrane <20contact12@gmail.com>
*
* MorphoQuizz is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* MorphoQuizz is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with MorphoQuizz . If not, see <http://www.gnu.org/licenses/>.
*/

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
