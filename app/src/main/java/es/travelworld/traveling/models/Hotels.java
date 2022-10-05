package es.travelworld.traveling.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Hotels {
    @SerializedName("results")
    private List<Hotel> hotels;

    public List<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }
}
