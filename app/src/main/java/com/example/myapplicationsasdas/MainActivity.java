package com.example.myapplicationsasdas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText email, password;
    private TextView signin;
    private Button signupbutton, signinbutton;
    private FirebaseAuth mAuth;



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

        mAuth = FirebaseAuth.getInstance();


    }

//    on click function for buttons
    @Override
    public void onClick(View view) {
        if (signinbutton == view) {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        }
        else if (signupbutton == view) {
            Intent intent1 = new Intent(this, SignUpActivity.class);
            startActivity(intent1);
        }
    }

    private void signin_user(String email, String password)  {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Intent I = new Intent(MainActivity.this, HomeActivity.class);
                            startActivity(I);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }


}