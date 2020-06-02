package com.example.testapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.viewPagerTest).setOnClickListener(this);
        findViewById(R.id.listitemTest).setOnClickListener(this);
        findViewById(R.id.animationTest).setOnClickListener(this);
        findViewById(R.id.lodaingTest).setOnClickListener(this);
        findViewById(R.id.editTest).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()){
            case R.id.viewPagerTest:
                intent.setClass(MainActivity.this, ViewPagerActivity.class);
                break;
            case R.id.listitemTest:
                intent.setClass(MainActivity.this, ListItemActivity.class);
                break;
            case R.id.animationTest:
                intent.setClass(MainActivity.this, AnimationActivity.class);
                break;
            case R.id.lodaingTest:
                intent.setClass(MainActivity.this, LodaingActivity.class);
                break;
            case R.id.editTest:
                intent.setClass(MainActivity.this, EditActivity.class);
                break;
        }
        startActivity(intent);
        finish();
    }
}
