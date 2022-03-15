package es.travelworld.traveling.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void init() {
        cars = new ArrayList<>();
        cars.add(new CarItem("#b8784f", "Classic Car", "$34/day", R.drawable.classic_car));
        cars.add(new CarItem("#5cb3f7", "Sport Car", "$55/day", R.drawable.sport_car));
        cars.add(new CarItem("#8380c4", "Flying Car", "$500/day", R.drawable.flying_car));
        cars.add(new CarItem("#2a3640", "Electric Car", "$45/day", R.drawable.electric_car));
        cars.add(new CarItem("#7cb1aa", "Motorhome", "$23/day", R.drawable.motor_home));
        cars.add(new CarItem("#ae8e71", "Pickup", "$10/day", R.drawable.pick_up_car));
        cars.add(new CarItem("#a54c45", "Airplane", "$11/day", R.drawable.air_plane));
        cars.add(new CarItem("#e5ca69", "Bus", "$14/day", R.drawable.bus));

        ListAdapterHomeTabOne listAdapter = new ListAdapterHomeTabOne(cars);

        binding.recyclerViewCars.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerViewCars.setAdapter(listAdapter);

    }
}