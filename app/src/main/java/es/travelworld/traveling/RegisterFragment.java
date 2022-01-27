package es.travelworld.traveling;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import es.travelworld.traveling.databinding.RegisterFragmentBinding;

public class RegisterFragment extends Fragment {

    private RegisterFragmentBinding binding;

    ActivityResultLauncher<Intent> cameraResultLauncher;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = RegisterFragmentBinding.inflate(inflater, container, false);

        String[] ages = getResources().getStringArray(R.array.years);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(requireContext(), R.layout.dorpdown_item, ages);
        binding.yearsDropdown.setAdapter(arrayAdapter);

        setCameraResultLauncher();
        handleButtonByTextFieldLogic();

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


    private void handleButtonByTextFieldLogic() {

        Editable name = binding.nameInput.getText();
        Editable lastName = binding.lastnameInput.getText();
        if (name == null && lastName == null) return;

        assert name != null && lastName != null;

        boolean isNameIncorrectFormatted = name.toString().contains("!") || name.toString().contains("@");
        boolean isLastNameIncorrectFormatted = lastName.toString().contains("!") || lastName.toString().contains("@");
        boolean isButtonEnabled = (binding.nameInput.length() > 0 && binding.lastnameInput.length() > 0) && (!isLastNameIncorrectFormatted && !isNameIncorrectFormatted);

        if (isNameIncorrectFormatted)
            binding.nameInput.setError(getString(R.string.error_name_lastname));

        if (isLastNameIncorrectFormatted)
            binding.lastnameInput.setError(getString(R.string.error_name_lastname));

        binding.registerBtn.setEnabled(isButtonEnabled);
    }

    private void setCameraResultLauncher() {
        cameraResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        assert data != null;
                        Bitmap photo = (Bitmap) data.getExtras().get("data");
                        binding.imgProfile.setImageBitmap(photo);

                    }
                });
    }

    private void openCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraResultLauncher.launch(intent);
    }

    private void openWeb() {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://developers.google.com/ml-kit/terms"));
        startActivity(browserIntent);
    }

    private void handleDropdownErrors() {
        Editable dropdownText = binding.yearsDropdown.getText();
        if(!dropdownText.toString().contains("18")){
            binding.yearsDropdown.setError(getString(R.string.app_not_for_you));
        }
    }

    private void setListeners() {
        binding.goBack.setOnClickListener(view -> Navigation.findNavController(view).navigate(R.id.action_registerFragment_to_loginFragment));
        binding.imgProfile.setOnClickListener(view -> openCamera());
        binding.seeConditionsBtn.setOnClickListener(view -> openWeb());
        setTextViewListeners();
    }

    private void setTextViewListeners() {
        binding.nameInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                handleButtonByTextFieldLogic();
            }
        });

        binding.lastnameInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                handleButtonByTextFieldLogic();
            }
        });

        binding.yearsDropdown.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                handleDropdownErrors();
            }
        });
    }

}