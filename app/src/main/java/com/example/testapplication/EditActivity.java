package com.example.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class EditActivity extends AppCompatActivity {

    EditText edittext1,edittext2;
    LinearLayout linearlayout;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        findViewById(R.id.bt_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(EditActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        linearlayout = findViewById(R.id.linearlayout);
        edittext1 = findViewById(R.id.edittext1);
        edittext2 = findViewById(R.id.edittext2);
        linearlayout.setOnTouchListener(touchListener);
        edittext1.setOnTouchListener(touchListener);
        edittext2.setOnTouchListener(touchListener);
    }

    View.OnTouchListener touchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (view.getId()){
                case R.id.edittext1:
                    edittext1.setBackgroundResource(R.drawable.ic_shape_blue);
                    edittext2.setBackgroundResource(R.drawable.ic_shape);
                    break;
                case R.id.edittext2:
                    edittext1.setBackgroundResource(R.drawable.ic_shape);
                    edittext2.setBackgroundResource(R.drawable.ic_shape_blue);
                    break;
                case R.id.linearlayout:
                    edittext1.setBackgroundResource(R.drawable.ic_shape);
                    edittext2.setBackgroundResource(R.drawable.ic_shape);
                    break;
            }
            return false;
        }
    };
}
