package com.sf.loanapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sf.loanapp.activities.DecoderActivity;
import com.sf.loanapp.R;

public class ApplicationDetailsFragment extends Fragment {

    ImageView aadhaarImageview;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try{
            getActivity().setTitle("Application Details");

        }
        catch(NullPointerException e){
            Log.d("AppDetailsFragment",e.getMessage());
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.app_details_fragment, container, false);
        aadhaarImageview = (ImageView)view.findViewById(R.id.aadar_image);
        aadhaarImageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ApplicationDetailsFragment.this.getActivity(), DecoderActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


}
