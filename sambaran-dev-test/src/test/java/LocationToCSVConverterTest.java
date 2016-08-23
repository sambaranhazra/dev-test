import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.sambaran.GeoPosition;
import org.sambaran.ILocationToFileConverter;
import org.sambaran.Location;
import org.sambaran.LocationToCSVConverter;

/**
 * Created by sambaran on 21/8/16.
 */
public class LocationToCSVConverterTest {

    Location firstLocation, secondLocation, partialMissingLocation, allMissingLocation;

    @Before
    public void setUp() throws Exception {
        firstLocation = new Location();
        firstLocation.setId(12345);
        firstLocation.setName("Bangalore");
        firstLocation.setType("City");
        GeoPosition geoPosition = new GeoPosition();
        geoPosition.setLatitude(23.56);
        geoPosition.setLongitude(88.34);
        firstLocation.setGeoPosition(geoPosition);

        secondLocation = new Location();
        secondLocation.setId(23456);
        secondLocation.setName("Bangalore");
        secondLocation.setType("Airport");
        GeoPosition secondGeoPosition = new GeoPosition();
        secondGeoPosition.setLatitude(23.5634);
        secondGeoPosition.setLongitude(88.3412);
        secondLocation.setGeoPosition(secondGeoPosition);

        partialMissingLocation = new Location();
        partialMissingLocation.setId(1234);
        partialMissingLocation.setName("Unknown Place");
        partialMissingLocation.setType("N/A");
        allMissingLocation = new Location();
    }

    @Test
    public void testLocationToCSV() throws Exception {
        ILocationToFileConverter ILocationToFileConverter = new LocationToCSVConverter();

        String csvString = ILocationToFileConverter.createCSVString(new Location[]{firstLocation});
        Assert.assertEquals("12345,Bangalore,City,23.56,88.34", csvString);
    }

    @Test
    public void testLocationToCSVMultiLocations() throws Exception {
        Location[] locations = {firstLocation, secondLocation};
        ILocationToFileConverter ILocationToFileConverter = new LocationToCSVConverter();
        String csvString = ILocationToFileConverter.createCSVString(locations);
        Assert.assertEquals("12345,Bangalore,City,23.56,88.34\n23456,Bangalore,Airport,23.5634,88.3412", csvString);
    }

    @Test
    public void testLocationToCSVWithSomeMissing() throws Exception {
        ILocationToFileConverter ILocationToFileConverter = new LocationToCSVConverter();
        String csvString = ILocationToFileConverter.createCSVString(new Location[]{partialMissingLocation});
        Assert.assertEquals("1234,Unknown Place,N/A,,", csvString);

    }

    @Test
    public void testLocationToCSVWithAllMissing() throws Exception {
        ILocationToFileConverter ILocationToFileConverter = new LocationToCSVConverter();
        String csvString = ILocationToFileConverter.createCSVString(new Location[]{allMissingLocation});
        Assert.assertEquals(",,,,", csvString);
    }

    @Test
    public void testLocationToCSVWithNull() throws Exception {
        ILocationToFileConverter ILocationToFileConverter = new LocationToCSVConverter();
        String csvString = ILocationToFileConverter.createCSVString(null);
        Assert.assertEquals("", csvString);
    }
}
