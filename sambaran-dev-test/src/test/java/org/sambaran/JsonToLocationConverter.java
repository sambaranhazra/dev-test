package org.sambaran;

import com.google.gson.Gson;

/**
 * Created by sambaran on 21/8/16.
 */
public class JsonToLocationConverter {

    private Gson locationGson = new Gson();

    public Location[] convert(String jsonString) {
        return locationGson.fromJson(jsonString, Location[].class);
    }
}
