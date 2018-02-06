package com.tefal.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
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
import com.tefal.Models.AddressResponseModel;
import com.tefal.Models.DishdashaStylesResponse;
import com.tefal.R;
import com.tefal.adapter.AddressListAdapter;
import com.tefal.utils.Contents;
import com.tefal.utils.SessionManager;
import com.tefal.utils.SimpleProgressBar;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MyAddressListActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.toolbar_title)
    TextView toolbar_title;

    @Bind(R.id.btn_back)
    ImageButton btn_back;

    @Bind(R.id.btn_ADD)
    ImageButton btn_ADD;

    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;


    private SessionManager mSessionManger;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_address_list);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        toolbar_title.setText("MY ADDRESS");
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mSessionManger=new SessionManager(this);

        System.out.println("CUSTOMER=="+mSessionManger.getCustomerId());
        System.out.println("CUSTOMER=="+mSessionManger.getToken());

        btn_ADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyAddressListActivity.this, AddressesActivity.class));
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        httpGetMyAddressCall();

    }

    private void httpGetMyAddressCall()
    {
        SimpleProgressBar.showProgress(MyAddressListActivity.this);
        try {
            final String url = Contents.baseURL + "getCustomerSavedAddresses";

            StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            SimpleProgressBar.closeProgress();

                            if(response!=null)
                            {
                                Gson g = new Gson();
                                AddressResponseModel addressResponseModel=g.fromJson(response,AddressResponseModel.class);

                                if(!addressResponseModel.getStatus().equals("0"))
                                {
                                    LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                                    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

                                    recyclerView.setLayoutManager(layoutManager);
                                    recyclerView.setItemAnimator(new DefaultItemAnimator());

                                    //Adapter requere---
                                    AddressListAdapter addressListAdapter=new AddressListAdapter(MyAddressListActivity.this,addressResponseModel.getRecord());
                                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                                    recyclerView.setLayoutManager(mLayoutManager);
                                    recyclerView.setAdapter(addressListAdapter);
                                }
                                else
                                {
                                     Toast.makeText(getApplicationContext(),addressResponseModel.getMessage(),Toast.LENGTH_SHORT).show();
                                }

                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            System.out.println("Error=="+error.toString());
                            SimpleProgressBar.closeProgress();
                        }
                    }) {
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("customer_id", mSessionManger.getCustomerId());
                    params.put("access_token", mSessionManger.getToken());
                    params.put("appUser","tefsal");
                    params.put("appSecret", "tefsal@123");
                    params.put("appVersion", "1.1");

                    Log.e("Tefsal tailor == ", url + params);

                    return params;
                }

            };

            stringRequest.setRetryPolicy(new DefaultRetryPolicy(30000,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            stringRequest.setShouldCache(false);
            requestQueue.add(stringRequest);

        } catch (Exception surError) {
            System.out.println("Error=="+surError.toString());
            surError.printStackTrace();

        }
    }
}

