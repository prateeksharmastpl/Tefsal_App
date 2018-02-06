package com.tefal.adapter;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.tefal.Models.DishdashaTailorProductRecord;
import com.tefal.Models.GetAssignedItemsRecord;
import com.tefal.Models.GetAssignedItemsResponse;
import com.tefal.R;
import com.tefal.utils.Contents;
import com.tefal.utils.SimpleProgressBar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rituparna Khadka on 1/12/2018.
 */

public class DishdashaTailorProductAdapterForListView  extends BaseAdapter{

    private ArrayList<GetAssignedItemsRecord> assignedItemsRecordArrayList;
    private Activity activity;
    LayoutInflater inflater;
    public DishdashaTailorProductAdapterForListView(Activity activity,ArrayList<GetAssignedItemsRecord> assignedItemsRecordArrayList)
    {
       this.activity=activity;
       this.assignedItemsRecordArrayList=assignedItemsRecordArrayList;
        inflater = LayoutInflater.from(this.activity);
    }
    @Override
    public int getCount() {
        return assignedItemsRecordArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return assignedItemsRecordArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null)
            convertView = inflater.inflate(R.layout.dishdasha_tailor_product_item, parent, false);

       Button add_btn=(Button)convertView.findViewById(R.id.add_btn);
       TextView product_price=(TextView)convertView.findViewById(R.id.product_price) ;
       TextView product_name=(TextView)convertView.findViewById(R.id.product_name);
       View view=(View)convertView.findViewById(R.id.view);



        product_price.setText(assignedItemsRecordArrayList.get(position).getDishdasha_tailor_product_price()+" KWD");
        product_name.setText(assignedItemsRecordArrayList.get(position).getDishdasha_tailor_product_name());

        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                assignTailorHttpCall(assignedItemsRecordArrayList.get(position));
            }
        });


       // product_name.setText(dishdashaTailorProductRecordArrayList.get(position).getDishdasha_tailor_product_price()+"KWD");

        return convertView;
    }

    private void assignTailorHttpCall(final GetAssignedItemsRecord getAssignedItemsRecord)
    {

            SimpleProgressBar.showProgress(activity);
            try {
                final String url = Contents.baseURL + "assignTailor";

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response)
                            {

                                SimpleProgressBar.closeProgress();
                                System.out.println("OUTPUT=====assignTailor Response"+response);

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                SimpleProgressBar.closeProgress();
                            }
                        }) {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<String, String>();
//                  params.put("access_token", session.getToken());
                        params.put("item_id", getAssignedItemsRecord.getTefsal_product_id());
                        params.put("tailor_id", getAssignedItemsRecord.getStore_id());
                        params.put("appUser", "tefsal");
                        params.put("appSecret", "tefsal@123");
                        params.put("appVersion", "1.1");

                        Log.e("Tefsal tailor == ", url + params);

                        return params;
                    }

                };

                stringRequest.setRetryPolicy(new DefaultRetryPolicy(30000,
                        DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
                RequestQueue requestQueue = Volley.newRequestQueue(activity);
                stringRequest.setShouldCache(false);
                requestQueue.add(stringRequest);

            } catch (Exception surError) {
                surError.printStackTrace();
            }

    }
}
