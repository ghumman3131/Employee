package com.example.dell.employee_details;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class LeaveStatus extends AppCompatActivity {

    TextView status_leave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
        status_leave = (TextView) findViewById(R.id.status_id);

        leave_status();
    }


    private void leave_status()
    {
        SharedPreferences sp = getSharedPreferences("Emp_info", Context.MODE_PRIVATE);
        String id = sp.getString("eid"," ");

        JSONObject js = new JSONObject();

        try {
            js.put("key_id" , id);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        System.out.print(js);

        JsonObjectRequest jobjreq = new JsonObjectRequest("http://"+Ipaddress.ip+"/leave_status.php", js, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                System.out.println(response);

                try {
                    String statusleave =  response.getString("result");
                    status_leave.setText(statusleave);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error);

            }
        });

        jobjreq.setRetryPolicy(new DefaultRetryPolicy(20000, 2 , 2));

        AppController app = new AppController(LeaveStatus.this);

        app.addToRequestQueue(jobjreq);
    }
}
