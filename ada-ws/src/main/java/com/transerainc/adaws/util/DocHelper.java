package com.transerainc.adaws.util;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.transerainc.adaws.exception.InterpretationException;

@Component
public class DocHelper {

    private static Logger LOGGER = LoggerFactory.getLogger(DocHelper.class.getName());

    private DocumentBuilder builder;

    private DocHelper() {
        super();
        final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            builder = factory.newDocumentBuilder();
        } catch (final ParserConfigurationException e) {
            LOGGER.error("Failed to create document builder", e);
        }
    }

    public synchronized Document xmlToDom(String xml) throws InterpretationException {
        xml = xml.trim();
        final InputSource src = new InputSource(new StringReader(xml));
        Document document = null;
        try {
            document = builder.parse(src);
        } catch (final SAXException e) {
            LOGGER.warn("Unexpected input" + e);
            throw new InterpretationException("Unexpected input", e);
        } catch (final IOException e) {
            LOGGER.warn("IO Error when trying to parse xml" + e);
            throw new InterpretationException("IO Error when trying to parse xml", e);
        }
        return document;

    }

}
