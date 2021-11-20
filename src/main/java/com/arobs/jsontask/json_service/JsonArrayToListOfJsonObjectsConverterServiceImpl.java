package com.arobs.jsontask.json_service;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;

public class JsonArrayToListOfJsonObjectsConverterServiceImpl implements JsonArrayToListOfJsonObjectsConverterService {
    private final ObjectToJsonArrayConverterService objectToJsonArrayConverterService;

    public JsonArrayToListOfJsonObjectsConverterServiceImpl(ObjectToJsonArrayConverterService objectToJsonArrayConverterService) {
        this.objectToJsonArrayConverterService = objectToJsonArrayConverterService;
    }

    @Override
    public List<JSONObject> getListOfJsonObjectsFromJsonArray() throws IOException, ParseException {
        List<JSONObject> listOfJsonObjects = objectToJsonArrayConverterService.getObjectAsJsonArray().stream().toList();
        return listOfJsonObjects;
    }
}
