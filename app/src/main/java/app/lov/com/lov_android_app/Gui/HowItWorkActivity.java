package app.lov.com.lov_android_app.Gui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import app.lov.com.lov_android_app.MainActivity;
import app.lov.com.lov_android_app.R;
import app.lov.com.lov_android_app.Utils.IntroManager;

/**
 * Created by Shehroz on 19-Dec-17.
 */

public class HowItWorkActivity extends Activity {

    ViewPager viewPager;
    private IntroManager introManager;
    private int[] layouts;
    private TextView[] dots;
    private LinearLayout dotslayout;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        introManager = new IntroManager(this);
        if(!introManager.check()){
            introManager.setfirst(false);
            Intent i= new Intent(HowItWorkActivity.this, SplashScreen.class);
            startActivity(i);
            finish();

        }
        else {
            introManager.setfirst(true);
        }
        setContentView(R.layout.how_it_work_parent);
        layouts = new int[]{
                R.layout.how_it_work_a,
                R.layout.how_it_work_b,
                R.layout.how_it_work_c};
        viewPager = (ViewPager)findViewById(R.id.viewpager1);
        dotslayout = (LinearLayout)findViewById(R.id.layoutDots);
        viewPagerAdapter = new ViewPagerAdapter();
        viewPager.setAdapter(viewPagerAdapter);
    }


    private void addBottomDots(int position){


        dots = new TextView[layouts.length];
        int colorActive = getResources().getColor(R.color.colorOrange);
        int colorInactive = getResources().getColor(R.color.colorWhite);
        dotslayout.removeAllViews();
        for (int i=0; i<dots.length; i++)
        {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8262;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorInactive);
            dotslayout.addView(dots[i]);
        }

        if(dots.length>0)
        {
            dots[position].setTextColor(colorActive);
        }

    }

    private int getItem(int i)
    {
        return viewPager.getCurrentItem()+1;
    }
    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener(){

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            addBottomDots(position);
            if(position == layouts.length-1){

            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
    public class ViewPagerAdapter extends PagerAdapter{

        private LayoutInflater layoutInflater;

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            layoutInflater= (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v =  layoutInflater.inflate(layouts[position],container,false);
            container.addView(v);
            return v;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View v = (View)object;
            container.removeView(v);
        }
    }
}
