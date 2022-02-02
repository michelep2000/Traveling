package es.travelworld.traveling;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
    private String registerUsername;
    private String registerPassword;


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
        getRegisterArgs();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private boolean isCorrectAuth(boolean isToHandleButton) {
        Editable username = binding.usernameInput.getText();
        Editable password = binding.passwordInput.getText();

        if (username == null || password == null) return false;

        binding.loginButton.setEnabled((username.length() > 0 && password.length() > 0));

        boolean isCorrect = username.toString().equals(registerUsername) && password.toString().equals(registerPassword);

        if (!isCorrect && !isToHandleButton)
            binding.usernameInput.setError(getString(R.string.error_login));

        return isCorrect;
    }

    private void getRegisterArgs() {
        Bundle args = getArguments();
        if (args == null) return;

        registerUsername = args.getString("username");
        registerPassword = args.getString("password");


    }

    private void setListeners() {
        binding.materialTextView2Btn.setOnClickListener(view -> Snackbar.make(view, getString(R.string.get_new_description), Snackbar.LENGTH_LONG).show());
        binding.materialTextView3Btn.setOnClickListener(view -> Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_registerFragment));

        binding.loginButton.setOnClickListener(view -> {
            if (isCorrectAuth(false)) setArgumentsTuNavigate(view);
            else {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage(R.string.wrong_auth_dialog_text).setPositiveButton(R.string.entendido, (dialog, id)->{}).show();

            }

        });

        setTextViewListeners();

    }

    private void setArgumentsTuNavigate(View view) {
        Bundle args = new Bundle();
        args.putString("username", registerUsername);
        args.putString("password", registerPassword);
        Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_homeFragment, args);
    }

    private void setTextViewListeners() {

        binding.usernameInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                isCorrectAuth(true);
            }
        });

        binding.passwordInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                isCorrectAuth(true);
            }
        });

    }

}
