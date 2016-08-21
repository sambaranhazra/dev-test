package org.sambaran;

import sun.net.www.http.HttpClient;

import java.io.*;
import java.net.URL;

/**
 * Created by sambaran on 21/8/16.
 */
public class Main {
    public static final String GOEURO_URL = "http://api.goeuro.com/api/v2/position/suggest/en/";

    public static void main(String[] args) {
        if (args.length != 1)
            System.out.println("Wrong argument passed; please pass only city name.\n Usage: java -jar GoEuroTest.jar \"CITY_NAME\"");
        else {
            String cityName = args[0];
            try {
                String jsonString = getJsonObjectFromURL(cityName);
                JsonToLocationConverter jsonToLocationConverter = new JsonToLocationConverter();
                Location[] locations = jsonToLocationConverter.convert(jsonString);
                LocationToCSVConverter locationToCSVConverter = new LocationToCSVConverter();
                PrintWriter printWriter = new PrintWriter(cityName + "_details.csv", "UTF-8");
                printWriter.append(locationToCSVConverter.createCSVString(locations));
                printWriter.close();
            } catch (Exception e) {
            }
        }
    }

    private static String getJsonObjectFromURL(String cityName) throws IOException {
        String urlString = GOEURO_URL + cityName;
        URL url = new URL(urlString);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(url.openStream()));

        String jsonString = "";
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            jsonString += inputLine;
        in.close();
        return jsonString;
    }
}
