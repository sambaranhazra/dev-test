import org.junit.Test;
import org.sambaran.JsonToLocationConverter;
import org.sambaran.Location;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by sambaran on 21/8/16.
 */
public class JsonToLocationConverterTest {


    private String jsonString;


    @Test
    public void testJsonToLocation() throws Exception {
        jsonString = "[{\"_id\":457178,\"key\":null,\"name\":\"Calcutta\",\"fullName\":\"Calcutta, India\",\"iata_airport_code\":null,\"type\":\"firstLocation\",\"country\":\"India\",\"geo_position\":{\"latitude\":22.56263,\"longitude\":88.36304},\"locationId\":157943,\"inEurope\":false,\"countryId\":101,\"countryCode\":\"IN\",\"coreCountry\":false,\"distance\":null,\"names\":{\"fi\":\"Kalkutta\",\"es\":\"Calcuta\",\"tr\":\"Kalküta\",\"pl\":\"Kalkuta\",\"pt\":\"Calcutá\",\"ru\":\"Колката\",\"is\":\"Kalkútta\",\"de\":\"Kalkutta\",\"zh\":\"加尔各答\",\"cs\":\"Kalkata\",\"ca\":\"Calcuta\"},\"alternativeNames\":{}},{\"_id\":314009,\"key\":null,\"name\":\"Calcutta\",\"fullName\":\"Calcutta (CCU), India\",\"iata_airport_code\":\"CCU\",\"type\":\"airport\",\"country\":\"India\",\"geo_position\":{\"latitude\":22.65361,\"longitude\":88.44639},\"locationId\":null,\"inEurope\":false,\"countryId\":101,\"countryCode\":\"IN\",\"coreCountry\":false,\"distance\":null,\"names\":{},\"alternativeNames\":{}}]";

        Location[] locations = new JsonToLocationConverter().convert(jsonString);
        assertEquals(2, locations.length);
        assertEquals(locations[0].getId().intValue(), 457178);
        assertEquals(locations[1].getId().intValue(), 314009);
        assertEquals(locations[0].getName(), "Calcutta");
        assertEquals(locations[1].getName(), "Calcutta");
        assertEquals(locations[0].getType(), "firstLocation");
        assertEquals(locations[1].getType(), "airport");
        assertEquals(locations[0].getGeoPosition().getLatitude(), 22.56263);
        assertEquals(locations[1].getGeoPosition().getLatitude(), 22.65361);
        assertEquals(locations[0].getGeoPosition().getLongitude(), 88.36304);
        assertEquals(locations[1].getGeoPosition().getLongitude(), 88.44639);
    }

    @Test
    public void testJsonToLocationWhenNotMatched() throws Exception {
        jsonString = "[]";
        Location[] locations = new JsonToLocationConverter().convert(jsonString);
        assertNotNull(locations);
        assertEquals(0, locations.length);

    }
}
