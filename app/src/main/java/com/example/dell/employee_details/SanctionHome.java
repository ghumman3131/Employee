package com.example.dell.employee_details;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SanctionHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sanction_home);
    }
    public void Applied(View v )
    {
        Intent i = new Intent(SanctionHome.this,Applied_Leaves.class);
        startActivity(i);
    }
    public void myProfile(View v )
    {
        Intent i = new Intent(SanctionHome.this,MultiProfile.class);
        i.putExtra("from_key" , "sanction");
        startActivity(i);
    }
    public void Leaves(View v)
    {
        Intent i = new Intent(SanctionHome.this,EmployLeave.class);
        startActivity(i);
    }
}
