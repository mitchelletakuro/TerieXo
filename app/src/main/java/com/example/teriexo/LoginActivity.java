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
    Intent intent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Username = findViewById(R.id.Username);
        Password = findViewById(R.id.Password);
        Login = findViewById(R.id.Login);
        Register = findViewById(R.id.Register);

        preferences = getSharedPreferences("DashboardActivity", MODE_PRIVATE);

        final Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
        if(preferences.contains("username") && preferences.contains("password")){
            startActivity(intent);
        }

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String UsernameValue = Username.getText().toString();
                String PasswordValue = Password.getText().toString();

                String RegisterdUsername = preferences.getString("Username", "Default Username");
                String RegisterdPassword = preferences.getString("Password", "Default Password");

                if (UsernameValue.equals(RegisterdUsername) && PasswordValue.equals(RegisterdPassword)) {
                    //preferences.edit().apply();
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("username",UsernameValue);
                    editor.putString("password",PasswordValue);
                    editor.commit();
                    Toast.makeText(LoginActivity.this, "Login Successful",Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Wrong login details", Toast.LENGTH_SHORT).show();
                }



            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);


            }
        });

    }
}