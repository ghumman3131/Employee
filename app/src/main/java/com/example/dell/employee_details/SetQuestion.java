package com.example.dell.employee_details;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;

public class SetQuestion extends AppCompatActivity {


    Spinner spin ;
    EditText ans ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_question);

        spin = (Spinner) findViewById(R.id.set_spin);
        ans = (EditText) findViewById(R.id.ans);
    }


}
