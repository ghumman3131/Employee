package com.example.dell.employee_details;

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

public class EmployLeave extends AppCompatActivity {

    RecyclerView rv ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employ_leave);

        rv = (RecyclerView) findViewById(R.id.cycle_re);

        rv.setLayoutManager(new LinearLayoutManager(EmployLeave.this,LinearLayoutManager.VERTICAL,false));

         onLeave();
    }

    public void onLeave()
    {



        JSONObject job = new JSONObject();

        JsonObjectRequest jobreq = new JsonObjectRequest("http://" + Ipaddress.ip + "/get_today_leaves.php", job, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                System.out.println(response);
                try {
                    JSONArray jarr = response.getJSONArray("today_leaves");

                    OnLeave_Adapter ad = new OnLeave_Adapter(jarr , EmployLeave.this);

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

        AppController app = new AppController(EmployLeave.this);

        app.addToRequestQueue(jobreq);

    }

}
