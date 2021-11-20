package com.arobs.jsontask.file_service;

import java.io.FileNotFoundException;
import java.io.FileReader;

public interface FileReaderService {
    FileReader getFileReader() throws FileNotFoundException;
}
