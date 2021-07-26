package com.ravan.me_nili.slidshow.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.ravan.me_nili.slidshow.R;
import com.ravan.me_nili.slidshow.SlideClickListener;
import com.ravan.me_nili.slidshow.SlideFragment;

/**
 * Created by me_nili on 03/26/2017.
 */

public class SlideAdapter extends FragmentPagerAdapter {

    private SlideClickListener slideClickListener ;

    String[] images = {"http://s9.picofile.com/file/8290512642/5c2e0722_5406_43e8_86a9_57170954d73f.jpg","http://www.uiu.edu.hk/wp-content/uploads/2016/05/PSYCHOLOGY-BANNER.jpg","https://www.psychology.org.au/Assets/Images/17APS-CONF-CCOM-Events-Calendar-Banner-2[2].jpg"};

    public SlideAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        SlideFragment slideFragment = SlideFragment.getInstance(position,images[position]);
        slideFragment.setSlideListener(slideClickListener);
        return slideFragment;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    public SlideClickListener getSlideClickListener() {
        return slideClickListener;
    }

    public void setSlideClickListener(SlideClickListener slideClickListener) {
        this.slideClickListener = slideClickListener;
    }
}
