package com.arobs.jsontask;

import com.arobs.jsontask.file_service.JsonFileReaderService;
import com.arobs.jsontask.file_service.JsonFileReaderServiceImpl;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        JsonFileReaderService jsonFileReaderService = new JsonFileReaderServiceImpl();
        jsonFileReaderService.getListOfBidObjectsFromJsonFile();
    }
}
