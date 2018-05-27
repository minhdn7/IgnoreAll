package com.mkit.ignoreall.ui.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.messaging.FirebaseMessaging;
import com.mkit.ignoreall.R;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseMessaging.getInstance().subscribeToTopic("IgnoreAll");
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                final Intent mainIntent = new Intent(StartActivity.this, HomeActivity.class);
                StartActivity.this.startActivity(mainIntent);
                StartActivity.this.finish();
            }
        }, 3000);
    }
}
