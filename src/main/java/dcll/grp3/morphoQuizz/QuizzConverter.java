/* === This file is part of MorphoQuizz - <http://github.com/loclamor/morphoQuizz/> ===
*
* Copyright 2013, Rémi Benoit <r3m1.benoit@gmail.com>
* Copyright 2013, Loic Favier <favier.loic.31@gmail.com>
* Copyright 2013, Guillaume Jandin <guillaume.jandin1@gmail.com>
* Copyright 2013, Akram Mohammed Rhafrane <20contact12@gmail.com>
* Copyright 2013, Franck Arrecot <franck.arrecot@gmail.com>
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

package dcll.grp3.morphoQuizz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;

import de.odysseus.staxon.json.JsonXMLConfig;
import de.odysseus.staxon.json.JsonXMLConfigBuilder;
import de.odysseus.staxon.json.JsonXMLInputFactory;
import de.odysseus.staxon.json.JsonXMLOutputFactory;
import de.odysseus.staxon.xml.util.PrettyXMLEventWriter;

/**
 * Classe de conversion de Quizz de Xml en Json et inversement.
 *
 * @author LeGaliZ_mE
 *
 */
@SuppressWarnings("restriction")
public class QuizzConverter {

    /**
     * . Lit le fichier de quizz XML xmlInput, ecrit le test convertit en JSON
     * dans le fichier jsonOutput
     *
     * @param xmlInput
     *            Ficher de Quizz XML
     * @param jsonOutput
     *            Fichier de sortie JSON
     * @throws IOException
     *             exception entrée/sortie
     * @throws FactoryConfigurationError
     *             Erreur de configurations
     * @throws XMLStreamException
     *             exception de flux XML
     */
    public static void xmlQuizzToJson(final File xmlInput, final File jsonOutput)
            throws IOException, XMLStreamException, FactoryConfigurationError {

        InputStream is = new FileInputStream(xmlInput);
        OutputStream os = new FileOutputStream(jsonOutput);

        Reader r = new InputStreamReader(is, "UTF-8");
        Writer w = new OutputStreamWriter(os, "UTF-8");

        JsonXMLConfig config = new JsonXMLConfigBuilder().autoArray(true)
                .autoPrimitive(true).prettyPrint(true).build();
        try {
            /*
             * Create reader (XML).
             */
            XMLEventReader reader = XMLInputFactory.newInstance()
                    .createXMLEventReader(r);

            /*
             * Create writer (JSON).
             */
            XMLEventWriter writer = new JsonXMLOutputFactory(config)
                    .createXMLEventWriter(w);

            /*
             * Copy events from reader to writer.
             */
            writer.add(reader);

            /*
             * Close reader/writer.
             */
            reader.close();
            writer.close();
        } finally {
            /*
             * As per StAX specification, XMLEventReader/Writer.close() doesn't
             * close the underlying stream.
             */
            r.close();
            w.close();
            os.close();
            is.close();
        }
    }

    /**
     * . Lit le fichier de quizz json jsonInput, ecrit le test convertit en XML
     * dans le fichier xmlOutput .
     *
     * @param jsonInput
     *            Ficher de Quizz Json
     * @param xmlOutput
     *            Fichier de sortie XML
     * @throws IOException
     *             exception entrée/sortie
     * @throws FactoryConfigurationError
     *             Erreur de configurations
     * @throws XMLStreamException
     *             exception de flux XML
     */
    public static void jsonQuizzToXML(final File jsonInput, final File xmlOutput)
            throws IOException, XMLStreamException, FactoryConfigurationError {

        InputStream is = new FileInputStream(jsonInput);
        OutputStream os = new FileOutputStream(xmlOutput);

        Reader r = new InputStreamReader(is, "UTF-8");
        Writer w = new OutputStreamWriter(os, "UTF-8");

        JsonXMLConfig config = new JsonXMLConfigBuilder().multiplePI(false)
                .build();
        try {
            /*
             * Create reader (JSON).
             */
            XMLEventReader reader = new JsonXMLInputFactory(config)
                    .createXMLEventReader(r);

            /*
             * Create writer (XML).
             */
            XMLEventWriter writer = XMLOutputFactory.newInstance()
                    .createXMLEventWriter(w);
            writer = new PrettyXMLEventWriter(writer); // format output

            /*
             * Copy events from reader to writer.
             */
            writer.add(reader);

            /*
             * Close reader/writer.
             */
            reader.close();
            writer.close();
        } finally {
            /*
             * As per StAX specification, XMLEventReader/Writer.close() doesn't
             * close the underlying stream.
             */
            r.close();
            w.close();
            os.close();
            is.close();
        }
    }
}
