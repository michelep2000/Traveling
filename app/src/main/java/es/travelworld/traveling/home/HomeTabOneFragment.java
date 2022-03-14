package es.travelworld.traveling.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import es.travelworld.traveling.R;
import es.travelworld.traveling.databinding.HomeTabOneFragmentBinding;
import es.travelworld.traveling.models.CarItem;

public class HomeTabOneFragment extends Fragment {

    private static final String TAB_POSITION = "position";
    private HomeTabOneFragmentBinding binding;
    private List<CarItem> cars;
    int position;


    public static HomeTabOneFragment newInstance(int position) {
        HomeTabOneFragment fragment = new HomeTabOneFragment();
        Bundle args = new Bundle();
        args.putInt(TAB_POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt(TAB_POSITION);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = es.travelworld.traveling.databinding.HomeTabOneFragmentBinding.inflate(inflater, container, false);
        init();

        return binding.getRoot();
    }

    private void init() {
        cars = new ArrayList<>();
        cars.add(new CarItem("#b8784f", "Classic Car", "$34/day", R.drawable.sport_car));
        cars.add(new CarItem("#b8784f", "Classic Car", "$34/day", R.drawable.sport_car));
        cars.add(new CarItem("#b8784f", "Classic Car", "$34/day", R.drawable.sport_car));
        cars.add(new CarItem("#b8784f", "Classic Car", "$34/day", R.drawable.sport_car));
        cars.add(new CarItem("#b8784f", "Classic Car", "$34/day", R.drawable.sport_car));

        PageAdapterHomeTabOne listAdapter = new PageAdapterHomeTabOne(cars, getContext());

        binding.recyclerViewCars.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerViewCars.setAdapter(listAdapter);

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}