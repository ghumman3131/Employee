package com.example.dell.employee_details;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.net.Inet4Address;

public class PasswordRecovery extends AppCompatActivity {

    Button otp , security , back ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_recovery);

        otp = (Button) findViewById(R.id.otp_send);
        security=(Button) findViewById(R.id.ques_seccurity);
        back=(Button) findViewById(R.id.back_page);
    }

    public void send_otp(View v)
    {
        Intent i = new Intent(PasswordRecovery.this,ForgotPassword.class);
        startActivity(i);
    }
    public  void security_ques(View v)
    {
        Intent i = new Intent(PasswordRecovery.this, SecurityQuestion.class);
        startActivity(i);

    }
    public  void back(View v)
    {
        Intent i = new Intent(PasswordRecovery.this, MainActivity.class);
        startActivity(i);
    }
}
