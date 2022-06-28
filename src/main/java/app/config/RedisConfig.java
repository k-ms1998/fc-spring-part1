package app.config;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.CacheKeyPrefix;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;

import static org.springframework.data.redis.serializer.RedisSerializationContext.*;

@Configuration
@RequiredArgsConstructor
public class RedisConfig extends CachingConfigurerSupport {

    /**
     * Redis에서 Value 값을 읽기 가능한 Json 형태로 변환하기
     */
    @Bean
    public RedisCacheConfiguration redisCacheConfiguration() {
        return RedisCacheConfiguration.defaultCacheConfig()
                .computePrefixWith(name -> name + ":") // getStudent::fred -> getStudent:fred
                .entryTtl(Duration.ofSeconds(5)) // Time To Live(TTL) -> Redis에 값을 넣은 후, 5 초후에 삭제
                .serializeValuesWith(SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
    }

}
