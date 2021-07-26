package com.ravan.me_nili.slidshow;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.ravan.me_nili.slidshow.Adapter.SlideAdapter;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import jp.wasabeef.glide.transformations.gpu.ToonFilterTransformation;

public class MainActivity extends AppCompatActivity implements SlideClickListener {



    private ViewPager slideViewPager ;
    private Timer slideTimer ;
    private int cur_position = 1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initui();
        slideTimer = new Timer();
        startTimer();
        imbuttonha();

    }

    private void imbuttonha() {

        ImageView im1 = (ImageView) findViewById(R.id.im1);
        ImageView im2 = (ImageView) findViewById(R.id.im2);
        ImageView im3 = (ImageView) findViewById(R.id.im3);
        ImageView im4 = (ImageView) findViewById(R.id.im4);
        ImageView im5 = (ImageView) findViewById(R.id.im5);
        Button btn1 = (Button)findViewById(R.id.btn1);
        Button btn2 = (Button)findViewById(R.id.btn2);


        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, samp.class);
                startActivity(intent);
            }
        });


        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, samp.class);
                startActivity(intent);
            }
        });



        Glide
                .with(this)
                .load("http://www.jsums.edu/psychology/files/2014/10/Psychology-slide1-960x490-copy.jpg?x61683")
                .bitmapTransform(new RoundedCornersTransformation(this,11,1))
                .into(im1);

        im1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, samp.class);
                startActivity(intent);
            }
        });

        Glide
                .with(this)
                .load("http://www.worcester.ac.uk/content_images/business-psychology-university-worcester-course-page-header.jpg")
                .bitmapTransform(new RoundedCornersTransformation(this,30,1))
                .into(im2);

        im2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, samp.class);
                startActivity(intent);
            }
        });


        Glide
                .with(this)
                .load("http://www.onlinepsychologydegree.info/wp-content/uploads/2014/08/567.jpg")
                .bitmapTransform(new RoundedCornersTransformation(this,60,1))
                .into(im3);

        im3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, samp.class);
                startActivity(intent);
            }
        });

        Glide
                .with(this)
                .load("https://static1.squarespace.com/static/55cd5b4de4b09e646ff20d5c/t/5714bdb345bf21968b760c53/1460977106168/psychology.jpg")
                .bitmapTransform(new RoundedCornersTransformation(this,60,1))
                .into(im4);

        im4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, samp.class);
                startActivity(intent);
            }
        });


        Glide
                .with(this)
                .load("http://upsccivilservices.com/manage/uploads/thumbnails/lecture_thumbnail_662.jpg")
                .bitmapTransform(new RoundedCornersTransformation(this,60,1))
                .into(im5);

        im5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, samp.class);
                startActivity(intent);
            }
        });



    }

    private void startTimer() {
        slideTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        slideViewPager.setCurrentItem(cur_position,true);
                        cur_position++;
                        if(cur_position == 3 ) {
                            cur_position = 0 ;
                        }
                    }
                });

            }
        },3000,3000);
    }



    private void initui() {
        slideViewPager = (ViewPager) findViewById(R.id.vp);
        SlideAdapter slideAdapter = new SlideAdapter(getSupportFragmentManager());
        slideAdapter.setSlideClickListener(this);
        slideViewPager.setAdapter(slideAdapter);



    }

    @Override
    public void onSlideClicked(int position, String imgURL) {
        if(position==0) {
            Intent intent = new Intent(MainActivity.this, samp.class);
            startActivity(intent);
            }
        if(position==1) {
            Intent intent = new Intent(MainActivity.this, samp.class);
            startActivity(intent);
        }
        if(position==2) {
            Intent intent = new Intent(MainActivity.this, samp.class);
            startActivity(intent);
        }


    }
}
