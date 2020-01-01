package com.parentiprofumeria.parentiprofumeria;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;


public class IntroSliderActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private LinearLayout layoutDot;
    private TextView[] dotsv;
    private int[] layouts;
    private Button btnSkip, btnNext;
    private MyPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if(!isFirstTimeStartApp()){
            startHomeActivity();
            finish();
        }



        setStatusBarTransparent();
        setContentView(R.layout.activity_intro_slider);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        layoutDot = (LinearLayout) findViewById(R.id.layoutDots);
        btnSkip = (Button) findViewById(R.id.btn_skip);
        btnNext = (Button) findViewById(R.id.btn_next);

        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startHomeActivity();

            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentPage = viewPager.getCurrentItem() + 1;
                if(currentPage < layouts.length){
                    //move to next page
                    viewPager.setCurrentItem(currentPage);
                }
                else{
                    startHomeActivity();
                }

            }
        });

        //layouts of all welcome sliders
                // add few more layouts if you want
                layouts = new int[]{R.layout.welcome_slide1, R.layout.welcome_slide2, R.layout.welcome_slide3, R.layout.welcome_slide4, R.layout.welcome_slider5};
        pagerAdapter = new MyPagerAdapter(layouts, getApplicationContext());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                // changing the next button text 'NEXT' / 'GOT IT'
                if (position == layouts.length - 1) {
                    // last page. make button text to GOT IT
                    btnNext.setText(getString(R.string.start));
                    btnSkip.setVisibility(View.GONE);
                } else {
                    // still pages are left
                    btnNext.setText(getString(R.string.next));
                    btnSkip.setVisibility(View.VISIBLE);
                }
                setDotStatus(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        setDotStatus(0);

    }

    private boolean isFirstTimeStartApp(){
        SharedPreferences ref = getApplicationContext().getSharedPreferences("IntroSlider", Context.MODE_PRIVATE);
        return ref.getBoolean("FirstTimeStartFlag", true);
    }

    private void setFirstTimeStartStatus(boolean stt){
        SharedPreferences ref = getApplicationContext().getSharedPreferences("IntroSlider", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = ref.edit();
        editor.putBoolean("FirstTimeStartFlag", stt);
        editor.commit();
    }

    private void setDotStatus(int page){
        layoutDot.removeAllViews();
        dotsv = new TextView[layouts.length];
        for(int i =0; i < dotsv.length; i++){
            dotsv[i] = new TextView(this);
            dotsv[i].setText(Html.fromHtml("&#8226;"));
            dotsv[i].setTextSize(30);
            dotsv[i].setTextColor(Color.parseColor("#a9b4bb"));
            layoutDot.addView(dotsv[i]);
        }
        //set current dot active
        if(dotsv.length>0){
            dotsv[page].setTextColor(Color.parseColor("#ffffff"));
        }

    }

    private void startHomeActivity(){
        setFirstTimeStartStatus(false);
        startActivity(new Intent(IntroSliderActivity.this, HomeActivity.class));
        finish();
    }

    private void setStatusBarTransparent(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }
}