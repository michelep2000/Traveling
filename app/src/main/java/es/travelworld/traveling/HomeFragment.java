package es.travelworld.traveling;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        getRegisterArgs();
        return inflater.inflate(R.layout.home_fragment, container, false);
    }

    private void getRegisterArgs() {
        Bundle args = getArguments();
        if (args == null) return;

        String loginUsername = args.getString("username");
        String loginPassword = args.getString("password");

        Log.i("HomeFragment", "USR: "+ loginUsername);
        Log.i("HomeFragment", "PWD: "+ loginPassword);

    }
}