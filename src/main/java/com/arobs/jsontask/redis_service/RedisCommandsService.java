package com.arobs.jsontask.redis_service;

import io.lettuce.core.api.sync.RedisStreamCommands;

public interface RedisCommandsService {

    RedisStreamCommands<String, String> getRedisCommands();
}
