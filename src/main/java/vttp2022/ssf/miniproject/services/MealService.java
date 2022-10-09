package vttp2022.ssf.miniproject.services;

import java.io.Reader;
import java.io.StringReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import vttp2022.ssf.miniproject.models.Meal;
// import vttp2022.ssf.miniproject.repositories.MealRepository;

public class MealService {
    
    private static final String URL = "https://www.themealdb.com/api/json/v1/1/search.php";

    // @Autowired
    // private MealRepository mealRepo;

    private static String mealInput = "chicken";

    public static List<Meal> getMeal() {

        String payload;

        System.out.println("Getting info from MealDB");

        // Creating url with query string
        String url = UriComponentsBuilder.fromUriString(URL)
                .queryParam("s", mealInput)
                .toUriString();

            // Create the GET request, get URL
            RequestEntity<Void> req = RequestEntity.get(url).build();

            // Make the call to MealDB
            RestTemplate template = new RestTemplate();
            ResponseEntity<String> resp;
    
            try {
                //Throws an exception if status code not in between 200-399
                resp = template.exchange(req, String.class);
            } catch(Exception ex) {
                System.err.printf("Error: %s\n", ex.getMessage());
                return Collections.emptyList();
            } 
         
            // Get the payload and do something with it
            payload = resp.getBody();
            System.out.println("payload: " + payload);

            Reader strReader = new StringReader(payload);
            // Create a JsonReader from reader
            JsonReader jsonReader = Json.createReader(strReader);
            // Read the payload as Json Object
            JsonObject MealResult = jsonReader.readObject();

            JsonArray data = MealResult.getJsonArray("meals");
            List<Meal> list = new LinkedList<>();
            for (int i = 0; i <data.size(); i++ ) {
                JsonObject jo = data.getJsonObject(i);
                list.add(Meal.createNew(jo));
                
            }

        return list;
        
    }

    // public List<Meal> searchMeal(String word) {

    //     String url = UriComponentsBuilder.fromUriString(URL);
    //     .queryParam("s", word)
    //     .toUriString();

    //     // Create the GET request, GET url
    //     RequestEntity<Void> req = RequestEntity.get(url).build();
    //     // calling API
    //     RestTemplate template = new RestTemplate();
    //     ResponseEntity<String> resp = template.exchange(req, String.class);

    //     // Get the payload and do something with it
    //     String payload = resp.getBody();
    //     System.out.println("payload: " + payload);

    //     // Convert the String payload to JsonObject
    //     Reader strReader = new StringReader(payload);
    //     JsonReader jsonReader = Json.createReader(strReader);
    //     JsonObject mealResult = jsonReader.readObject();
    //     // get JsonArray "Data"
    //     JsonArray mealData = mealResult.getJsonArray(payload)
    // }

}
