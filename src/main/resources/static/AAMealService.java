// package vttp2022.ssf.miniproject.services;

// import java.io.Reader;
// import java.io.StringReader;
// import java.util.Collections;
// import java.util.LinkedList;
// import java.util.List;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.http.RequestEntity;
// import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Service;
// import org.springframework.web.client.RestTemplate;

// import jakarta.json.Json;
// import jakarta.json.JsonArray;
// import jakarta.json.JsonObject;
// import jakarta.json.JsonReader;
// import vttp2022.ssf.miniproject.models.Meal;
// import vttp2022.ssf.miniproject.repositories.MealRepository;

// @Service
// public class MealService {

//     @Autowired
//     private MealRepository mealRepository;

//     @Value("${API_KEY}")
//     private String key;

//     private static final String URL 
//         = "https://www.themealdb.com/api/json/v1/1/search.php";

//         public List<Meal> getMeals() {
//             RequestEntity<Void> request = RequestEntity.get(URL).build();
//             RestTemplate template = new RestTemplate();
//             ResponseEntity<String> response;
//             String payload;

//             try {
//                 response = template.exchange(request, String.class);
//             } catch(Exception ex) {
//                 System.err.printf("Error: %s\n", ex.getMessage());
//                 return Collections.emptyList();
//             }

//             if (response.getStatusCodeValue() != 200) {
//                 System.err.println("Error status code is not 200");
//                 return Collections.emptyList();
//             }

//             payload = response.getBody();
            
//             Reader strReader = new StringReader(payload);
//             JsonReader jsonReader = Json.createReader(strReader);
//             JsonObject mealResult = jsonReader.readObject();
//             JsonArray mealData = mealResult.getJsonArray("Meal");

//             List<Meal> listOfMeals = new LinkedList<>();

//             for (int i = 0; i < mealData.size(); i++) {
//                 JsonObject jo = mealData.getJsonObject(i);
//                 listOfMeals.add(Meal.create(jo));
//             }

//             return listOfMeals;
//     }

//         public void saveMeals(List<Meal> mealsList) {
//             for (Meal ml : mealsList) {
//                 mealRepository.saveNewMeal(ml);
//             }
//     }

//     public Meal getMealById (String id) {
//         System.out.println("MealService - getMealById id: " + id);
//         Optional<String> opt = mealRepository.getMeal(id);
//         String payload;

//             if (opt.isEmpty()) {
//                 return null;
//             } 
//             else {
//                 payload = opt.get();
//                 System.out.println("MealService - getMealById -[PAYLOAD]: " + payload);
//                 Reader strReader = new StringReader(payload);
//                 JsonReader jsonReader = Json.createReader(strReader);
//                 JsonObject articleObject = jsonReader.readObject();
//                 return Meal.create(articleObject);
//                 }
//             }

// }
