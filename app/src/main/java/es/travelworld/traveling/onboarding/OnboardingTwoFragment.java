package es.travelworld.traveling.onboarding;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.travelworld.traveling.databinding.OnboardingTwoFragmentBinding;

public class OnboardingTwoFragment extends Fragment {

    private OnboardingTwoFragmentBinding binding;

    public static OnboardingTwoFragment newInstance() {
        return new OnboardingTwoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = OnboardingTwoFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}