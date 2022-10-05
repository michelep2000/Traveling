package es.travelworld.traveling.home.homeTabZero;

import android.util.Log;

import java.util.List;

import es.travelworld.traveling.models.Hotel;
import es.travelworld.traveling.models.Hotels;
import es.travelworld.traveling.repository.RetrofitFactory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeTabZeroRepository {

    interface HomeTabZero {
        void onSuccess(Hotels hotels);

        void onError(Throwable exc);
    }

    public void getHotels(HomeTabZeroRepository.HomeTabZero callback) {
        RetrofitFactory.getMockPstmnApi().getHotels().enqueue(
                new Callback<Hotels>() {
                    @Override
                    public void onResponse(Call<Hotels> call, Response<Hotels> response) {
                        if (response.code() == 200) callback.onSuccess(response.body());
                        else callback.onSuccess(null);
                    }

                    @Override
                    public void onFailure(Call<Hotels> call, Throwable t) {
                        callback.onError(t);
                    }
                }
        );
    }

}
