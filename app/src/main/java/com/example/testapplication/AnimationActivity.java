package com.example.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

public class AnimationActivity extends AppCompatActivity {
    private TextView txt, txtTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        findViewById(R.id.bt_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(AnimationActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        txt=(TextView) findViewById(R.id.textView1);
        txtTest =(TextView) findViewById(R.id.textView2);
        findViewById(R.id.button1).setOnClickListener(mClick);
        findViewById(R.id.button2).setOnClickListener(mClick);
    }

    View.OnClickListener mClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ScaleAnimation scaleAnimation1 = new ScaleAnimation(
                    1.0f, 1.5f, 1.0f,1.5f,
                    Animation.RELATIVE_TO_SELF,
                    0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            // animation時間 msec
            scaleAnimation1.setDuration(500);
            // 繰り返し回数
            scaleAnimation1.setRepeatCount(0);
            // animationが終わったそのまま表示にする
            scaleAnimation1.setFillAfter(true);

            ScaleAnimation scaleAnimation2 = new ScaleAnimation(
                    1.0f, 1.0f, 1.0f,1.0f,
                    Animation.RELATIVE_TO_SELF,
                    0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            // animation時間 msec
            scaleAnimation2.setDuration(0);
            // 繰り返し回数
            scaleAnimation2.setRepeatCount(0);
            // animationが終わったそのまま表示にする
            scaleAnimation2.setFillAfter(true);

            switch (v.getId()){
                case R.id.button1:
                    txtTest.setTextColor(Color.parseColor("#050505"));
                    txt.setTextColor(Color.parseColor("#ff4444"));
                    txt.startAnimation(scaleAnimation1);
                    txtTest.startAnimation(scaleAnimation2);
                    break;
                case R.id.button2:
                    txt.setTextColor(Color.parseColor("#050505"));
                    txtTest.setTextColor(Color.parseColor("#ff4444"));
                    txtTest.startAnimation(scaleAnimation1);
                    txt.startAnimation(scaleAnimation2);
                    break;

            }
        }
    };
}
