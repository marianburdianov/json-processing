package com.arobs.jsontask.json_service;

import org.json.simple.JSONObject;

public class BidJsonObjectSelectorServiceImpl implements BidJsonObjectSelectorService {

    public JSONObject getNestedJsonObjectFromBidJsonObject(JSONObject bidJsonObject) {
        Object object = bidJsonObject.get("bid");
        return (JSONObject) object;
    }

}
