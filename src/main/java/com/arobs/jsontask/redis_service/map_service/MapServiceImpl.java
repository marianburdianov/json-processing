package com.arobs.jsontask.redis_service.map_service;

import org.json.simple.JSONObject;

import java.rmi.NoSuchObjectException;
import java.util.HashMap;
import java.util.Map;

public class MapServiceImpl implements MapService {

    @Override
    public Map<String, String> getSpecificMapBasedOnBidType(JSONObject jsonObject) throws NoSuchObjectException {

        if (jsonObject.get("ty").equals("AQ")) {
            Map<String, String> aqMap = new HashMap<>();
            return aqMap;
        } else if (jsonObject.get("ty").equals("ZU")) {
            Map<String, String> zuMap = new HashMap<>();
            return zuMap;
        }
        throw new NoSuchObjectException("Don't have any match");
    }

    @Override
    public String getStreamNameBasedOnJsonType(JSONObject jsonObject) throws NoSuchObjectException {
        if (jsonObject.get("ty").equals("AQ")) {
            return "aq_bid_stream";
        } else if (jsonObject.get("ty").equals("ZU")) {
            return "zu_bid_stream";
        }
        throw new NoSuchObjectException("Don't have any match");
    }
}