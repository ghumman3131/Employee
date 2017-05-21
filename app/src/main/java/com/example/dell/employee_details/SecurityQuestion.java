package com.example.dell.employee_details;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SecurityQuestion extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spin_ques;

    EditText answer, emp;


    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security_question);

        spin_ques = (Spinner) findViewById(R.id.spin_ques);
        answer = (EditText) findViewById(R.id.answer);
        emp = (EditText) findViewById(R.id.for_emp);
        spin_ques.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);


        List<String> categories = new ArrayList<String>();
        categories.add("Select security question...");
        categories.add("What was the name of your elementary / primary school?");
        categories.add("In what city or town does your nearest sibling live?");
        categories.add("What time of the day were you born?");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);


        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spin_ques.setAdapter(dataAdapter);

        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void submit(View v) {

        final String spin = spin_ques.getSelectedItem().toString();
        if (spin.equals("Select security question...")) {
            Toast.makeText(SecurityQuestion.this, "Please select your question.", Toast.LENGTH_LONG).show();
            return;
        }
        if (answer.getText().toString().equals(""))
        {
            Toast.makeText(SecurityQuestion.this,"Answer required",Toast.LENGTH_LONG).show();
            return;

        }

        JSONObject js = new JSONObject();
        try {
            js.put("emp" , emp.getText().toString());
            js.put("ques", spin);
            js.put("ans", answer.getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        System.out.println(js);

        JsonObjectRequest jobjreq = new JsonObjectRequest("http://" + Ipaddress.ip + "/security_question.php", js, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                System.out.println(response);
                try {
                    if (response.getString("pass_key").equals("answer matched")) {



                        Intent i = new Intent(SecurityQuestion.this, ChangePassword.class);
                        i.putExtra("eid" , emp.getText().toString());
                        startActivity(i);
                        finish();

                    } else if (response.get("pass_key").equals("incorrect answer")) {
                        Toast.makeText(SecurityQuestion.this, "Please retry", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(SecurityQuestion.this, "Security question doesn't match", Toast.LENGTH_SHORT).show();
                    }
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

        jobjreq.setRetryPolicy(new DefaultRetryPolicy(20000, 3, 2));

        AppController ap = new AppController(SecurityQuestion.this);
        ap.addToRequestQueue(jobjreq);


    }

}

