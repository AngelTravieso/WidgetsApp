package com.example.widgetsapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR); // year
        int month = c.get(Calendar.MONTH); // month
        int day = c.get(Calendar.DAY_OF_MONTH); // day

        // create a date picker dialog
        return new DatePickerDialog(requireContext(), this, year, month, day);
    }

    // when the user select the date
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Toast.makeText(getContext(), String.format("Date: %s/%s/%s", year, month, dayOfMonth), Toast.LENGTH_LONG).show();
    }
}
