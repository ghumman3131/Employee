package com.example.dell.employee_details;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class Role_select extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role);
    }
    public void Employee(View v)
    {
        Intent i= new Intent(Role_select.this,MainActivity.class);
        startActivity(i);


    }
    public void Sanction(View v)
    {
        Intent i= new Intent(Role_select.this,SanctionLogin.class);
        startActivity(i);


    }
}
