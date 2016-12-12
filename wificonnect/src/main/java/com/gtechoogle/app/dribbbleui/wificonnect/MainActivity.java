package com.gtechoogle.app.dribbbleui.wificonnect;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {
    private Button mWifiButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWifiButton = (Button) findViewById(R.id.wifi_bt);
        mWifiButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.wifi_bt) {
            final Animation scale= AnimationUtils.loadAnimation(this, R.anim.wifi_button_scale);
            view.startAnimation(scale);
        }
    }
}