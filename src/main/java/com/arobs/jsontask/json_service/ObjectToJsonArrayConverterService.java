package com.arobs.jsontask.json_service;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public interface ObjectToJsonArrayConverterService {
    JSONArray getObjectAsJsonArray() throws IOException, ParseException;
}
