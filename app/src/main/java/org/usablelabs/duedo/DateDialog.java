package org.usablelabs.duedo;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

/**
 * Created by nitsarin on 9/2/2559.
 */
public class DateDialog extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    EditText dateEdit;

    public DateDialog(View view) {
        dateEdit = (EditText) view;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState){

    final Calendar c = Calendar.getInstance();
    int year = c.get(Calendar.YEAR);
    int month = c.get(Calendar.MONTH);
    int day = c.get(Calendar.DAY_OF_MONTH);
    return new DatePickerDialog(getActivity(), this,year,month,day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day){

        String date=day+"-"+(month+1)+"-"+year;
        dateEdit.setText(date);
    }
}


