package es.travelworld.traveling.onboarding;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.travelworld.traveling.databinding.OnboardingThreeFragmentBinding;

public class OnboardingThreeFragment extends Fragment {


    private OnboardingThreeFragmentBinding binding;

    public static OnboardingThreeFragment newInstance() {
        return new OnboardingThreeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = OnboardingThreeFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}