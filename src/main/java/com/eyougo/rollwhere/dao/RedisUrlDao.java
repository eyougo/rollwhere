package com.eyougo.rollwhere.dao;

import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * User: mei
 * Date: 5/16/14
 * Time: 00:33
 */
public class RedisUrlDao implements UrlDao {
    private static final String URLSET_KEY = "urls";

    private static final String ROLLCOUNT_KEY = "rollcount";

    private StringRedisTemplate redisTemplate;

    @Override
    public String getRandomUrl() {
        redisTemplate.opsForValue().increment(ROLLCOUNT_KEY, 1);
        return redisTemplate.opsForSet().randomMember(URLSET_KEY);
    }

    @Override
    public Long getUrlCount() {
        return redisTemplate.opsForSet().size(URLSET_KEY);
    }

    public void setRedisTemplate(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
