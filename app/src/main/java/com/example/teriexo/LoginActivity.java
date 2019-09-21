package com.example.teriexo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText Username, Password;
    Button Login, Register;

    SharedPreferences preferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Username = findViewById(R.id.Username);
        Password = findViewById(R.id.Password);
        Login = findViewById(R.id.Login);
        Register = findViewById(R.id.Register);

        preferences = getSharedPreferences("DashboardActivity", MODE_PRIVATE);


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String UsernameValue = Username.getText().toString();
                String PasswordValue = Password.getText().toString();

                Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                startActivity(intent);


                String RegisterdUsername = preferences.getString("Username", "Default Username");
                String RegisterdPassword = preferences.getString("Password", "Default Password");

                if (UsernameValue.equals(RegisterdUsername) && PasswordValue.equals(RegisterdPassword)) {
                  //preferences.edit().apply();


                } else {
                    Toast.makeText(LoginActivity.this, "wrong login details", Toast.LENGTH_SHORT).show();
                }


                Register.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                        startActivity(intent);


                    }
                });


            }
        });
        }}