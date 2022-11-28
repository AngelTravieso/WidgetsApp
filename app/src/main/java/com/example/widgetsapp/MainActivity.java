package com.example.widgetsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // declaring widgets
    CheckBox box1, box2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize widgets
        box1 = findViewById(R.id.checkbox1);
        box2 = findViewById(R.id.checkbox2);
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
                } else {

                }

                if(box2.isChecked()) {
                    Toast.makeText(MainActivity.this, "Tomato Topping is added", Toast.LENGTH_SHORT).show();
                } else {

                }
            }
        });


    }
}