package com.example.dell.employee_details;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by DELL on 5/6/2017.
 */

public class Holder_onLeave extends RecyclerView.ViewHolder {

    TextView leave;

    public Holder_onLeave(View itemView) {


        super(itemView);

            leave = (TextView) itemView.findViewById(R.id.leave_on);
    }


}
