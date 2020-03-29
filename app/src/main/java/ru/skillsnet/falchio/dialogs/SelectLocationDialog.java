package ru.skillsnet.falchio.dialogs;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;

import androidx.annotation.Nullable;
import androidx.preference.PreferenceManager;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.Objects;

import ru.skillsnet.falchio.R;

public class SelectLocationDialog extends BottomSheetDialogFragment {
    private OnDialogListener dialogListener;
    private AutoCompleteTextView autoCompleteTextView;

    public static SelectLocationDialog newInstance() {
        return new SelectLocationDialog();
    }

    public void setOnDialogListener(OnDialogListener dialogListener){
        this.dialogListener = dialogListener;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_dialog, container,
                false);
        autoCompleteTextView=view.findViewById(R.id.enterUserLocation2);

        setCancelable(false);
        view.findViewById(R.id.btnCancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        view.findViewById(R.id.btnYes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(Objects.requireNonNull(getContext()));
                String userLocation =  autoCompleteTextView.getText().toString();
                Log.e("TAG", "onClick: " + userLocation );
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("location", userLocation);
                editor.commit();
                if (dialogListener!=null){dialogListener.onDialogYes();}
            }
        });

        return view;
    }
}
