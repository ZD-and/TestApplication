package com.example.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ListItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);
        findViewById(R.id.bt_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TestTask tt = new TestTask();
                tt.setParams("");//渡してほしいのパラメータ
                tt.setListener(new TestTask.Listener() {
                    @Override
                    public void onSuccess(String count) {
                        //通信結果を戻り時の処理
                    }
                });
            }
        });
    }


}
