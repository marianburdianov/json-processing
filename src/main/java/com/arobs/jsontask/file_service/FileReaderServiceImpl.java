package com.arobs.jsontask.file_service;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileReaderServiceImpl implements FileReaderService {

    @Override
    public FileReader getFileReader() throws FileNotFoundException {
        FileReader fileReader = new FileReader("bids.json");
        return fileReader;
    }
}
