// package vttp2022.ssf.miniproject.repositories;

// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Qualifier;
// import org.springframework.data.redis.core.RedisTemplate;
// import org.springframework.data.redis.core.ValueOperations;
// import org.springframework.stereotype.Repository;

// import vttp2022.ssf.miniproject.models.Meal;

// @Repository
// public class MealRepository {

//     @Autowired
//     @Qualifier("redislab")
//     private RedisTemplate<String, String> redisTemplate;

//     public void saveNewMeal(Meal meal) {
//         String id = String.valueOf(meal.getIdMeal());
//         ValueOperations<String, String> valueOp = redisTemplate.opsForValue();
//         valueOp.set(id, meal.toJson(meal).toString());
//         System.out.println("MealRepository: - saveNewMeal Id: " + id + " - SAVE SUCCESSFULLY!");
//     }

//     public Optional<String> getMeal(String id) {
//         if (!redisTemplate.hasKey(id)) {
//             System.out.println("MealRepository - getMeal - Unable to locate key: " + id);
//             return Optional.empty();
//         }

//         ValueOperations<String, String> valueOp = redisTemplate.opsForValue();
//         String mealResult = valueOp.get(id);
//         System.out.println("MealRepository - getMeal - mealResult: " + mealResult);
//         return Optional.of(mealResult);
//     }
// }



