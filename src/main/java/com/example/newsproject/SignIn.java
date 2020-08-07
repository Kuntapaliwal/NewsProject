package com.example.newsproject;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignIn extends AppCompatActivity {


    private FirebaseAuth mAuth;
    private EditText musername;
    private EditText mpassword;
    private Button msigninButton;
    NetworkConnectivity broadcastreceiver=new NetworkConnectivity();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        musername=findViewById(R.id.email);
        mpassword=findViewById(R.id.password);
        msigninButton=findViewById(R.id.signinButton);

        msigninButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=musername.getText().toString().trim();
                String password=mpassword.getText().toString().trim();
                if(!(TextUtils.isEmpty(username)&&TextUtils.isEmpty(password))){
                    mAuth.createUserWithEmailAndPassword(username, password)
                            .addOnCompleteListener (new OnCompleteListener<AuthResult>(){
                                @Override
                                public void onComplete( Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(SignIn.this, "Succesfully Login", Toast.LENGTH_LONG).show();
                                        Intent intent = new Intent(SignIn.this, SkipNext.class);
                                        startActivity(intent);
                                        finish();
                                        // FirebaseUser user = mAuth.getCurrentUser(// updateUI(user);
                                    }
                                    else{
                                        Toast.makeText(SignIn.this, "Check Connection", Toast.LENGTH_LONG).show();                             }
                                }
                            });
                }
                else{
                    Toast.makeText(SignIn.this,"fill all info correctly",Toast.LENGTH_LONG).show();
                    FirebaseUser user = mAuth.getCurrentUser();

                }


            }
        });

    }


    }

