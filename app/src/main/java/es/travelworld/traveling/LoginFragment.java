package es.travelworld.traveling;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textview.MaterialTextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment {

    private MaterialTextView getNewBtn;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     */
    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.login_fragment, container, false);

        FragmentActivity fragmentActivity = getActivity();
        getNewBtn = view.findViewById(R.id.materialTextView2Btn);
        MaterialTextView createNewBtn = view.findViewById(R.id.materialTextView3Btn);
        MaterialButton loginBtn = view.findViewById(R.id.loginButton);

        String toastCreateNew = getResources().getString(R.string.create_new_description);


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_onboardingFragment);
            }
        });

        createNewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(fragmentActivity, toastCreateNew, Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listeners();
    }

    private void listeners() {
        getNewBtn.setOnClickListener(view1 -> Snackbar.make(view1, getString(R.string.get_new_description), Snackbar.LENGTH_LONG).show());
    }
}