package vttp2022.ssf.miniproject.Redis;

import jakarta.json.JsonObject;
import vttp2022.ssf.miniproject.models.Meal;

public interface servicesRepo {

    public void saveMeal(String username, Meal meal);

    public void deleteAll();

}