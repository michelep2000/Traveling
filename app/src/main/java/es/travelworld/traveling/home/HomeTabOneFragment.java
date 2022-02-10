package es.travelworld.traveling.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.travelworld.traveling.databinding.HomeTabOneFragmentBinding;

public class HomeTabOneFragment extends Fragment {

    private static final String TAB_POSITION = "position";
    private HomeTabOneFragmentBinding binding;
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

        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.homeTabOne.setText(String.valueOf(position));
    }
}