package es.travelworld.traveling.onboarding;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.travelworld.traveling.PageAdapterOnboarding;
import es.travelworld.traveling.R;
import es.travelworld.traveling.databinding.FragmentOnboardingBinding;

public class OnboardingFragment extends Fragment {

    private FragmentOnboardingBinding binding;
    static ViewPager2 viewPager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = es.travelworld.traveling.databinding.FragmentOnboardingBinding.inflate(inflater, container, false);

        PageAdapterOnboarding adapterOnboarding = new PageAdapterOnboarding(getActivity());
        binding.viewPagerOnboarding.setAdapter(adapterOnboarding);

        viewPager = binding.viewPagerOnboarding;

        return binding.getRoot();
    }

    public static void next() {
        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
    }

    public static void prev() {
        viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
    }
}