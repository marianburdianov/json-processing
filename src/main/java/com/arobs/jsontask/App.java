package com.arobs.jsontask;

import com.arobs.jsontask.file_service.JsonFileReaderService;
import com.arobs.jsontask.file_service.JsonFileReaderServiceImpl;

public class App {
    public static void main(String[] args) {

        JsonFileReaderService jsonFileReaderService = new JsonFileReaderServiceImpl();
        jsonFileReaderService.getListOfBidObjectsFromJsonFile();
    }
}
