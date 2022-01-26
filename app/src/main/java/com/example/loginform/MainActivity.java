package com.example.loginform;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper db;
    EditText mTextUsername;
    EditText mTextPassword;
    Button mButtonLogin;
    Button mButtonRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);

        mTextUsername = (EditText) findViewById(R.id.edittext_username);
        mTextPassword = (EditText) findViewById(R.id.edittext_password);
        mButtonLogin = (Button) findViewById(R.id.button_login);
        mButtonRegister = (Button) findViewById(R.id.button_register);


        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent registerIntent = new Intent(MainActivity.this, Register.class);

                startActivity(registerIntent);
            }
        });

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = mTextUsername.getText().toString().trim();
                String pwd = mTextPassword.getText().toString().trim();
                Boolean res = db.checkUser(user, pwd);
                if (res == true) {
                    Intent HomePage = new Intent(MainActivity.this, home.class);
                    startActivity(HomePage);
                } else {
                    Toast.makeText(MainActivity.this, "Login Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}











