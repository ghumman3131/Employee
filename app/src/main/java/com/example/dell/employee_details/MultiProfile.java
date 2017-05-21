package com.example.dell.employee_details;


import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONException;
import org.json.JSONObject;

public class MultiProfile extends AppCompatActivity {
    FragmentManager fm;

    ImageView img;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    Button personal_btn , professional_btn , health_btn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        personal_btn = (Button) findViewById(R.id.personal_btn);
        professional_btn = (Button) findViewById(R.id.professional_btn);
        health_btn = (Button) findViewById(R.id.health_btn);

        img = (ImageView) findViewById(R.id.image);




        fm = getSupportFragmentManager();
        String from = getIntent().getStringExtra("from_key");

        if(from.equals("sanction"))
        {
            get_sanction_image();
            personal_btn.setVisibility(View.GONE);
            professional_btn.setVisibility(View.GONE);
            health_btn.setVisibility(View.GONE);

            FragmentTransaction ft = fm.beginTransaction();
            Fragment cm = new PersonalD();

            Bundle b = new Bundle();
            b.putString("from" , "sanction");

            cm.setArguments(b);

            ft.replace(R.id.frame_id, cm);

            ft.commit();
        }

        if (from.equals("personal")) {
            get_image();
            FragmentTransaction ft = fm.beginTransaction();
            Fragment cm = new PersonalD();

            Bundle b = new Bundle();
            b.putString("from" , "personal");

            cm.setArguments(b);

            ft.replace(R.id.frame_id, cm);

            ft.commit();

        }
        if (from.equals("professional")) {
            get_image();

            FragmentTransaction ft = fm.beginTransaction();
            Fragment cm = new ProfessionalD();

            ft.replace(R.id.frame_id, cm);

            ft.commit();
        }
        if (from.equals("health")) {
            get_image();
            FragmentTransaction ft = fm.beginTransaction();
            Fragment cm = new HealthD();

            ft.replace(R.id.frame_id, cm);

            ft.commit();

        }
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void personal(View v) {

        FragmentTransaction ft = fm.beginTransaction();
        Fragment cm = new PersonalD();

        ft.replace(R.id.frame_id, cm);

        ft.commit();

    }

    public void professional(View v) {

        FragmentTransaction ft = fm.beginTransaction();
        Fragment cm = new ProfessionalD();

        ft.replace(R.id.frame_id, cm);

        ft.commit();

    }

    public void health(View v) {

        FragmentTransaction ft = fm.beginTransaction();
        Fragment cm = new HealthD();

        ft.replace(R.id.frame_id, cm);

        ft.commit();

    }



    public void get_image() {
        JSONObject job = new JSONObject();


        SharedPreferences sp = getSharedPreferences("Emp_info" , MODE_PRIVATE);

        try {
            job.put("eid" , sp.getString("eid" , ""));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jobreq = new JsonObjectRequest("http://" + Ipaddress.ip + "/image.php", job, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {

                    // converting string image to bitmap

                    Bitmap bmp = StringToBitMap(response.getString("image_id"));

                    // setting image bitmap to imageview

                    img.setImageBitmap(bmp);


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)

            {
                System.out.println(error);
            }
        });

        AppController app = new AppController(MultiProfile.this);

        app.addToRequestQueue(jobreq);
    }



    public void get_sanction_image() {
        JSONObject job = new JSONObject();


        SharedPreferences sp = getSharedPreferences("Sanction_info" , MODE_PRIVATE);

        try {
            job.put("sid" , sp.getString("sid" , ""));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jobreq = new JsonObjectRequest("http://" + Ipaddress.ip + "/sanction_image.php", job, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {

                    // converting string image to bitmap

                    Bitmap bmp = StringToBitMap(response.getString("image_id"));

                    // setting image bitmap to imageview

                    img.setImageBitmap(bmp);


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)

            {
                System.out.println(error);
            }
        });

        AppController app = new AppController(MultiProfile.this);

        app.addToRequestQueue(jobreq);
    }


    // function to convert string image into bitmap image
    public Bitmap StringToBitMap(String encodedString) {
        try {
            byte[] encodeByte = Base64.decode(encodedString, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("MultiProfile Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}