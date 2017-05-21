package com.example.dell.employee_details;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by DELL on 4/26/2017.
 */

public class leave_view_holder extends RecyclerView.ViewHolder {


    TextView emp_id , from_txt, to_txt ,  leave_type , full , days , reason ;

    Button approve_btn , cancel_button ;



    public leave_view_holder(View itemView) {

        super(itemView);

        emp_id = (TextView) itemView.findViewById(R.id.employee_id);

        from_txt = (TextView) itemView.findViewById(R.id.from_id);

        approve_btn = (Button) itemView.findViewById(R.id.approve_btn);

        to_txt = (TextView) itemView.findViewById(R.id.to_id);

        cancel_button = (Button) itemView.findViewById(R.id.cancel_btn);

        leave_type = (TextView) itemView.findViewById(R.id.app_type);

        full = (TextView) itemView.findViewById(R.id.app_full);

        days = (TextView) itemView.findViewById(R.id.app_days);

        reason = (TextView) itemView.findViewById(R.id.app_reason);
    }
}
