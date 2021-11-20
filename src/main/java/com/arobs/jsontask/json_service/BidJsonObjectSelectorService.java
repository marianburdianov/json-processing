package com.arobs.jsontask.json_service;

import org.json.simple.JSONObject;

public interface BidJsonObjectSelectorService {

    JSONObject getNestedJsonObjectFromBidJsonObject(JSONObject bidJsonObject);
}
