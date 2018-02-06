package com.tefal.adapter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;
import com.tefal.Models.D_StoreRecord;
import com.tefal.Models.DishdashaStylesRecord;
import com.tefal.R;
import com.tefal.activity.DishDashaProductActivity;
import com.tefal.activity.MeasermentActivity;
import com.tefal.activity.TabbarActivity;
import com.tefal.app.TefalApp;
import com.tefal.utils.Contents;
import com.tefal.utils.SessionManager;
import com.tefal.utils.SimpleProgressBar;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by new on 9/26/2017.
 */

public class DishdashaAdapter extends RecyclerView.Adapter<DishdashaAdapter.ViewHolder> {

    private Activity activity;
    private List<DishdashaStylesRecord> record = new ArrayList<>();
    private SessionManager session;
    private String mCategory;
    private TefalApp mTefalApp;

    public DishdashaAdapter(Activity activity, List<DishdashaStylesRecord> record, String category) {
        this.activity = activity;
        this.record = record;
        session=new SessionManager(activity);
        mCategory=category;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dishdasha_style_list_item, viewGroup, false);
        return new ViewHolder(v);
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        @Bind(R.id.text_style_name)
        TextView text_style_name;

        @Bind(R.id.txt_neck_value)
        TextView txt_neck_value;

        @Bind(R.id.txt_chest_value)
        TextView txt_chest_value;

        @Bind(R.id.txt_shoulder_value)
        TextView txt_shoulder_value;

        @Bind(R.id.txt_waist_value)
        TextView txt_waist_value;

        @Bind(R.id.txt_arm_value)
        TextView txt_arm_value;

        @Bind(R.id.txt_wrist_value)
        TextView txt_wrist_value;

        @Bind(R.id.txt_front_height_value)
        TextView txt_front_height_value;

        @Bind(R.id.txt_back_height_value)
        TextView txt_back_height_value;

        @Bind(R.id.btn_delete)
        Button btn_delete;

        @Bind(R.id.btn_edit)
        Button btn_edit;

        @Bind(R.id.txtBadge_collar_btn)
        TextView txtBadge_collar_btn;

        @Bind(R.id.txt_badge_coat)
        TextView txt_badge_coat;

        @Bind(R.id.ic_coatCollar)
        ImageView ic_coatCollar;

        @Bind(R.id.ic_coat_button)
        ImageView ic_coat_button;

        @Bind(R.id.ic_cuflink)
        ImageView ic_cuflink;

        @Bind(R.id.txt_wide_value)
        TextView txt_wide_value;

        @Bind(R.id.txt_narrow_value)
        TextView txt_narrow_value;

        @Bind(R.id.pen_pocket)
        ImageView pen_pocket;

        @Bind(R.id.mobile_pocket)
        ImageView mobile_pocket;

        @Bind(R.id.key_pocket)
        ImageView key_pocket;



        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);



        }


    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        if (record.size() > 0) {


            holder.text_style_name.setText(record.get(position).getName());
            holder.txt_neck_value.setText(record.get(position).getNeck() + "cm");
            holder.txt_chest_value.setText(record.get(position).getChest() + "cm");
            holder.txt_shoulder_value.setText(record.get(position).getShoulder() + "cm");
            holder.txt_waist_value.setText(record.get(position).getWaist() + "cm");
            holder.txt_arm_value.setText(record.get(position).getArm() + "cm");
            holder.txt_wrist_value.setText(record.get(position).getWrist() + "cm");
            holder.txt_front_height_value.setText(record.get(position).getFront_height() + "cm");
            holder.txt_back_height_value.setText(record.get(position).getBack_height() + "cm");
            holder.txtBadge_collar_btn.setText(record.get(position).getButtons());
            holder.txt_badge_coat.setText(record.get(position).getButtons());
            holder.txt_wide_value.setText(record.get(position).getWide() + "m");
            holder.txt_narrow_value.setText(record.get(position).getNarrow() + "m");

            //if(record.get(position).getCollar_buttons().equals("0"))
           // {
                //holder.ic_coat_button.setVisibility(View.INVISIBLE);
           // }
            //else
           // {
                holder.txt_badge_coat.setText(record.get(position).getCollar_buttons());
           // }

            //if(record.get(position).getButtons().equals("0"))
            //{
                //holder.ic_coatCollar.setVisibility(View.INVISIBLE);
           // }
          //  else
          //  {
                holder.txtBadge_collar_btn.setText(record.get(position).getButtons());
           // }

           /* holder.txt_badge_coat.setText(record.get(position).getCollar_buttons());
            holder.txtBadge_collar_btn.setText(record.get(position).getButtons());*/

           //System.out.println("CUFFLINK==="+record.get(position).getCufflink().equals("yes"));
            if(record.get(position).getCufflink().equals("yes"))
            {
                holder.ic_cuflink.setVisibility(View.VISIBLE);

            }
            else
            {

            }


            if(record.get(position).getPen_pocket().equals("no"))
            {
               // holder.pen_pocket.setVisibility(View.INVISIBLE);
                holder.pen_pocket.setColorFilter(R.color.colorDGray);
            }
            else
            {
            }

            if(record.get(position).getMobile_pocket().equals("no"))
            {
                holder.mobile_pocket.setColorFilter(R.color.colorDGray);
                //holder.mobile_pocket.setVisibility(View.INVISIBLE);
            }
            else
            {

            }

            /*if(record.get(position).getKey_pocket().equals("no"))
            {
                holder.key_pocket.setColorFilter(R.color.colorDGray);
            }
            else
            {
                //
            }*/



            holder.btn_edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    wrapStyleData(position,"edit");
                    //System.out.println("Edit button click=="+record.get(position).getId());
                }
            });

            holder.btn_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    showNamePrompt(position);
                    //WebCallServiceDeletStyle(position);
                   // wrapStyleData(position,"delete");
                    //System.out.println("Delete button click=="+record.get(position).getId());

                }
            });
        }

    }


    @Override
    public int getItemCount() {
        return record.size();
    }

    public void WebCallServiceDeletStyle(final int position)
    {
        SimpleProgressBar.showProgress(activity);
        try {
            final String url = Contents.baseURL +"deleteMyStyle";

            StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {


                            System.out.println("Delete response=="+response.toString());

                            session.setStyleStatus("true");
                            SimpleProgressBar.closeProgress();

                            if (response != null)
                            {
                                session.clearSizes();
                                Log.e("stores response", response);
                                try
                                {
                                    JSONObject object = new JSONObject(response);
                                    Toast.makeText(activity, object.getString("message"), Toast.LENGTH_LONG).show();
                                    activity.startActivity(new Intent(activity, TabbarActivity.class));
                                    activity.finish();

                                } catch (JSONException e) {
                                    e.printStackTrace();
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

                   /* System.out.println("============================");
                    System.out.println("access_token=="+session.getToken());
                    System.out.println("user_id=="+session.getCustomerId());
                    System.out.println("appUser=="+ "tefsal");
                    System.out.println("appSecret=="+ "tefsal@123");
                    System.out.println("appVersion=="+ "1.1");
                    System.out.println("id=="+record.get(position).getId());*/


                    Map<String, String> params = new HashMap<String, String>();
                   // params.put("access_token", session.getToken());
                    params.put("user_id", session.getCustomerId());
                    params.put("appUser", "tefsal");
                    params.put("appSecret", "tefsal@123");
                    params.put("appVersion", "1.1");
                    params.put("id",record.get(position).getId());

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

    public void showNamePrompt(final int pos) {
        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(activity);
        LayoutInflater LayoutInflater = activity.getLayoutInflater();
        final View dialogView = LayoutInflater.inflate(R.layout.style_prompt_delete_dailog, null);

        Button dialog_ok_btn=(Button)dialogView .findViewById(R.id.dialog_ok_btn);
        Button dialog_cancel_btn=(Button)dialogView .findViewById(R.id.dialog_cancel_btn);

        /*input_layout_style_name=(TextInputLayout)dialogView.findViewById(R.id.input_layout_style_name);
        input_style_name=(EditText)dialogView.findViewById(R.id.input_style_name);
        dialog_ok_btn=(Button)dialogView.findViewById(R.id.dialog_ok_btn);
        dialog_cancel_btn=(Button)dialogView.findViewById(R.id.dialog_cancel_btn);*/
        // ButterKnife.bind(this, dialogView);

        dialogBuilder.setView(dialogView);

        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog_ok_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                //System.out.println("OK");
                alertDialog.dismiss();
                WebCallServiceDeletStyle(pos);

            }
        });
        dialog_cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

    }

    public void wrapStyleData(int position, String action)
    {

        Bundle bundle=new Bundle();
        DishdashaStylesRecord  mDishdashaStylesRecord=new DishdashaStylesRecord();


        mDishdashaStylesRecord.setNeck(record.get(position).getNeck().toString());
        mDishdashaStylesRecord.setChest(record.get(position).getChest().toString());
        mDishdashaStylesRecord.setWrist(record.get(position).getWrist().toString());
        mDishdashaStylesRecord.setWaist(record.get(position).getWaist().toString());
        mDishdashaStylesRecord.setArm(record.get(position).getArm().toString());
        mDishdashaStylesRecord.setFront_height(record.get(position).getFront_height().toString());
        mDishdashaStylesRecord.setBack_height(record.get(position).getBack_height().toString());
        mDishdashaStylesRecord.setShoulder(record.get(position).getShoulder().toString());




        mDishdashaStylesRecord.setButtons(record.get(position).getButtons());
        mDishdashaStylesRecord.setCollar_button_visibility(record.get(position).getCollar_button_visibility());
       // mDishdashaStylesRecord.setCollar_button_visibility(record.get(position).getShirt_button_visibility());
        mDishdashaStylesRecord.setCollar_buttons_push(record.get(position).getCollar_buttons_push());

        mDishdashaStylesRecord.setPen_pocket(record.get(position).getPen_pocket());
        mDishdashaStylesRecord.setMobile_pocket(record.get(position).getMobile_pocket());
        mDishdashaStylesRecord.setKey_pocket(record.get(position).getKey_pocket());
        mDishdashaStylesRecord.setWide(record.get(position).getWide());

        mDishdashaStylesRecord.setCollar_buttons(record.get(position).getCollar_buttons());
       mDishdashaStylesRecord.setShirt_button_visibility(record.get(position).getShirt_button_visibility());
       // mDishdashaStylesRecord.setShirt_button_visibility(record.get(position).getCollar_button_visibility());

        mDishdashaStylesRecord.setCufflink(record.get(position).getCufflink());
        mDishdashaStylesRecord.setId(record.get(position).getId());



        mDishdashaStylesRecord.setCategory(record.get(position).getCategory());
        mDishdashaStylesRecord.setNarrow(record.get(position).getNarrow());
        mDishdashaStylesRecord.setUpdated_at(record.get(position).getUpdated_at());
        mDishdashaStylesRecord.setCreated_at(record.get(position).getCreated_at());
        mDishdashaStylesRecord.setName(record.get(position).getName());
        mDishdashaStylesRecord.setUser_id(session.getCustomerId());



        bundle.putSerializable("STYLE_DATA", mDishdashaStylesRecord);
        mTefalApp=TefalApp.getInstance();
        mTefalApp.setmAction(action);
        mTefalApp.setmCategory(mCategory);

        /*bundle.putString("ACTION",action);
        bundle.putString("CATEGORY","2");*/

        Intent i=new Intent(activity, MeasermentActivity.class);
        i.putExtras(bundle);
        activity.startActivity(i);
    }
}

