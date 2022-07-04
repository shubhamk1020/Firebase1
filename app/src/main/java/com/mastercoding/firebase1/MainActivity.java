package com.mastercoding.firebase1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //Widgets
    EditText userET, passET, emailET;
    Button signbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize
        userET = findViewById(R.id.editTextuser);
        passET = findViewById(R.id.editTextPassword);
        emailET = findViewById(R.id.editTextEmail);

        signbtn = findViewById(R.id.signupbtn);
    }
}