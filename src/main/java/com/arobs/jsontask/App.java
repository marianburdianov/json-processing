package com.arobs.jsontask;

import com.arobs.jsontask.file_service.FileReaderService;
import com.arobs.jsontask.file_service.FileReaderServiceImpl;
import com.arobs.jsontask.json_service.*;
import com.arobs.jsontask.redis_service.RedisCommandsService;
import com.arobs.jsontask.redis_service.RedisCommandsServiceImpl;
import com.arobs.jsontask.redis_service.RedisStreamProducerService;
import com.arobs.jsontask.redis_service.RedisStreamProducerServiceImpl;
import com.arobs.jsontask.redis_service.coder_service.CoderService;
import com.arobs.jsontask.redis_service.coder_service.CoderServiceImpl;
import com.arobs.jsontask.redis_service.map_service.MapService;
import com.arobs.jsontask.redis_service.map_service.MapServiceImpl;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException, ParseException {
        FileReaderService fileReaderService = new FileReaderServiceImpl();

        FileContentToObjectConverterService fileContentToObjectConverterService =
                new FileContentToObjectConverterServiceImpl(fileReaderService);

        fileContentToObjectConverterService.getFileContentAsObject();

        ObjectToJsonArrayConverterService objectToJsonArrayConverterService =
                new ObjectToJsonArrayConverterServiceImpl(fileContentToObjectConverterService);

        JsonArrayToListOfJsonObjectsConverterService jsonArrayToListOfJsonObjectsConverter =
                new JsonArrayToListOfJsonObjectsConverterServiceImpl(objectToJsonArrayConverterService);

        jsonArrayToListOfJsonObjectsConverter.getListOfJsonObjectsFromJsonArray();

        CoderService coderService = new CoderServiceImpl();
        MapService mapService = new MapServiceImpl();
        RedisCommandsService redisCommandsService = new RedisCommandsServiceImpl();
        BidJsonObjectSelectorService bidJsonObjectSelectorService = new BidJsonObjectSelectorServiceImpl();
        JsonArrayToListOfJsonObjectsConverterService jsonArrayToListOfJsonObjectsConverterService =
                new JsonArrayToListOfJsonObjectsConverterServiceImpl(objectToJsonArrayConverterService);
        RedisStreamProducerService redisStreamProducerService =
                new RedisStreamProducerServiceImpl(
                        coderService,
                        mapService,
                        redisCommandsService,
                        bidJsonObjectSelectorService,
                        jsonArrayToListOfJsonObjectsConverterService);
        redisStreamProducerService.createResource();
    }
}