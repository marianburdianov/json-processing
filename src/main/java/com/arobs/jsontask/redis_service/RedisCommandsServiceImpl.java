package com.arobs.jsontask.redis_service;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisStreamCommands;

public class RedisCommandsServiceImpl implements RedisCommandsService {

    @Override
    public RedisStreamCommands<String, String> getRedisCommands() {
        RedisClient client = RedisClient.create("redis://localhost");
        StatefulRedisConnection<String, String> connection = client.connect();
        RedisStreamCommands<String, String> commands = connection.sync();
        return commands;
    }
}
