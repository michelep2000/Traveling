package es.travelworld.traveling.onboarding;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.travelworld.traveling.databinding.FragmentOnboardingBinding;

public class OnboardingFragment extends Fragment {

    private FragmentOnboardingBinding binding;
    ViewPager2 viewPager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = es.travelworld.traveling.databinding.FragmentOnboardingBinding.inflate(inflater, container, false);

        PageAdapterOnboarding adapterOnboarding = new PageAdapterOnboarding(getActivity());
        binding.viewPagerOnboarding.setAdapter(adapterOnboarding);

        OnboardingViewModel model = new ViewModelProvider(requireActivity()).get(OnboardingViewModel.class);

        viewPager = binding.viewPagerOnboarding;
        model.setViewPager(viewPager);

        return binding.getRoot();
    }

}