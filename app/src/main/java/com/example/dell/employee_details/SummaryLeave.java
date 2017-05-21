package com.example.dell.employee_details;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class SummaryLeave extends AppCompatActivity {

    TextView academic, casual , medical ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_leave);


        academic = (TextView) findViewById(R.id.academic_id);
        casual = (TextView) findViewById(R.id.casual_id);
        medical = (TextView) findViewById(R.id.medical_id);

        getLeaves();

    }
    private void getLeaves()
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

        JsonObjectRequest jobjreq = new JsonObjectRequest("http://"+Ipaddress.ip+"/get_left_leaves.php", js, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                System.out.println(response);

                try {
                    String acad =  response.getString("num_academic");
                    String cas = response.getString("num_casual");
                    String med = response.getString("num_medical");
                    academic.setText(acad);
                    casual.setText(cas);
                    medical.setText(med);
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

        AppController app = new AppController(SummaryLeave.this);

        app.addToRequestQueue(jobjreq);
    }
}
