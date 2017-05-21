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

public class ProfessionalD extends Fragment {

    TextView  eid, dept , desg , matric ,  high , grad , ps , reward , exp , fos ;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_professional,container,false);
        dept = (TextView)v.findViewById(R.id.DEpt_id);
        eid = (TextView)v.findViewById(R.id.EID);
        desg = (TextView)v.findViewById(R.id.Desg_id);
        matric = (TextView)v.findViewById(R.id.Matric_id);
        high = (TextView)v.findViewById(R.id.High_id);
        grad =(TextView) v.findViewById(R.id.Grad_id);
        ps = (TextView)v.findViewById(R.id.PG_id);
        reward =(TextView) v.findViewById(R.id.Reward_id);
        exp = (TextView)v.findViewById(R.id.Exp_id);
        fos =(TextView) v.findViewById(R.id.Fos_id);
        getProf();
        return v;
    }

    private void getProf()
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

        JsonObjectRequest jobjreq = new JsonObjectRequest("http://"+Ipaddress.ip+"/ProfDetails.php", js, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                System.out.println(response);

                try {
                    String dept1 = response.getString("department");
                    String desg1 = response.getString("designation");
                    String matric1 = response.getString("matric");
                    String high1 = response.getString("highsch");
                    String grad1 = response.getString("grad");
                    String pg1 = response.getString("p_grad");
                    String re1 = response.getString("rewards");
                    String exp1 = response.getString("exp");
                    String fos1 = response.getString("fos");
                    dept.setText(dept1);
                    desg.setText(desg1);
                    matric.setText(matric1);
                    high.setText(high1);
                    grad.setText(grad1);
                    ps.setText(pg1);
                    reward.setText(re1);
                    exp.setText(exp1);
                    fos.setText(fos1);

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

        AppController app = new AppController(getActivity());

        app.addToRequestQueue(jobjreq);
    }




}

