package org.sambaran;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sambaran on 21/8/16.
 */
public class Location {
    @SerializedName("_id")
    private Integer id;
    private String name;
    private String type;
    @SerializedName("geo_position")
    private GeoPosition geoPosition;

    public GeoPosition getGeoPosition() {
        return geoPosition;
    }

    public void setGeoPosition(GeoPosition geoPosition) {
        this.geoPosition = geoPosition;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getId() {
        return id;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



}
