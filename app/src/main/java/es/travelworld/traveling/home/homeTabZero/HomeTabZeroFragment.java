package es.travelworld.traveling.home.homeTabZero;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import es.travelworld.traveling.R;
import es.travelworld.traveling.databinding.HomeTabZeroFragmentBinding;
import es.travelworld.traveling.home.ListAdapterHomeTabOne;
import es.travelworld.traveling.login.LoginRepository;
import es.travelworld.traveling.login.LoginViewModel;
import es.travelworld.traveling.models.CarItem;
import es.travelworld.traveling.models.Hotels;

public class HomeTabZeroFragment extends Fragment {

    private HomeTabZeroFragmentBinding binding;
    private HomeTabZeroViewModel homeTabZeroRepository;

    public static HomeTabZeroFragment newInstance() {
        return new HomeTabZeroFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = es.travelworld.traveling.databinding.HomeTabZeroFragmentBinding.inflate(inflater, container, false);
        homeTabZeroRepository = new ViewModelProvider(this, new HomeTabZeroViewModel.Factory(new HomeTabZeroRepository(), this.getActivity().getApplicationContext())).get(HomeTabZeroViewModel.class);
        init();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void init() {

        homeTabZeroRepository.getHotelList();

        homeTabZeroRepository.getHotels().observe(getViewLifecycleOwner(), data -> {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            ListAdapterHomeTabZero listAdapter = new ListAdapterHomeTabZero(data.getHotels());
            binding.recyclerViewHotels.setLayoutManager(linearLayoutManager);
            binding.recyclerViewHotels.setAdapter(listAdapter);
        });

    }

}