package com.tefal.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tefal.Models.D_StoreRecord;
import com.tefal.R;
import com.tefal.activity.DishDashaProductActivity;
import com.tefal.activity.OtherStoresActivity;
import com.tefal.activity.ProductListOtherActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by new on 9/26/2017.
 */

public class OtherStoresAdapter extends RecyclerView.Adapter<OtherStoresAdapter.ViewHolder> {

    private Activity activity;
    private List<D_StoreRecord> storeModels = new ArrayList<>();

    String flag ;


    public OtherStoresAdapter(Activity activity, List<D_StoreRecord> storeModels, String flag) {
        this.activity = activity;
        this.storeModels = storeModels;
        this.flag = flag;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.store_list_item, viewGroup, false);
        return new ViewHolder(v);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.img)
        ImageView img;

        @Bind(R.id.ratingbar)
        RatingBar ratingbar;

        @Bind(R.id.title)
        TextView title;

        @Bind(R.id.text_max_delivery_days)
        TextView text_max_delivery_days;


        @Bind(R.id.main_layout)
        RelativeLayout main_layout;

        @Bind(R.id.txt_discount_amount)
        TextView txt_discount_amount;

        @Bind(R.id.txt_discount_off)
        TextView txt_discount_off;




        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position2) {


        String discount_amount;

        if (!storeModels.get(holder.getAdapterPosition()).getStore_image().isEmpty())
            Picasso.with(activity).load(storeModels.get(holder.getAdapterPosition()).getStore_image()).into(holder.img);

        holder.title.setText(storeModels.get(holder.getAdapterPosition()).getStore_name());
        holder.ratingbar.setRating(Float.parseFloat(storeModels.get(holder.getAdapterPosition()).getStore_rating()));
        holder.text_max_delivery_days.setText(storeModels.get(holder.getAdapterPosition()).getMax_delivery_days());
        System.out.println("DALIVERY DATE   MIN"+storeModels.get(position2).getMin_delivery_days());
        System.out.println("DALIVERY DATE   MAX"+storeModels.get(position2).getMax_delivery_days());

        if(storeModels.get(holder.getAdapterPosition()).getStore_discount().equals("") || storeModels.get(holder.getAdapterPosition()).getStore_discount().equals(null) )
        {
            holder.txt_discount_amount.setVisibility(View.GONE);
            holder.txt_discount_off.setVisibility(View.GONE);
        }
        else
        {
            discount_amount=storeModels.get(holder.getAdapterPosition()).getStore_discount();
            holder.txt_discount_amount.setText(discount_amount);
           /* holder.txt_discount_amount.setVisibility(View.VISIBLE);
            holder.txt_discount_off.setVisibility(View.VISIBLE);*/


        }

        holder.main_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    activity.startActivity(new Intent(activity, ProductListOtherActivity.class)
                            .putExtra("store_id", storeModels.get(holder.getAdapterPosition()).getStore_id())
                            .putExtra("flag", flag)
                            .putExtra("sub_cat", OtherStoresActivity.sub_cat_id)
                            .putExtra("store_name",storeModels.get(holder.getAdapterPosition()).getStore_name()));

            }
        });
    }


    @Override
    public int getItemCount() {
        return storeModels.size();
    }

}