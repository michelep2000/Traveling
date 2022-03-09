package es.travelworld.traveling.onboarding;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import es.travelworld.traveling.onboarding.OnboardingOneFragment;
import es.travelworld.traveling.onboarding.OnboardingThreeFragment;
import es.travelworld.traveling.onboarding.OnboardingTwoFragment;

public class PageAdapterOnboarding extends FragmentStateAdapter {

    public PageAdapterOnboarding(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment;

        switch (position){
            case 0:
                fragment = OnboardingOneFragment.newInstance();
                break;
            case 1:
                fragment = OnboardingTwoFragment.newInstance();
                break;
            case 2:
                fragment = OnboardingThreeFragment.newInstance();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + position);
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
