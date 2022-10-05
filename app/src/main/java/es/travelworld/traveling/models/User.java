package es.travelworld.traveling.models;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("nombre")
    private String name;
    @SerializedName("edad")
    private long age;
    @SerializedName("genero")
    private long genre;
    private String userToken;
    private long idBdReference;

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long value) {
        this.age = value;
    }

    public long getGenre() {
        return genre;
    }

    public void setGenre(long value) {
        this.genre = value;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String value) {
        this.userToken = value;
    }

    public long getIDBdReference() {
        return idBdReference;
    }

    public void setIDBdReference(long value) {
        this.idBdReference = value;
    }
}

