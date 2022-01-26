package es.travelworld.traveling;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.google.android.material.snackbar.Snackbar;

import es.travelworld.traveling.databinding.LoginFragmentBinding;

public class LoginFragment extends Fragment {

    private LoginFragmentBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = LoginFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setListeners();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void setListeners() {
        binding.materialTextView2Btn.setOnClickListener(view1 -> Snackbar.make(view1, getString(R.string.get_new_description), Snackbar.LENGTH_LONG).show());
        binding.materialTextView3Btn.setOnClickListener(view1 -> Navigation.findNavController(view1).navigate(R.id.action_loginFragment_to_registerFragment));
        binding.loginButton.setOnClickListener(view1 -> Navigation.findNavController(view1).navigate(R.id.action_loginFragment_to_onboardingFragment));
    }
}
