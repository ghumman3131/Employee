package com.example.dell.employee_details;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ChangePassword extends AppCompatActivity {

    EditText pass1, pass2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        pass1 = (EditText) findViewById(R.id.password1);
        pass2 = (EditText) findViewById(R.id.passwword2);

    }

    public void change_password(View v)
    {
        if(pass1.getText().toString().length() < 8)
        {
            Toast.makeText(ChangePassword.this,"Password must be 8 character long",Toast.LENGTH_LONG).show();
            return;
        }
        if (! pass1.getText().toString().equals(pass2.getText().toString()) ) {
            Toast.makeText(ChangePassword.this,"Password doesn't match",Toast.LENGTH_LONG).show();
            return;
        }

        update_pass();

    }

    public  void update_pass()
    {




        JSONObject job = new JSONObject();



        try {
            job.put("emp_id" ,  getIntent().getStringExtra("eid")  );
            job.put("pass" , pass1.getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        System.out.println(job);
        JsonObjectRequest jobreq = new JsonObjectRequest("http://" + Ipaddress.ip + "/change_pass.php", job, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Toast.makeText(ChangePassword.this , "update successfully" , Toast.LENGTH_SHORT).show();


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                System.out.println(error);

            }
        });

        jobreq.setRetryPolicy(new DefaultRetryPolicy(20000 , 2 ,2));

        AppController app = new AppController(ChangePassword.this);
        app.addToRequestQueue(jobreq);

    }



}
