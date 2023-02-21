package com.example.myapplicationsasdas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText email, password;
    private TextView signin;
    private Button signupbutton, signinbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.email);
        signin = findViewById(R.id.signin);
        password = findViewById(R.id.password);
        signinbutton = findViewById(R.id.signinbutton);
        signupbutton = findViewById(R.id.signupbutton);
        signinbutton.setOnClickListener((View.OnClickListener) this);
        signupbutton.setOnClickListener((View.OnClickListener) this);


    }

    //on click function for buttons
    @Override
    public void onClick(View view) {
        if (signinbutton == view) {
            Intent intent = new Intent(this, newactivitywhat.class);
            startActivity(intent);
        }
        else if (signupbutton == view) {
            signin.setText("still under construction");
        }

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }





}