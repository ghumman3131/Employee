
package com.example.dell.employee_details;

        import android.app.Activity;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.ViewGroup;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

/**
 * Created by DELL on 4/26/2017.
 */

public class history_adapter extends RecyclerView.Adapter<history_holder> {


    JSONArray jarr;
    Activity a;

    public history_adapter(JSONArray jarr , Activity a)
    {
        this.jarr = jarr;
        this.a = a;
    }


    @Override
    public history_holder onCreateViewHolder(ViewGroup parent, int viewType) {

        history_holder v = new history_holder(LayoutInflater.from(a).inflate(R.layout.cell_history , parent, false));

        return  v ;
    }

    @Override
    public void onBindViewHolder(history_holder holder, int position) {

        try {
            JSONObject job = jarr.getJSONObject(position);
            holder.emply_id.setText(job.getString("E_id"));
            holder.leave_id.setText(job.getString("Leave_id"));
            holder.l_type.setText(job.getString("L_type"));
            holder.days.setText(job.getString("no_days"));
            holder.from.setText(job.getString("date_from"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
