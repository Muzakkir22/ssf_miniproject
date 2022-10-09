package vttp2022.ssf.miniproject.models;

import java.io.StringReader;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class Meal {

    private String idMeal;
    private String strMeal;
    private String strCategory;
    private String strArea;
    private String strMealThumb;

    public String getIdMeal() {
        return idMeal;
    }
    public void setIdMeal(String idMeal) {
        this.idMeal = idMeal;
    }
    public String getStrMeal() {
        return strMeal;
    }
    public void setStrMeal(String strMeal) {
        this.strMeal = strMeal;
    }
    public String getStrCategory() {
        return strCategory;
    }
    public void setStrCategory(String strCategory) {
        this.strCategory = strCategory;
    }
    public String getStrArea() {
        return strArea;
    }
    public void setStrArea(String strArea) {
        this.strArea = strArea;
    }
    public String getStrMealThumb() {
        return strMealThumb;
    }
    public void setStrMealThumb(String strMealThumb) {
        this.strMealThumb = strMealThumb;
    }

    public static Meal createNew(JsonObject jo) {
        Meal ml = new Meal();
        ml.setIdMeal(jo.getString("idMeal"));
        ml.setStrArea(jo.getString("strArea"));
        ml.setStrCategory(jo.getString("strCategory"));
        ml.setStrMeal(jo.getString("strMeal"));
        ml.setStrMealThumb(jo.getString("strMealThumb"));
        return ml;
    }

    public JsonObject toJson() {
        return Json.createObjectBuilder()
        .add("idMeal", this.idMeal)
        .add("strArea", this.strArea)
        .add("strCategory", this.strCategory)
        .add("strMeal", this.strMeal)
        .add("strMealThumb", this.strMealThumb)
        .build();

    }

    public static Meal createNew(String json) {
		try (StringReader strReader = new StringReader(json)) {
			JsonReader j = Json.createReader(strReader);
			return createNew(j.readObject());
        }
    }
}
 