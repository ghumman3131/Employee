package com.example.dell.employee_details;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Applied_Leaves extends AppCompatActivity {

    RecyclerView rv ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applied);

        rv = (RecyclerView) findViewById(R.id.recycler_id);

        rv.setLayoutManager(new LinearLayoutManager(Applied_Leaves.this,LinearLayoutManager.VERTICAL,false));

        get_data();
    }


    public void get_data()
    {

        JSONObject job = new JSONObject();


            SharedPreferences.Editor sp = getSharedPreferences("Emp_info",MODE_PRIVATE).edit();
            sp.putString("eid","");




        JsonObjectRequest jobreq = new JsonObjectRequest("http://" + Ipaddress.ip + "/get_leave_history.php", job, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                System.out.println(response);
                try {
                    JSONArray jarr = response.getJSONArray("result");

                    leaves_adapter ad = new leaves_adapter(jarr , Applied_Leaves.this);

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

        AppController app = new AppController(Applied_Leaves.this);

        app.addToRequestQueue(jobreq);

    }


    public static void update_status(String leave_id , final Activity a)
    {
        JSONObject job = new JSONObject();


        try {
            job.put("leave_id" , leave_id);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jobreq = new JsonObjectRequest("http://" + Ipaddress.ip + "/approve_leave.php", job, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    if(response.getString("key").equals("done"))
                    {
                        Toast.makeText(a , "approved" , Toast.LENGTH_SHORT).show();

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

        jobreq.setRetryPolicy(new DefaultRetryPolicy(2000 , 2, 2 ));

        AppController app = new AppController(a);

        app.addToRequestQueue(jobreq);


    }
    public static void cancel_status(String leave_id , final Activity a)
    {
        JSONObject job = new JSONObject();


        try {
            job.put("leave_id" , leave_id);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jobreq = new JsonObjectRequest("http://" + Ipaddress.ip + "/cancel_leave.php", job, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    if(response.getString("key").equals("done"))
                    {
                        Toast.makeText(a , "Leave Cancelled" , Toast.LENGTH_SHORT).show();

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

        jobreq.setRetryPolicy(new DefaultRetryPolicy(2000 , 2, 2 ));

        AppController app = new AppController(a);

        app.addToRequestQueue(jobreq);


    }
}
