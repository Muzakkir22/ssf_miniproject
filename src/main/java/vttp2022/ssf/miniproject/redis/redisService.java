package vttp2022.ssf.miniproject.Redis;

import java.util.ArrayList;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import jakarta.json.JsonObject;
import vttp2022.ssf.miniproject.models.Meal;

//https://docs.spring.io/spring-data/redis/docs/current/api/org/springframework/data/redis/core/RedisTemplate.html

@Service
public class redisService implements servicesRepo {
    
    ArrayList<String> keys;

    //To save and retrieve normal HashMap, String etc form Redis
    // @Autowired
    // RedisTemplate<String, Object> redisTemplate;

    //To save and retrieve POJO from Redis
    @Autowired
    RedisTemplate<String, Meal> redisTemplate;

    @Override
    public void deleteAll() {
        this.keys = getKeys();
        for (String key : keys) {
            redisTemplate.delete(key); //Deleting key. Casting from integer to String (Since Redis keys are String)
        }
    }

    //Helper class to get all keys from database
    public ArrayList<String> getKeys() {
        Set<String> redisKeys = redisTemplate.keys("*"); //Pattern is * for ALL keys. Getting all keys.
        ArrayList<String> keys = new ArrayList<>();
        for (String item : redisKeys) {
            keys.add(item);
        }
        return keys;
    }

    @Override
    public void saveMeal(String username, Meal meal) {
        // TODO Auto-generated method stub
        
    }

}