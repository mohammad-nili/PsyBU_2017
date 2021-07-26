package com.ravan.me_nili.slidshow;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.transition.Slide;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

/**
 * Created by me_nili on 03/26/2017.
 */

public class SlideFragment extends Fragment implements View.OnClickListener {

    public static final String IMG_KEY = "image";
    public static final String POSITION_KEY = "position";
    private String img_url;
    private int position ;
    private SlideClickListener mListener ;

    public static SlideFragment getInstance(int position , String imgURL) {
        Bundle bundle  = new Bundle();
        bundle.putString(IMG_KEY,imgURL);
        bundle.putInt(POSITION_KEY,position);
        SlideFragment slideFragment = new SlideFragment();
        slideFragment.setArguments(bundle);
        return slideFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.slide_image_layout,container,false);
        ImageView img = (ImageView) view.findViewById(R.id.slide_image);
        img.setOnClickListener(this);
        Bundle bundle = getArguments();
        img_url = bundle.getString(IMG_KEY);
        position = bundle.getInt(POSITION_KEY);
        Glide.with(this).load(img_url).asBitmap().into(img);
        return view ;
    }

    @Override
    public void onClick(View view) {
        if( mListener != null ) {
            mListener.onSlideClicked(position,img_url);
        }
    }

    public SlideClickListener getSlideListener() {
        return mListener;
    }

    public void setSlideListener(SlideClickListener mListener) {
        this.mListener = mListener;
    }
}
