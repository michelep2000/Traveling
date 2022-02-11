package es.travelworld.traveling.onboarding;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.travelworld.traveling.MainActivity;
import es.travelworld.traveling.R;
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


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setListeners();
    }

    private void setListeners() {
        binding.nextBtn.setOnClickListener(view -> OnboardingFragment.next());
        binding.skipBtn.setOnClickListener(view -> Navigation.findNavController(view).navigate(R.id.action_onboardingFragment_to_loginFragment));
    }
}