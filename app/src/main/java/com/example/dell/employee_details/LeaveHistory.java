package com.example.dell.employee_details;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LeaveHistory extends AppCompatActivity {

    RecyclerView rv ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leave_history);

        rv = (RecyclerView) findViewById(R.id.recycler_id);

        rv.setLayoutManager(new LinearLayoutManager(LeaveHistory.this,LinearLayoutManager.VERTICAL,false));

        get_data();
    }


    public void get_data()
    {

        JSONObject job = new JSONObject();


        SharedPreferences.Editor sp = getSharedPreferences("Emp_info",MODE_PRIVATE).edit();


        try {
            job.put("employ_id" , sp.putString("eid",""));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jobreq = new JsonObjectRequest("http://" + Ipaddress.ip + "/oldHistory.php", job, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                System.out.println(response);
                try {
                    JSONArray jarr = response.getJSONArray("result");

                    history_adapter ad = new history_adapter(jarr , LeaveHistory.this);

                    rv.setAdapter(ad);
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

        jobreq.setRetryPolicy(new DefaultRetryPolicy(20000 , 2 ,2 ));

        AppController app = new AppController(LeaveHistory.this);

        app.addToRequestQueue(jobreq);

    }
}
