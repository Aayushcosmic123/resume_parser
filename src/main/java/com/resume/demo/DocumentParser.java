package com.resume.demo;

import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.sax.BodyContentHandler;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.exception.TikaException;

import java.io.IOException;
import java.io.InputStream;

public class DocumentParser {
    public static String parseDocument(InputStream stream) throws IOException, TikaException {
        AutoDetectParser parser = new AutoDetectParser();
        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        ParseContext context = new ParseContext();

        try {
            parser.parse(stream, handler, metadata, context);
            return handler.toString();
        } catch (Exception e) {
            throw new TikaException("Error parsing document", e);
        }
    }
}
