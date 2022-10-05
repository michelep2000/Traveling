package es.travelworld.traveling.repository;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

abstract public class RetrofitFactory {

    static final String BASE_URL = "https://01394d44-8918-4a1d-8059-629c50c25e87.mock.pstmn.io";

    public static MockPstmnApi getMockPstmnApi() {
        final Retrofit retrofitBuilder = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        return retrofitBuilder.create(MockPstmnApi.class);
    }

}
