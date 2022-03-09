package es.travelworld.traveling.onboarding;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.viewpager2.widget.ViewPager2;

public class OnboardingViewModel extends ViewModel {


    private final MutableLiveData<ViewPager2> viewPager = new MutableLiveData<ViewPager2>();


    public LiveData<ViewPager2> getViewPager() {
        return viewPager;
    }

    public void next(ViewPager2 viewPager2) {
        viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1, true);
    }

    public void setViewPager(ViewPager2 viewPager) {
        this.viewPager.setValue(viewPager);
    }
}