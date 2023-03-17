package com.example.myapplicationsasdas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{

    private Button submit;
    private FirebaseAuth mAuth;
    private String email_signup;
    private String password_signup;
    private String name_signup;
    private FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupactivity);
        submit = findViewById(R.id.submit);
        email_signup = findViewById(R.id.email_signup).toString();
        password_signup = findViewById(R.id.password_signup).toString();
        name_signup = findViewById(R.id.name_signup).toString();

        submit.setOnClickListener((View.OnClickListener) this);
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        create_user(name_signup, email_signup, password_signup);
    }

    @Override
    public void onClick(View view) {
        if (submit == view) {
            Intent intent2 = new Intent(this, HomeActivity.class);
            startActivity(intent2);
        }
    }


    private void create_user(String email, String password, String name) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            String uid = mAuth.getCurrentUser().getUid();
                            User user = new User (name, email, password);
                            database.getReference("Users").child(uid).setValue(user);
                            Intent I = new Intent(SignUpActivity.this, HomeActivity.class);
                            startActivity(I);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(SignUpActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
    }


}