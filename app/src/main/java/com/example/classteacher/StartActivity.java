package com.example.classteacher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;
//import android.support.annotation.RequiresApi;
//import android.support.v4.content.ContextCompat;
//import android.support.v4.view.ViewCompat;
//import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import org.jetbrains.annotations.NotNull;


public class StartActivity extends AppCompatActivity {
    private Handler handler = new Handler();
    private LottieAnimationView mAnimationView;
    ImageView logo,backImg;
    TextView text;
    //登录动画
    Animation anim;

    private ViewPager viewPager;
    private ScreenSlidePagerAdapter pagerAdapter;
    private static final int NUM_PAGES=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_start);

        logo = findViewById(R.id.logo);
        backImg = findViewById(R.id.Img);
        mAnimationView = findViewById(R.id.lottie);
        text=findViewById(R.id.textT);


        backImg.animate().translationY(-2600).setDuration(1000).setStartDelay(2500);
        logo.animate().translationY(2200).setDuration(1000).setStartDelay(2500);
        text.animate().translationY(2000).setDuration(1000).setStartDelay(2500);
        mAnimationView.animate().translationY(2000).setDuration(1000).setStartDelay(2500);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //页面动画
                viewPager = findViewById(R.id.pager);
                pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
                viewPager.setAdapter(pagerAdapter);
            }
        }, 3500);

        //登录
        //anim = AnimationUtils.loadAnimation(this,R.anim.o_n_anim);
        //viewPager.setAdapter(pagerAdapter);


/*
        Thread myThread = new Thread() {//创建子线程
            @Override
            public void run() {
                try {

                    sleep(2000);//使程序休眠2秒
                    /*
                    //动画
                    backImg.animate().translationY(-2600).setDuration(900);
                    logo.animate().translationY(2400).setDuration(900);
                    mAnimationView.animate().translationY(2000).setDuration(900);

                    sleep(1510);//使程序休眠2秒


                    viewPager.setAdapter(pagerAdapter);

                    Intent it = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(it);
                    finish();//关闭当前活动
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        myThread.start();
        */
    }

    //页面适配器
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {

        public ScreenSlidePagerAdapter(@NotNull FragmentManager fm) {
            super(fm);
        }

        @NotNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                OnBoardingFragment1 tab1 = new OnBoardingFragment1();
                return tab1;
                case 1:
                    OnBoardingFragment2 tab2 = new OnBoardingFragment2();
                    return tab2;
                case 2:
                    OnBoardingFragment3 tab3 = new OnBoardingFragment3();
                    return tab3;
            }
            return null;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }

}


