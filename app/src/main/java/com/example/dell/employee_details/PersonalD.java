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
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class PersonalD extends Fragment {


    TextView name , dob , father , mother , marital , spouse , address , contact ;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_personal,container,false);

        name = (TextView) v.findViewById(R.id.User_id);
        dob = (TextView) v.findViewById(R.id.dob_id);
        father = (TextView) v.findViewById(R.id.Father_id);
        mother = (TextView) v.findViewById(R.id.Mother_id);
        marital = (TextView) v.findViewById(R.id.M_status);
        spouse = (TextView) v.findViewById(R.id.Spouse_id);
        address = (TextView) v.findViewById(R.id.address_id);
        contact = (TextView) v.findViewById(R.id.contact_id);

        if(getArguments().getString("from").equals("personal")) {

            getEmpDetail();
        }
        else {
            getSanctionDetails();
        }
        return v;
    }

    private void getEmpDetail()
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

        JsonObjectRequest jobjreq = new JsonObjectRequest("http://"+Ipaddress.ip+"/get_details.php", js, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                System.out.println(response);

                try {
                    String name1 =  response.getString("name");
                    String dob1 = response.getString("dob");
                    String father1 = response.getString("father");
                    String mother1 = response.getString("mother");
                    String marital1 = response.getString("marital");
                    String spouse1 = response.getString("spouse");
                    String address1 = response.getString("address");
                    String contact1 = response.getString("contact");
                    name.setText(name1);
                    dob.setText(dob1);
                    father.setText(father1);
                    mother.setText(mother1);
                    marital.setText(marital1);
                    spouse.setText(spouse1);
                    address.setText(address1);
                    contact.setText(contact1);

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

    private void getSanctionDetails()
    {
        SharedPreferences sp = getActivity().getSharedPreferences("Sanction_info", Context.MODE_PRIVATE);
        String id = sp.getString("sid"," ");
        JSONObject js = new JSONObject();
        try {
            js.put("key_id" , id);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        System.out.print(js);

        JsonObjectRequest jobjreq = new JsonObjectRequest("http://"+Ipaddress.ip+"/sanctioner_details.php", js, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                System.out.println(response);

                try {
                    String name1 =  response.getString("name");
                    String dob1 = response.getString("dob");
                    String father1 = response.getString("father");
                    String mother1 = response.getString("mother");
                    String marital1 = response.getString("marital");
                    String spouse1 = response.getString("spouse");
                    String address1 = response.getString("address");
                    String contact1 = response.getString("contact");
                    name.setText(name1);
                    dob.setText(dob1);
                    father.setText(father1);
                    mother.setText(mother1);
                    marital.setText(marital1);
                    spouse.setText(spouse1);
                    address.setText(address1);
                    contact.setText(contact1);

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
