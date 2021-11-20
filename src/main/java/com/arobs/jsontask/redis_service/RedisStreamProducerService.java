package com.arobs.jsontask.redis_service;

import org.json.simple.parser.ParseException;

import java.io.IOException;

public interface RedisStreamProducerService {

    void createResource() throws IOException, ParseException;
}
