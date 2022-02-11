package es.travelworld.traveling.home;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import es.travelworld.traveling.PageAdapterHome;
import es.travelworld.traveling.R;
import es.travelworld.traveling.databinding.HomeFragmentBinding;

public class HomeFragment extends Fragment {

    private HomeFragmentBinding binding;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = es.travelworld.traveling.databinding.HomeFragmentBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getRegisterArgs();
        setListeners();
        setToolBar(this);
        setTabBarLayout();
    }

    private void setTabBarLayout() {
        PageAdapterHome adapterHome = new PageAdapterHome(getActivity());
        binding.viewPagerHome.setAdapter(adapterHome);

        new TabLayoutMediator(binding.tabBarLayout, binding.viewPagerHome, ((tab, position) -> {

            int tabIconColor = ContextCompat.getColor(getContext(), R.color.black);

            switch (position) {
                case 0:
                    tab.view.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.homeTabZero));
                    tab.setIcon(R.drawable.round_camera_alt_black_36dp);
                    break;
                case 1:
                    tab.view.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.homeTabOne));
                    tab.setIcon(R.drawable.round_directions_car_black_36dp);
                    break;
                case 2:
                    tab.view.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.homeTabTwo));
                    tab.setIcon(R.drawable.round_forest_black_36dp);
                    break;
                case 3:
                    tab.view.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.homeTabThree));
                    tab.setIcon(R.drawable.round_face_black_36dp);
                    break;
            }

            tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);

        })).attach();
    }

    private void setListeners() {
        binding.tabBarLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int tabIconColor = ContextCompat.getColor(getContext(), R.color.white);
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                int tabIconColor = ContextCompat.getColor(getContext(), R.color.black);
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


    private void setToolBar(HomeFragment homeFragment) {
        MaterialToolbar toolbar = binding.homeToolbar;
        toolbar.setNavigationIcon(R.drawable.round_menu_black_24dp);
        toolbar.setNavigationIconTint(ContextCompat.getColor(getContext(), R.color.white));

        toolbar.setOnMenuItemClickListener(item -> {

            int itemId = item.getItemId();

            if (itemId == R.id.castle) {
                openWeb();
            } else if (itemId == R.id.car) {
                NavHostFragment.findNavController(homeFragment).navigate(R.id.action_homeFragment_to_lilaFragment);
            }
            return false;
        });
    }

    private void openWeb() {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.disneylandparis.com/es-es"));
        startActivity(browserIntent);
    }


    private void getRegisterArgs() {
        Bundle args = getArguments();
        if (args == null) return;

        String loginUsername = args.getString("username");
        String loginPassword = args.getString("password");
        String usr = "USR: " + loginUsername + " ";
        String pwd = "PWD: " + loginPassword;

        Snackbar.make(binding.getRoot(), usr + pwd, Snackbar.LENGTH_LONG).show();

    }
}