package es.travelworld.traveling.home.homeTabZero;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import es.travelworld.traveling.models.Hotel;
import es.travelworld.traveling.models.Hotels;

public class HomeTabZeroViewModel extends ViewModel {
    private final HomeTabZeroRepository homeTabZeroRepository;
    private final Context context;
    private final MutableLiveData<Hotels> _hotels = new MutableLiveData<>();


    public HomeTabZeroViewModel(HomeTabZeroRepository homeTabZeroRepository, Context context) {
        this.homeTabZeroRepository = homeTabZeroRepository;
        this.context = context;
    }

    public void getHotelList() {

        homeTabZeroRepository.getHotels(new HomeTabZeroRepository.HomeTabZero() {
            @Override
            public void onSuccess(Hotels hotels) {
                _hotels.setValue(hotels);
            }

            @Override
            public void onError(Throwable exc) {

            }
        });
    }

    public LiveData<Hotels> getHotels() {
        return _hotels;
    }

    public static class Factory extends ViewModelProvider.NewInstanceFactory {
        private final HomeTabZeroRepository homeTabZeroRepository;
        private final Context applicationContext;

        public Factory(HomeTabZeroRepository homeTabZeroRepository, Context applicationContext) {
            this.homeTabZeroRepository = homeTabZeroRepository;
            this.applicationContext = applicationContext;
        }

        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new HomeTabZeroViewModel(homeTabZeroRepository, applicationContext);
        }
    }
}
