package com.sf.loanapp.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sf.loanapp.R;

import org.json.JSONObject;

public class AppDashboardAdapter extends BaseAdapter{

    private Context mContext;
    private JSONObject[] applicationArr;
    public AppDashboardAdapter(Context cxt, JSONObject[] applicationArr){
        this.mContext = cxt;
        this.applicationArr = applicationArr;
    }

    @Override
    public int getCount() {
        return applicationArr.length;
    }

    @Override
    public JSONObject getItem(int position) {
        return applicationArr[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gridView;
        if (convertView == null) {
            gridView = new View(mContext);
            // get layout from grid_item.xml ( Defined Below )
            gridView = inflater.inflate(R.layout.dashboard_grid_item , null);
            try{
                ((TextView)gridView.findViewById(R.id.acc_name)).setText(applicationArr[position].getString("Name"));
            }
            catch (Exception e){
                Log.d("--->Error",e.getMessage());
            }
        }
        else{
            gridView = (View)convertView;
        }
        return gridView;
    }
}
