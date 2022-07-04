package com.mastercoding.firebase1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText userLog, passLog;
    Button signbtn, regbtn;

    // firebase authentication
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Initialize
        userLog = findViewById(R.id.userLogin);
        passLog = findViewById(R.id.passLogin);

        signbtn = findViewById(R.id.signbtn);
        regbtn = findViewById(R.id.regisBtn);

        signbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email_text  = userLog.getText().toString();
                String pass_text = passLog.getText().toString();

                // Checking if it is empty
                if(TextUtils.isEmpty(email_text) || TextUtils.isEmpty(pass_text)){
                    Toast.makeText(LoginActivity.this, "Please Fill All Fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    auth.signInWithEmailAndPassword(email_text,pass_text)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                  if(task.isSuccessful()){
                                      Intent i = new Intent(LoginActivity.this, MainActivity.class);
                                      i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                      startActivity(i);
                                      finish();
                                      
                                  }
                                  else{
                                      Toast.makeText(LoginActivity.this, "Login failed!", Toast.LENGTH_SHORT).show();
                                  }

                                }
                            });
                }
            }
        });
    }
}