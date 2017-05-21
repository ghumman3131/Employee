package com.example.dell.employee_details;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LeaveDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave);
    }

    public void ApplyLeave(View v)
    {
        Intent i = new Intent(LeaveDetail.this,ApplyLeave.class);

        startActivity(i);
    }
    public void Summary(View v)
    {
        Intent i = new Intent(LeaveDetail.this,SummaryLeave.class);

        startActivity(i);
    }
    public void Cancel(View v)
    {
        Intent i = new Intent(LeaveDetail.this,LeaveStatus.class);

        startActivity(i);
    }
    public void history (View v)
    {
        Intent i = new Intent(LeaveDetail.this,LeaveHistory.class);

        startActivity(i);
    }
}
