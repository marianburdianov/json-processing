package com.arobs.jsontask.json_service;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;

public interface JsonArrayToListOfJsonObjectsConverterService {
    List<JSONObject> getListOfJsonObjectsFromJsonArray() throws IOException, ParseException;
}
