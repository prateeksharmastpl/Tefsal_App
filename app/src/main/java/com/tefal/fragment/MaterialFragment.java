package com.tefal.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tefal.R;
import com.tefal.activity.TextileDetailActivity;
import com.tefal.adapter.DishdashaTextileProductAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class MaterialFragment extends Fragment {

@Bind(R.id.tv_material)
    TextView tv_material;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_material, container, false);
        ButterKnife.bind(this, v);
        tv_material.setText(DishdashaTextileProductAdapter.textileModels.get(TextileDetailActivity.position).getMaterial());

        return v;
    }

}
