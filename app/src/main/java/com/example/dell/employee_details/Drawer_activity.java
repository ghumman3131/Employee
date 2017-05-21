package com.example.dell.employee_details;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Drawer_activity extends AppCompatActivity {

   RecyclerView rv ;

    DrawerLayout mDrawerLayout;

    public static Drawer_activity inst ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        inst = this ;

        rv = (RecyclerView) findViewById(R.id.recycle_id);

        rv.setLayoutManager(new LinearLayoutManager(Drawer_activity.this,LinearLayoutManager.VERTICAL,false));

        On_leave();

    }

    private void On_leave() {

        JSONObject job = new JSONObject();

        JsonObjectRequest jobreq = new JsonObjectRequest("http://" + Ipaddress.ip + "/get_today_leaves.php", job, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                System.out.println(response);
                try {
                    JSONArray jarr = response.getJSONArray("today_leaves");

                    OnLeave_Adapter ad = new OnLeave_Adapter(jarr , Drawer_activity.this);

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

        AppController app = new AppController(Drawer_activity.this);

        app.addToRequestQueue(jobreq);

     }

    public void personalDetail(View v)
    {
        Intent i= new Intent(Drawer_activity.this,MultiProfile.class);
        i.putExtra("from_key","personal");
        startActivity(i);


    }

    public void professionalDetail(View v)
    {
        Intent i= new Intent(Drawer_activity.this,MultiProfile.class);
        i.putExtra("from_key","professional");
        startActivity(i);


    }
    public void HealthDetails(View v)
    {
        Intent i= new Intent(Drawer_activity.this,MultiProfile.class);
        i.putExtra("from_key","health");
        startActivity(i);


    }
    public void Leaves(View v)
    {
        Intent i= new Intent(Drawer_activity.this,LeaveDetail.class);
        startActivity(i);


    }
    public void slidee (View  v)
    {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.my_drawer_layout);


        mDrawerLayout.openDrawer(Gravity.LEFT);

    }
    public void back (View  v)
    {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.my_drawer_layout);


        mDrawerLayout.closeDrawer(Gravity.LEFT);

    }
    public void setting (View  v)
    {
        Intent i = new Intent(Drawer_activity.this,UserSettings.class);
        startActivity(i);

    }
}
