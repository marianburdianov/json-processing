package com.arobs.jsontask.json_service;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class ObjectToJsonArrayConverterServiceImpl implements ObjectToJsonArrayConverterService {
    private final FileContentToObjectConverterService fileContentToObjectConverterService;

    public ObjectToJsonArrayConverterServiceImpl(FileContentToObjectConverterService fileContentToObjectConverterService) {
        this.fileContentToObjectConverterService = fileContentToObjectConverterService;
    }

    @Override
    public JSONArray getObjectAsJsonArray() throws IOException, ParseException {
        Object object = fileContentToObjectConverterService.getFileContentAsObject();

        return (JSONArray) object;
    }
}
