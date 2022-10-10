package vttp2022.ssf.miniproject;

import java.beans.JavaBean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;


@Configuration
public class AppConfig {

  @Value("${spring.redis.host}")
  private String redisHost;

  @Value("${spring.redis.port}")
  private Integer redisPort;

  @Value("${spring.redis.database}")
  private int redisDatabase;

  @Value("${spring.redis.username}")
  private String redisUsername;

  @Value("${REDIS_PASSWORD}")
    private String redisPassword;

  @Bean("redislab")
  public RedisTemplate<String, Object> initRedisTemplate() {

    /* Configuring the Redis database */
      RedisStandaloneConfiguration redisConfig 
        = new RedisStandaloneConfiguration();

        redisConfig.setHostName(redisHost);
        redisConfig.setPort(redisPort);
        redisConfig.setDatabase(redisDatabase);
        redisConfig.setUsername(redisUsername);
        redisConfig.setPassword(redisPassword);

    /* Creating an instance of the Jedis Driver */
      JedisClientConfiguration jedisConfig 
        = JedisClientConfiguration.builder().build();

    /* Creating a factory for jedis connection */
      JedisConnectionFactory jedisFac 
      = new JedisConnectionFactory(redisConfig, jedisConfig);
      
        jedisFac.afterPropertiesSet();

    /* Creating RedisTemplate */
      RedisTemplate<String, Object> redisTemplate 
        = new RedisTemplate<String, Object>();

        redisTemplate.setConnectionFactory(jedisFac);

      redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());

      System.out.println(">>>> running inRedisTemplate");
        return redisTemplate;
    }
}