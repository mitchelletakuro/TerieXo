package com.example.teriexo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashboardActivity extends AppCompatActivity {
    Button Logout;

    //final SharedPreferences sharedPreferences = getSharedPreferences("DashboardActivity",MODE_PRIVATE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //final  String RegisterdUsername = sharedPreferences.getString("username", "Default username");
        //final  String RegisterdPassword = sharedPreferences.getString("password", "Default password");
        //final  String RegisterdPhone= sharedPreferences.getString("Phone", "Default Phone");

        Logout = findViewById(R.id.Logout);

        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();

            }
        });

            }




            {



    }


        {

        }
    }