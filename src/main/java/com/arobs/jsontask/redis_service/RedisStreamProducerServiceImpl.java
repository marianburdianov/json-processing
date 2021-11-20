package com.arobs.jsontask.redis_service;

import com.arobs.jsontask.json_service.BidJsonObjectSelectorService;
import com.arobs.jsontask.json_service.JsonArrayToListOfJsonObjectsConverterService;
import com.arobs.jsontask.redis_service.coder_service.CoderService;
import com.arobs.jsontask.redis_service.map_service.MapService;
import io.lettuce.core.api.sync.RedisStreamCommands;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class RedisStreamProducerServiceImpl implements RedisStreamProducerService {
    private final CoderService coderService;
    private final MapService mapService;
    private final RedisCommandsService redisCommandsService;
    private final BidJsonObjectSelectorService bidJsonObjectSelectorService;
    private final JsonArrayToListOfJsonObjectsConverterService jsonArrayToListOfJsonObjectsConverterService;

    private static final Logger LOGGER = LogManager.getLogger(RedisStreamProducerServiceImpl.class);

    public RedisStreamProducerServiceImpl(CoderService coderService, MapService mapService, RedisCommandsService redisCommandsService,
                                          BidJsonObjectSelectorService bidJsonObjectSelectorService,
                                          JsonArrayToListOfJsonObjectsConverterService jsonArrayToListOfJsonObjectsConverterService) {
        this.coderService = coderService;
        this.mapService = mapService;
        this.redisCommandsService = redisCommandsService;
        this.bidJsonObjectSelectorService = bidJsonObjectSelectorService;
        this.jsonArrayToListOfJsonObjectsConverterService = jsonArrayToListOfJsonObjectsConverterService;
    }

    @Override
    public void createResource() throws IOException, ParseException {
        RedisStreamCommands<String, String> commands = redisCommandsService.getRedisCommands();
        List<JSONObject> listOfJsonObjects = jsonArrayToListOfJsonObjectsConverterService
                .getListOfJsonObjectsFromJsonArray();

        for (JSONObject bidJsonObject : listOfJsonObjects) {
            JSONObject jsonObjectFromBidJsonObject = null;

            Map<String, String> bidMap;
            String streamName = null;
            String decodedString = null;

            jsonObjectFromBidJsonObject = bidJsonObjectSelectorService
                    .getNestedJsonObjectFromBidJsonObject(bidJsonObject);
            bidMap = mapService.getSpecificMapBasedOnBidType(jsonObjectFromBidJsonObject);

            bidMap.put("bid", jsonObjectFromBidJsonObject.toString());
            decodedString = coderService.getDecodedPayLoad((String) jsonObjectFromBidJsonObject.get("pl"));
            streamName = mapService.getStreamNameBasedOnJsonType(jsonObjectFromBidJsonObject);

            LOGGER.info(String.format("Adding bidObject : %s", bidMap.get("bid")));
            LOGGER.info(String.format("Adding id : %s", jsonObjectFromBidJsonObject.get("id")));
            LOGGER.info(String.format("Adding ts : %s", jsonObjectFromBidJsonObject.get("ts")));
            LOGGER.info(String.format("Adding ty : %s", jsonObjectFromBidJsonObject.get("ty")));
            LOGGER.info(String.format("Adding pl : %s", decodedString));

            commands.xadd(streamName, bidMap);
        }
    }
}
