package com.example.dell.employee_details;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class UserSettings extends AppCompatActivity

{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_settings);
    }


    public void change_password(View view) {

        SharedPreferences sp = getSharedPreferences("Emp_info" , MODE_PRIVATE);

        Intent i = new Intent(UserSettings.this, ChangePassword.class);

        i.putExtra("eid" , sp.getString("eid" , ""));

        startActivity(i);

    }

    public void logout(View view) {

        SharedPreferences.Editor sp = getSharedPreferences("Emp_info", MODE_PRIVATE).edit();

        sp.clear();

        sp.commit();

        Drawer_activity.inst.finish();
        finish();
    }

    public void set_security(View view) {



        Intent i = new Intent(UserSettings.this, AddSecurityQuestion.class);



        startActivity(i);
    }
}
