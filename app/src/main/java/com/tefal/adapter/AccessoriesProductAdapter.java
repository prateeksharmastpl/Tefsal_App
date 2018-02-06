package com.tefal.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tefal.Models.AccessoriesRecord;
import com.tefal.Models.ProductRecord;
import com.tefal.R;
import com.tefal.activity.AccessoryProductDetailsActivity;
import com.tefal.activity.ZaaraDaraaActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

import static android.view.View.GONE;


public class AccessoriesProductAdapter extends RecyclerView.Adapter<AccessoriesProductAdapter.ViewHolder>
{
    private Activity activity;
    public static List<AccessoriesRecord> productRecords = new ArrayList<>();
    private Context context;
    String storeId;

    public AccessoriesProductAdapter(Activity activity, List<AccessoriesRecord> productRecords, String storeId) {
        this.activity = activity;
        this.productRecords = productRecords;
        this.storeId = storeId;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.textile_product_card, viewGroup, false);
        ((TextView)v.findViewById(R.id.amount_text)).setVisibility(View.VISIBLE);
        return new ViewHolder(v);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.iv_pattern)
        ImageView iv_pattern;

        @Bind(R.id.name_text)
        TextView name_text;

        @Bind(R.id.prize_text)
        TextView prize_text;

        @Bind(R.id.amount_text)
        TextView amount_text;


        @Bind(R.id.main_layout)
        LinearLayout main_layout;

        @Bind(R.id.text_max_delivery_days)
        TextView text_max_delivery_days;

        @Bind(R.id.txt_discount_off)
        TextView txt_discount_off;

        @Bind(R.id.txt_discount_amount)
        TextView txt_discount_amount;





        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {


        String discount_amount;


      //  String product_image=productRecords.get(position).getAccessory_product_image();
        String brand_name=productRecords.get(position).getBrandName();
        String product_name=productRecords.get(position).getProductName();
        String product_price=productRecords.get(position).getPrice();
        String max_delivery_days=productRecords.get(position).getMax_delivery_days();

        String[] accessory_product_image=productRecords.get(position).getAccessory_product_image();


        if(productRecords.get(position).getProduct_discount().equals("") || productRecords.get(position).getProduct_discount().equals(null))
        {
            holder.txt_discount_off.setVisibility(GONE);
            holder.txt_discount_amount.setVisibility(GONE);
        }
        else
        {
            discount_amount=productRecords.get(position).getProduct_discount();
            holder.txt_discount_amount.setText(discount_amount);
        }
     //   System.out.println("Product Image==="+product_image);

        holder.prize_text.setText(product_name);
        holder.name_text.setText(brand_name);
        holder.amount_text.setText(product_price+" KWD");
        holder.text_max_delivery_days.setText(max_delivery_days);

        if(accessory_product_image.length!=0)
        {
            Picasso.with(activity).load(accessory_product_image[0])
                    .placeholder(R.drawable.no_image_placeholder_grid)
                    .error(R.drawable.no_image_placeholder_grid)
                    .into(holder.iv_pattern);
        }
        else
        {
            holder.iv_pattern.setImageResource(R.drawable.no_image_placeholder_grid);
        }

       // Picasso.with(activity).load(product_image).into(holder.iv_pattern);

        holder.main_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(activity, AccessoryProductDetailsActivity.class);
                Bundle bundle=new Bundle();
                AccessoriesRecord accessoriesRecord=productRecords.get(position);
                bundle.putSerializable("accessoriesRecord",(Serializable)accessoriesRecord);
                intent.putExtras(bundle);
                activity.startActivity(intent);


               // ProductRecord productRecord= productRecords.get(position);

//                    Intent intent =new Intent(activity, ZaaraDaraaActivity.class);
//                    Bundle bundle = new Bundle();
//                    ProductRecord productRecord= productRecords.get(position);
//                    bundle.putSerializable("productRecords", (Serializable)productRecord);
//                    intent.putExtras(bundle);
//                    activity.startActivity(intent);

            }
        });
    }


    @Override
    public int getItemCount() {
        return productRecords.size();
    }

}