package com.example.testapplication;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

import static com.example.testapplication.NetworkUtils.buildUrl;
import static com.example.testapplication.NetworkUtils.getResponseFromHttpUrl;

public class TestTask extends AsyncTask<Map<String, String>, Void, String> {

    private Listener listener;
    private String mParams;

    // 非同期処理
    @Override
    protected String doInBackground(Map<String, String>... params) {

        Map<String, String> map = params[0];
        String file = map.get(mParams);
        String data = map.get(mParams);
        String deviceId = map.get(mParams);
        Log.d("***file***", file);
        URL searchUrl = buildUrl(file);
        String githubSearchResults = null;
        try {
            githubSearchResults = getResponseFromHttpUrl(searchUrl,data,deviceId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return githubSearchResults;
    }

    // 非同期処理が終了後、結果をメインスレッドに返す
    @Override
    protected void onPostExecute(String result) {
        if (listener != null) {
            listener.onSuccess(result);
        }
    }


    void setListener(Listener listener) {
        this.listener = listener;
    }

    //必要に応じて、パラメータを追加
    void setParams(String params) {
        this.mParams = params;
    }

    interface Listener {
        void onSuccess(String count);
    }
}