package com.arobs.jsontask.redis_service.coder_service;

import java.util.Base64;

public class CoderServiceImpl implements CoderService {

    @Override
    public String getDecodedPayLoad(String encodedString) {
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        String decodedString = new String(decodedBytes);
        return decodedString;
    }
}
