package es.travelworld.traveling.onboarding;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.travelworld.traveling.R;
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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setListeners();
    }

    private void setListeners() {
        binding.loginBtn.setOnClickListener(view -> Navigation.findNavController(view).navigate(R.id.action_onboardingFragment_to_loginFragment));
    }
}