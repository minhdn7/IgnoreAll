package com.mkit.ignoreall.ui.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.messaging.FirebaseMessaging;
import com.mkit.ignoreall.R;
import com.mkit.ignoreall.app.utils.ConfigNotification;

import org.json.JSONException;
import org.json.JSONObject;

public class StartActivity extends AppCompatActivity {
    String jsonData = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseMessaging.getInstance().subscribeToTopic("IgnoreAll");
        FirebaseMessaging.getInstance().subscribeToTopic("BookApp");
        FirebaseMessaging.getInstance().subscribeToTopic("Test");
        setContentView(R.layout.activity_main);
        handleNotification();
        try {
            if(jsonData != null && !jsonData.equals("")){
                JSONObject json = new JSONObject(jsonData);
                if(json.getString("type").equals("share") && !json.getString("url").trim().equals("")){
                    finish();
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(json.getString("url").trim())));
                    return;
                }else {

                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                final Intent mainIntent = new Intent(StartActivity.this, HomeActivity.class);
                StartActivity.this.startActivity(mainIntent);
                StartActivity.this.finish();
            }
        }, 3000);
    }

    private void handleNotification() {
        try {
            jsonData = getIntent().getStringExtra(ConfigNotification.NOTIFICATION_DATA);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
