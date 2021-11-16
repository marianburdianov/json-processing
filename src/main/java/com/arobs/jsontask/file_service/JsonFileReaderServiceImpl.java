package com.arobs.jsontask.file_service;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JsonFileReaderServiceImpl implements JsonFileReaderService {

    @Override
    public JSONArray getListOfBidObjectsFromJsonFile() {

        JSONParser jsonParser = new JSONParser();
        JSONArray bidList = null;

        try (FileReader fileReader = new FileReader("bids.json")) {

            Object object = jsonParser.parse(fileReader);
            bidList = (JSONArray) object;
            System.out.println(bidList);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return bidList;
    }
}
