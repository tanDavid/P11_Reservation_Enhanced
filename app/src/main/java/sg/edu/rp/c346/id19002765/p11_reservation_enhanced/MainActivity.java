package sg.edu.rp.c346.id19002765.p11_reservation_enhanced;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText etName, etDay, etTime;
    EditText etTelephone;
    EditText etSize;
    CheckBox checkBox;

    Button btReserve;
    Button btReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etTelephone = findViewById(R.id.editTextTelephone);
        etSize = findViewById(R.id.editTextSize);
        checkBox = findViewById(R.id.checkBox);
        etDay = findViewById(R.id.editTextDate);
        etTime = findViewById(R.id.editTextTime);

        btReserve = findViewById(R.id.buttonReserve);
        btReset = findViewById(R.id.buttonReset);


        etDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        etDay.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                };

                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this, myDateListener, Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH),Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
                myDateDialog.show();
            }
        });

        etTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create the listener to set the time
                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        etTime.setText( hourOfDay + ":" + minute);
                    }
                };

                //Create the time picker dialog
                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this, myTimeListener, Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), true);
                myTimeDialog.show();
            }
        });

        btReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String isSmoke = "";
                if (checkBox.isChecked()) {
                    isSmoke = "smoking";
                }
                else {
                    isSmoke = "non-smoking";
                }

                //Create the dialog builder
                final AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);


                myBuilder.setTitle("Confirm Your Order");
                myBuilder.setMessage("New Reservation \n Name: " + etName.getText().toString() + " \n Smoking: " + isSmoke + " \n Size: " + etSize.getText().toString() + " \n Date: " + etDay.getText().toString() + "\n Time: " + etTime.getText().toString());


                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String isSmoke = "";
                        if (checkBox.isChecked()) {
                            isSmoke = "smoking";
                        }
                        else {
                            isSmoke = "non-smoking";
                        }
                        String msg = "New Reservation \n Name: " + etName.getText().toString() + " \n Smoking: " + isSmoke + " \n Size: " + etSize.getText().toString() + " \n Date: " + etDay.getText().toString() + "\n Time: " + etTime.getText().toString();
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
                    }
                });

                myBuilder.setNeutralButton("Cancel", null);

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();

            }
        });

        btReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etName.setText("");
                etTelephone.setText("");
                etSize.setText("");
                checkBox.setChecked(false);

            }
        });
    }
}
