package es.travelworld.traveling.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDialogFragment;

import es.travelworld.traveling.R;

public class MyDialog extends AppCompatDialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.info)
                .setMessage(R.string.exitAppDescription)
                .setPositiveButton(R.string.exit, (dialogInterface, i) -> {
                    System.exit(0);
                });
        return builder.create();
    }

}
