package com.example.dell.employee_details;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.CountDownTimer;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ScrollView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONException;
import org.json.JSONObject;

public class ApplyLeave extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    int year, year1;
    int month, month1;
    int day, day1;
    EditText date, date1 , reason_edit;
    private ScrollView scroll;
    Spinner spinner ;
    TextView days_text ;

    private CheckBox first_half , second_half ;

    private String num_days = "";

    int acad_left = 0 , casual_left = 0 , medical_left = 0 ;



    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply);
        date = (EditText) findViewById(R.id.editText);
        date1 = (EditText) findViewById(R.id.editText2);
        reason_edit = (EditText) findViewById(R.id.reason_id);
        spinner = (Spinner) findViewById(R.id.spinner);
        days_text = (TextView) findViewById(R.id.spinner2);
        scroll = (ScrollView) findViewById(R.id.scroll_id);
        first_half = (CheckBox) findViewById(R.id.check1);
        second_half = (CheckBox) findViewById(R.id.check2);

        spinner.setOnItemSelectedListener(this);


        List<String> categories = new ArrayList<String>();
        categories.add("Select Type of Leave");
        categories.add("Academic");
        categories.add("Casual");
        categories.add("Medical");


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);


        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinner.setAdapter(dataAdapter);

        spinner.setOnItemSelectedListener(this);


        List<String> categories2 = new ArrayList<String>();
        categories2.add("No. Of Days ");
        categories2.add("1");
        categories2.add("2");
        categories2.add("3");
        categories2.add("4");
        categories2.add("5");
        categories2.add("6");


        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories2);


        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);




        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        getLeaves();
    }

    public void DateFrom(View v) {

        Calendar mcurrentDate = Calendar.getInstance();
        year = mcurrentDate.get(Calendar.YEAR);
        month = mcurrentDate.get(Calendar.MONTH);
        day = mcurrentDate.get(Calendar.DAY_OF_MONTH);

        final DatePickerDialog mDatePicker = new DatePickerDialog(ApplyLeave.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                date.setText(new StringBuilder().append(selectedday).append("/").append(selectedmonth + 1).append("/").append(selectedyear));
                int month_k = selectedmonth + 1;

            }
        }, year, month, day);
        mDatePicker.setTitle("Please select date");
        // TODO Hide Future Date Here
        // mDatePicker.getDatePicker().setMaxDate(System.currentTimeMillis());

        // TODO Hide Past Date Here
        mDatePicker.getDatePicker().setMinDate(System.currentTimeMillis());
        mDatePicker.show();

    }

    public void DateTo(View v) {

        Calendar mcurrentDate = Calendar.getInstance();
        year1 = mcurrentDate.get(Calendar.YEAR);
        month1 = mcurrentDate.get(Calendar.MONTH);
        day1 = mcurrentDate.get(Calendar.DAY_OF_MONTH);

        final DatePickerDialog mDatePicker = new DatePickerDialog(ApplyLeave.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                date1.setText(new StringBuilder().append(selectedday).append("/").append(selectedmonth + 1).append("/").append(selectedyear));
                int month_k = selectedmonth + 1;

                get_days();


            }
        }, year1, month1, day1);
        mDatePicker.setTitle("Please select date");
        // TODO Hide Future Date Here
        // mDatePicker.getDatePicker().setMaxDate(System.currentTimeMillis());

        // TODO Hide Past Date Here
        mDatePicker.getDatePicker().setMinDate(System.currentTimeMillis());
        mDatePicker.show();

    }

/*    public void scroll_to_bottom(View view) {

        new CountDownTimer(2000, 20) {

            public void onTick(long millisUntilFinished) {

                scroll.scrollTo((0), (int) (4000 - millisUntilFinished));
            }

            public void onFinish() {
            }

        }.start();

}*/


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {



    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {


    }

    public void Leave_apply(final View v) {


        String TypeLea = spinner.getSelectedItem().toString();

        if(TypeLea.equals("Academic"))
        {
            if(Integer.parseInt(num_days) > acad_left)
            {
                Toast.makeText(ApplyLeave.this, "Leaves already used", Toast.LENGTH_LONG).show();
                return;
            }
        }
        if(TypeLea.equals("Casual"))
        {
            if(Integer.parseInt(num_days) > casual_left)
            {
                Toast.makeText(ApplyLeave.this, "Leaves already used", Toast.LENGTH_LONG).show();
                return;
            }
        }
        if(TypeLea.equals("Medical"))
        {
            if(Integer.parseInt(num_days) > medical_left)
            {
                Toast.makeText(ApplyLeave.this, "Leaves already used", Toast.LENGTH_LONG).show();
                return;
            }

        }

        if (TypeLea.equals("Select Type of Leave")) {
            Toast.makeText(ApplyLeave.this, "Please select type...", Toast.LENGTH_LONG).show();
            return;
        }



        String datefrom = date.getText().toString();
        if (datefrom.equals("")) {
            Toast.makeText(ApplyLeave.this, "Please select from date", Toast.LENGTH_LONG).show();
            return;
        }

        String dateto = date1.getText().toString();
        if (dateto.equals("")) {
            Toast.makeText(ApplyLeave.this, "Please select ", Toast.LENGTH_LONG).show();
            return;
        }

        if( ! first_half.isChecked() && ! second_half.isChecked())
        {
            Toast.makeText(ApplyLeave.this, "Please check atleast one half ", Toast.LENGTH_LONG).show();
            return;
        }

        String day_half = "";
        if(first_half.isChecked())
        {
            day_half = "first half";
        }

        if(second_half.isChecked())
        {
            day_half = "second half";
        }

        if(first_half.isChecked()  && second_half.isChecked())
        {
            day_half = "full day";
        }

        String reason = reason_edit.getText().toString();

        if(reason.equals(""))
        {
            Toast.makeText(ApplyLeave.this, "Please enter some reason ", Toast.LENGTH_LONG).show();
            return;
        }

        SharedPreferences sp = getSharedPreferences("Emp_info",MODE_PRIVATE);
        String emp_id = sp.getString("eid", "");

        JSONObject job = new JSONObject();

        try {
            job.put("leave_type" , TypeLea);
            job.put("emp_id" , emp_id);
            job.put("DateFrom",datefrom);
            job.put("DateTo",dateto);
            job.put("day_half",day_half);
            job.put("days",num_days);
            job.put("reason",reason);

        } catch (JSONException e) {
            e.printStackTrace();
        }


        System.out.println(job);
        JsonObjectRequest jobreq = new JsonObjectRequest("http://"+Ipaddress.ip+"/applyLeave.php", job, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    if(response.getString("key").equals("done"))
                    {
                        finish();
                        Intent i = new Intent(ApplyLeave.this,Drawer_activity.class);
                        startActivity(i);
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

        jobreq.setRetryPolicy(new DefaultRetryPolicy(20000 , 2 ,2));

        AppController app = new AppController(ApplyLeave.this);

        app.addToRequestQueue(jobreq);

    }

    public void get_days()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date_1 = sdf.parse(date.getText().toString());
            Date date_2 = sdf.parse(date1.getText().toString());

            long diff = date_2.getTime() - date_1.getTime();
            num_days = String.valueOf(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));

            if(Integer.parseInt(num_days) > 1)
            {
                first_half.setChecked(true);
                second_half.setChecked(true);
            }
            days_text.setText("Number of days "+num_days);

            System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
        } catch (ParseException e) {
            e.printStackTrace();
        }


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

                    acad_left = Integer.parseInt(acad);
                    casual_left = Integer.parseInt(cas);
                    medical_left= Integer.parseInt(med);

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

        AppController app = new AppController(ApplyLeave.this);

        app.addToRequestQueue(jobjreq);
    }
}


