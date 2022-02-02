package es.travelworld.traveling;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.snackbar.Snackbar;

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
        setToolBar(this);
        getRegisterArgs();
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

        //Ya van 3 lugares donde utilizamos la misma key, jeje.
        //PREGUNTA => Si haces unas acciones en más de un lugar no se podría crear
        //un método que se utilize en dichos lugares. Dale una vuelta.
        String loginUsername = args.getString("username");
        String loginPassword = args.getString("password");
        String usr = "USR: " + loginUsername + " ";
        String pwd = "PWD: " + loginPassword;

        Snackbar.make(binding.getRoot(), usr+ pwd, Snackbar.LENGTH_LONG).show();

    }
}