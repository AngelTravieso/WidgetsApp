package com.example.widgetsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // declaring widgets
    CheckBox box1, box2;
    RadioGroup radioGroup;
    Spinner spinner;
    ProgressBar progressBar;
    TimePicker timePicker;
    Button btn2;
    Button btn3;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize widgets

        // Checkbox
        box1 = findViewById(R.id.checkbox1);
        box2 = findViewById(R.id.checkbox2);

        // Radio Group
        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // here we are getting the radio button from our group
                RadioButton radioButton = findViewById(checkedId);
                Toast.makeText(MainActivity.this, "Selected: " + radioButton.getText(), Toast.LENGTH_LONG).show();
            }
        });

        // Spinner
        spinner = findViewById(R.id.spinner);

        // option for the spinner (1. Data source)
        String[] courses = {"C++", "Java", "Kotlin", "Data Structures"};

        // 2. Adapter
        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_item, courses);


        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // 3. Connect our adapter to the spinner
        spinner.setAdapter(ad);

        // Handle events for the spinners items
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // selected option
                Toast.makeText(MainActivity.this, "You Select: " + courses[i], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        // Time Picker
        /*timePicker = findViewById(R.id.timePicker);
        timePicker.setIs24HourView(true); // display time in 24hrs format*/

        btn2 = findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Display the time picker
                DialogFragment timePickerFrag = new TimePickerFragment();

                timePickerFrag.show(getSupportFragmentManager(), "Pick Time:");
            }
        });


        // Date Picker
        btn3 = findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePickerFrag = new DatePickerFragment();

                datePickerFrag.show(getSupportFragmentManager(), "Pick A Date");
            }
        });


        // Progress bar
        ProgressBar progressBar = findViewById(R.id.progressBar);
        // progressBar.setProgress(75); // percentage
        // progressBar.incrementProgressBy();



        // Radio button
 /*       radioButton1 = findViewById(R.id.radioButton);
        radioButton2 = findViewById(R.id.radioButton2);

        // tap of the radio button
        radioButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "With Delivery option selected", Toast.LENGTH_SHORT).show();
            }
        });

        radioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Without Delivery option selected", Toast.LENGTH_SHORT).show();
            }
        });*/

        // Button
        btn = findViewById(R.id.btn);

        // handle tap events
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // getting selected time
         /*       String currentTime = "Time: " + timePicker.getCurrentHour() + " : " + timePicker.getCurrentMinute();

                Toast.makeText(getApplicationContext(), String.format("%s", currentTime), Toast.LENGTH_SHORT).show();*/

                // Increase progress by10%
                progressBar.incrementProgressBy(10);

                if(!box1.isChecked() && !box2.isChecked()) {
                    Toast.makeText(MainActivity.this, "Please select a topping", Toast.LENGTH_SHORT).show();
                }

                // verify if the checkbox is checked
                if(box1.isChecked()) {
                    Toast.makeText(MainActivity.this, "Cheese Topping is added", Toast.LENGTH_SHORT).show();
                }

                if(box2.isChecked()) {
                    Toast.makeText(MainActivity.this, "Tomato Topping is added", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}