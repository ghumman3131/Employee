package com.example.dell.employee_details;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by DELL on 5/6/2017.
 */

public class OnLeave_Adapter extends RecyclerView.Adapter<Holder_onLeave> {

    JSONArray jarr;
    Activity a;

    public OnLeave_Adapter (JSONArray jarr, Activity a)
    {
        this.jarr = jarr ;
        this.a = a ;

    }



    @Override
    public Holder_onLeave onCreateViewHolder(ViewGroup parent, int viewType) {


        Holder_onLeave v = new Holder_onLeave(LayoutInflater.from(a).inflate(R.layout.cell_on_leave,  parent , false));
        return v ;
    }

    @Override
    public void onBindViewHolder(Holder_onLeave holder, int position) {

        JSONObject  job = null;
        try {
            job = jarr.getJSONObject(position);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            holder.leave.setText(job.getString("E_Name"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return jarr.length();
    }
}
