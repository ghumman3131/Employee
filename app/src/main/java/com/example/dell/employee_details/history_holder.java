package com.example.dell.employee_details;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by DELL on 4/26/2017.
 */

public class history_holder extends RecyclerView.ViewHolder {


    TextView leave_id , emply_id , l_type , days, from ;

    public TextView getEmp_id()
    {
            return emply_id;
    }

    public history_holder(View itemView) {

        super(itemView);

        leave_id = (TextView) itemView.findViewById(R.id.l_id);

        emply_id = (TextView) itemView.findViewById(R.id.E_id);

        l_type = (TextView) itemView.findViewById(R.id.l_type);

        days = (TextView) itemView.findViewById(R.id.l_days);

        from = (TextView) itemView.findViewById(R.id.l_from);
    }
}
