package com.hebin.yys.activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hebin.yys.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class WelcomeFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    @InjectView(R.id.iv_main)
    ImageView ivMain;

    private int mParam1;


    public static WelcomeFragment newInstance(int param1) {
        WelcomeFragment fragment = new WelcomeFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_welcome, container, false);
        ButterKnife.inject(this, view);
        ivMain.setImageResource(mParam1);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
