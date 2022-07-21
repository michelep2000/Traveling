package es.travelworld.traveling.home;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import es.travelworld.traveling.R;
import es.travelworld.traveling.databinding.HomeFragmentBinding;
import es.travelworld.traveling.utils.MyDialog;

public class HomeFragment extends Fragment {

    private HomeFragmentBinding binding;
    ActivityResultLauncher<String[]> requestPermissionLauncher;
    private boolean isFineLocationPermissionGranted = false;
    private boolean isCoarseLocationPermissionGranted = false;
    private final String CHANNEL_ID = "user_notifications";
    private final int NOTIFICATION_ID = 1;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = es.travelworld.traveling.databinding.HomeFragmentBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        requestPermissionLauncher =
                registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), result -> {

                    if(result.get(Manifest.permission.ACCESS_FINE_LOCATION) != null){
                        isFineLocationPermissionGranted = result.get(Manifest.permission.ACCESS_FINE_LOCATION);
                    }
                    if(result.get(Manifest.permission.ACCESS_COARSE_LOCATION) != null){
                        isCoarseLocationPermissionGranted = result.get(Manifest.permission.ACCESS_COARSE_LOCATION);
                    }


                    if(!isFineLocationPermissionGranted && !isCoarseLocationPermissionGranted){
                        MyDialog myDialog = new MyDialog();
                        myDialog.show(getParentFragmentManager(), "Permission denied dialog ");
                    }

                });

        requestAppPermissions();
        getRegisterArgs();
        displayNotification();
        setListeners();
        setToolBar(this);
        setTabBarLayout();
    }


    private void requestAppPermissions() {

        isFineLocationPermissionGranted = ContextCompat.checkSelfPermission(
                requireContext(), Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED;

        isCoarseLocationPermissionGranted = ContextCompat.checkSelfPermission(
                requireContext(), Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED;

        List<String> deniedPermissions = new ArrayList<String>();

        if (!isFineLocationPermissionGranted) {
            deniedPermissions.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (!isCoarseLocationPermissionGranted) {
            deniedPermissions.add(Manifest.permission.ACCESS_COARSE_LOCATION);
        }


        if (!deniedPermissions.isEmpty()) {
            requestPermissionLauncher.launch(deniedPermissions.toArray(new String[0]));
        }

    }

    public void displayNotification() {

        Bundle args = getArguments();
        if (args == null) return;

        String loginUsername = args.getString("username");

        createNotificationChannel();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(requireContext(), CHANNEL_ID);
        builder.setSmallIcon(R.drawable.round_face_black_36dp);
        builder.setContentTitle(getString(R.string.welcome) + loginUsername);
        builder.setContentText(getString(R.string.notification_description));
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);

        Bitmap busBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bus);
        builder.setLargeIcon(busBitmap);
        builder.setStyle(new NotificationCompat.BigPictureStyle()
                .bigPicture(busBitmap)
                .bigLargeIcon(null));

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(requireContext());
        notificationManagerCompat.notify(NOTIFICATION_ID, builder.build());
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "User Notifications";
            String description = "Include all the User notifications";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, name, importance);
            notificationChannel.setDescription(description);
            NotificationManager notificationManager = (NotificationManager) requireContext().getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
        }
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