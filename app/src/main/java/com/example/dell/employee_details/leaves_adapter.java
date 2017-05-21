package com.example.dell.employee_details;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by DELL on 4/26/2017.
 */

public class leaves_adapter extends RecyclerView.Adapter<leave_view_holder> {


    JSONArray jarr;
    Activity a;

    public leaves_adapter(JSONArray jarr , Activity a)
    {
        this.jarr = jarr;
        this.a = a;
    }


    @Override
    public leave_view_holder onCreateViewHolder(ViewGroup parent, int viewType) {

        leave_view_holder v = new leave_view_holder(LayoutInflater.from(a).inflate(R.layout.cell , parent, false));

        return  v ;
    }

    @Override
    public void onBindViewHolder(leave_view_holder holder, int position) {

        try {
            final  JSONObject job = jarr.getJSONObject(position);
            holder.emp_id.setText(job.getString("E_id"));
            holder.from_txt.setText(job.getString("date_from"));
            holder.to_txt.setText(job.getString("date_to"));
            holder.leave_type.setText(job.getString("l_type"));
            holder.full.setText(job.getString("day_half"));
            holder.days.setText(job.getString("no_days"));
            holder.reason.setText(job.getString("reason"));

            holder.approve_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    try {

                        Applied_Leaves.update_status(job.getString("leave_id") , a);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
            holder.cancel_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    try {

                        Applied_Leaves.cancel_status(job.getString("leave_id") , a);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount()
    {
        return jarr.length();
    }
}
