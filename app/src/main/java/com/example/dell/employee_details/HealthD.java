package com.example.dell.employee_details;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class HealthD extends Fragment {
TextView enamee, bgroupp, heightt, weightt;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_health,container,false);
        enamee=(TextView) v.findViewById(R.id.ename_id);
        bgroupp=(TextView)v.findViewById(R.id.blood_id);
        heightt=(TextView)v.findViewById(R.id.height_id);
        weightt=(TextView)v.findViewById(R.id.weight_id);
        gethealth();
        return  v;
    }
private void gethealth()
{
    SharedPreferences sp = getActivity().getSharedPreferences("Emp_info", Context.MODE_PRIVATE);
    String id = sp.getString("eid"," ");
    JSONObject js = new JSONObject();
    try {
        js.put("key_id" , id);
    } catch (JSONException e) {
        e.printStackTrace();
    }

    System.out.print(js);

    JsonObjectRequest jobjreq = new JsonObjectRequest("http://"+Ipaddress.ip+"/healthDetails.php", js, new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) {

            System.out.println(response);

            try {
                String ename1 = response.getString("ename");
                String bgroup1 = response.getString("bgroup");
                String height1 = response.getString("height");
                String weight1 = response.getString("weight");
                enamee.setText(ename1);
                bgroupp.setText(bgroup1);
                heightt.setText(height1);
                weightt.setText(weight1);


            }
            catch (JSONException e) {
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

    AppController app = new AppController(getActivity());

    app.addToRequestQueue(jobjreq);
}
}
