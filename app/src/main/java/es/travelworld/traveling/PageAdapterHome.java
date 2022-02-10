package es.travelworld.traveling;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import es.travelworld.traveling.home.HomeTabCeroFragment;
import es.travelworld.traveling.home.HomeTabOneFragment;
import es.travelworld.traveling.home.HomeTabThreeFragment;
import es.travelworld.traveling.home.HomeTabTwoFragment;


public class PageAdapterHome extends FragmentStateAdapter {

    public PageAdapterHome(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment;

        switch (position) {
            case 0:
                fragment = HomeTabCeroFragment.newInstance(position);
                break;
            case 1:
                fragment = HomeTabOneFragment.newInstance(position);
                break;
            case 2:
                fragment = HomeTabTwoFragment.newInstance(position);
                break;
            case 3:
                fragment = HomeTabThreeFragment.newInstance(position);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + position);
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
