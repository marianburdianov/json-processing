package com.arobs.jsontask.redis_service.map_service;

import org.json.simple.JSONObject;

import java.rmi.NoSuchObjectException;
import java.util.Map;

public interface MapService {
    Map<String, String> getSpecificMapBasedOnBidType(JSONObject jsonObject) throws NoSuchObjectException;

    String getStreamNameBasedOnJsonType(JSONObject jsonObject) throws NoSuchObjectException;
}
