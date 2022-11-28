package com.example.widgetsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // declaring widgets
    CheckBox box1, box2;
    RadioButton radioButton1, radioButton2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize widgets

        // Checkbox
        box1 = findViewById(R.id.checkbox1);
        box2 = findViewById(R.id.checkbox2);

        // Radio button
        radioButton1 = findViewById(R.id.radioButton);
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
        });

        // Button
        btn = findViewById(R.id.btn);

        // handle tap events
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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