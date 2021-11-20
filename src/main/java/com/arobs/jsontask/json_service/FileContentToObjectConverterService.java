package com.arobs.jsontask.json_service;

import org.json.simple.parser.ParseException;

import java.io.IOException;

public interface FileContentToObjectConverterService {
    Object getFileContentAsObject() throws IOException, ParseException;
}
