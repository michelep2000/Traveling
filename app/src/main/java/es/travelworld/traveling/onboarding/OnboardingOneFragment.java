package es.travelworld.traveling.onboarding;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import es.travelworld.traveling.MainActivity;
import es.travelworld.traveling.databinding.OnboardingOneFragmentBinding;


public class OnboardingOneFragment extends Fragment {

    private OnboardingOneFragmentBinding binding;
    private OnboardingViewModel onboardingModel;


    public static OnboardingOneFragment newInstance() {
        return new OnboardingOneFragment();
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = OnboardingOneFragmentBinding.inflate(inflater, container, false);
        onboardingModel = new ViewModelProvider(requireActivity()).get(OnboardingViewModel.class);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setListeners();
    }

    private void setListeners() {
        binding.textViewNext.setOnClickListener(view -> onboardingModel.getViewPager().observe(getViewLifecycleOwner(), viewPager2 -> onboardingModel.next(viewPager2)));
    }
}