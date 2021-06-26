/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demomomo.app.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 *
 * @author mrloi
 */
public class GsonUtils {
    private Gson gson;

    public GsonUtils() {
        if (gson == null) {
            gson = new Gson();
        }
    }

    public Gson getGson() {
        if (gson == null) {
            gson = new Gson();
        }
        return gson;
    }

    public JsonObject createJsonObj(String json) {
        return gson.fromJson(json, JsonObject.class);
    }

    public String convertToJson(Object obj) {
        return gson.toJson(obj);
    }

    public JsonArray createJsonArray(String json) {
        return gson.fromJson(json, JsonArray.class);
    }

 

    public String getAsStringUtil(JsonObject obj, String key) {
        try {
            return obj.get(key).getAsString();
        } catch (Exception e) {
            return "";
        }
    }
    public String getAsStringUtilFromObj(JsonObject obj, String key) {
        try {
            return obj.get(key).getAsJsonObject().toString();
        } catch (Exception e) {
            return "";
        }
    }
    
    public String convertJavaOjbToJson(Object obj) {
        return null;
      
    }
     public JsonArray getAsJsonArrUtilFromObj(JsonObject obj, String key) {
        try {
            return obj.get(key).getAsJsonArray();
        } catch (Exception e) {
            return null;
        }
    }
     
    public JsonObject getAsJsonOBJUtilFromObj(JsonObject obj, String key) {
        try {
            return obj.get(key).getAsJsonObject();
        } catch (Exception e) {
            return null;
        }
    }
}
