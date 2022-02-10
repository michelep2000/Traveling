package es.travelworld.traveling.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.travelworld.traveling.databinding.HomeTabThreeFragmentBinding;


public class HomeTabThreeFragment extends Fragment {

    private static final String TAB_POSITION = "position";
    private HomeTabThreeFragmentBinding binding;
    int position;

    public static HomeTabThreeFragment newInstance(int position) {
        HomeTabThreeFragment fragment = new HomeTabThreeFragment();
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

        binding = es.travelworld.traveling.databinding.HomeTabThreeFragmentBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        binding.homeTabThree.setText(String.valueOf(position));
    }
}