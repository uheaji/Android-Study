package com.example.tablayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private  MyFragmentPagerAdapter myFragmentPagerAdapter;
    private ViewPager vpContainer;
    private TabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TabLayout은 메뉴xml 이 없음.
        vpContainer = findViewById(R.id.vp_container);
        tabs = findViewById(R.id.tabs);

        myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),1);

        myFragmentPagerAdapter.addFragment(new Frag1());
        myFragmentPagerAdapter.addFragment(new Frag2());
        myFragmentPagerAdapter.addFragment(new Frag3());

        vpContainer.setAdapter(myFragmentPagerAdapter);





    }
}