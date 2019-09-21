package com.example.teriexo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText Name, Username, Email, Password, Phone;
    Button  Register;



    SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Name = findViewById(R.id.Name);
        Username = findViewById(R.id.Username);
        Email = findViewById(R.id.Email);
        Password = findViewById(R.id.Password);
        Phone= findViewById(R.id.Phone);
        Register = findViewById(R.id.Register);


        preferences = getSharedPreferences("DashboardActivity", MODE_PRIVATE);




        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String NameValue = Name.getText().toString();
                String UsernameValue = Username.getText().toString();
                String EmailValue = Email.getText().toString();
                String PasswordValue = Password.getText().toString();
                String PhoneValue = Phone.getText().toString();


                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);


                if (NameValue.length()<1) {
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("Name", NameValue);
                    editor.putString("Username", UsernameValue);
                    editor.putString("Email", EmailValue);
                    editor.putString("Password", PasswordValue);
                    editor.putString("Phone", PhoneValue);
                    editor.apply();

                    Toast.makeText(RegisterActivity.this, "User Registers", Toast.LENGTH_SHORT).show();
                }

               else {
                  Toast.makeText(RegisterActivity.this, "Enter required fields", Toast.LENGTH_SHORT).show();
                }








    }
}
        );
    }
}