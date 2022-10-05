package es.travelworld.traveling.repository;

import es.travelworld.traveling.models.Hotels;
import es.travelworld.traveling.models.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MockPstmnApi {

    @POST("login")
    Call<User> login(@Query("usuario") String user, @Query("password") String password);

    @GET("listHotels")
    Call<Hotels> getHotels();

}

