package org.sambaran;

/**
 * Created by sambaran on 21/8/16.
 */
public class LocationToCSVConverter implements ILocationToFileConverter {
    public String createCSVString(Location[] locations) {
        StringBuffer sb = new StringBuffer();
        if (locations != null) {
            for (Location location : locations) {
                if (location.getId() != null)
                    sb.append(location.getId());
                sb.append(",");
                if (location.getName() != null)
                    sb.append(location.getName());
                sb.append(",");
                if (location.getType() != null)
                    sb.append(location.getType());
                sb.append(",");
                if (location.getGeoPosition() != null)
                    sb.append(location.getGeoPosition().getLatitude());
                sb.append(",");
                if (location.getGeoPosition() != null)
                    sb.append(location.getGeoPosition().getLongitude());
                sb.append("\n");
            }
        }
        return sb.toString().trim();
    }
}
