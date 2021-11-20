package com.arobs.jsontask.json_service;

import com.arobs.jsontask.file_service.FileReaderService;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class FileContentToObjectConverterServiceImpl implements FileContentToObjectConverterService {
    private final FileReaderService fileReaderService;

    public FileContentToObjectConverterServiceImpl(FileReaderService fileReaderService) {
        this.fileReaderService = fileReaderService;
    }

    @Override
    public Object getFileContentAsObject() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = fileReaderService.getFileReader();

        return jsonParser.parse(fileReader);
    }
}
