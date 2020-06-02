package com.example.testapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

public class ViewPagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        findViewById(R.id.bt_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(ViewPagerActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        setViews();

    }

    private void setViews() {
        FragmentManager manager = getSupportFragmentManager();
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        ExampleFragmentPagerAdapter adapter = new ExampleFragmentPagerAdapter(manager);
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }
}
