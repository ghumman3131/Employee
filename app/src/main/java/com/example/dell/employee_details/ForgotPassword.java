package com.example.dell.employee_details;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class ForgotPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);
    }
    public void forgot (View v)
    {
        EditText mobile_et = (EditText) findViewById(R.id.MobileBox);
        String mobile =mobile_et.getText().toString();
        if (mobile.length()<10 )

        {
            Toast.makeText(ForgotPassword.this, " Mobile Number Must Be Of 10 Digits", Toast.LENGTH_SHORT).show();
            return;
        }

        check_mobile(mobile);


    }

    public void check_mobile(String mobile)
    {

        JSONObject job = new JSONObject();

        try {
            job.put("mobile" , mobile);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jobreq = new JsonObjectRequest("http://" + Ipaddress.ip + "/check_mobile.php", job, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    if(response.getString("key").equals("done"))
                    {
                        int randomPIN = (int)(Math.random()*9000)+1000;

                        Intent k = new Intent(ForgotPassword.this , VerifyOtp.class);

                        k.putExtra("eid", response.getString("eid"));
                        k.putExtra("pin" , randomPIN);

                        startActivity(k);
                    }

                    else {
                        Toast.makeText(ForgotPassword.this, "number does not exist", Toast.LENGTH_SHORT).show();
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        jobreq.setRetryPolicy(new DefaultRetryPolicy(20000 , 2, 2));

        AppController app = new AppController(ForgotPassword.this);

        app.addToRequestQueue(jobreq);
    }

}

