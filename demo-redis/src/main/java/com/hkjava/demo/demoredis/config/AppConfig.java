package com.hkjava.demo.demoredis.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import com.hkjava.demo.demoredis.infra.RedisHelper;
import com.hkjava.demo.demoredis.model.CompanyProfile;
import com.hkjava.demo.demoredis.model.StringHolder;

@Configuration
@EnableCaching
public class AppConfig {

  @Bean
  RedisTemplate<String, StringHolder> redisTemplate(
      RedisConnectionFactory factory) {
    RedisTemplate<String, StringHolder> redisTemplate = new RedisTemplate<>();
    redisTemplate.setKeySerializer(new StringRedisSerializer());
    // redisTemplate.setHashKeySerializer(
    // new GenericToStringSerializer<String>(String.class));
    // redisTemplate.setHashValueSerializer(new JdkSerializationRedisSerializer());
    // redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
    // RedisStandaloneConfiguration configuration =
    // new RedisStandaloneConfiguration("localhost", 6379);
    // JedisClientConfiguration jedisClientConfiguration =
    // JedisClientConfiguration.builder().build();
    // JedisConnectionFactory factory =
    // new JedisConnectionFactory(configuration, jedisClientConfiguration);
    // factory.afterPropertiesSet();
    redisTemplate.setConnectionFactory(factory);
    return redisTemplate;
  }

  @Bean
  RedisHelper<StringHolder> redisStringHelper(
      RedisTemplate<String, StringHolder> redisTemplate) {
    return new RedisHelper<StringHolder>(redisTemplate);
  }

  @Bean
  RedisTemplate<String, CompanyProfile> redisProfileTemplate(
      RedisConnectionFactory factory) {
    RedisTemplate<String, CompanyProfile> redisTemplate = new RedisTemplate<>();
    redisTemplate.setKeySerializer(new StringRedisSerializer());
    // redisTemplate.setValueSerializer(null);
    redisTemplate.setConnectionFactory(factory);
    return redisTemplate;
  }

  @Bean
  RedisHelper<CompanyProfile> redisProfileHelper(
      RedisTemplate<String, CompanyProfile> redisTemplate) {
    return new RedisHelper<CompanyProfile>(redisTemplate);
  }

}
