package com.gtechoogle.app.dribbbleui.wificonnect;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.gtechoogle.app.dribbbleui.wificonnect.widget.WifiButton;

public class MainActivity extends Activity {
    private WifiButton mWifiButton;
    private ImageView mLoading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWifiButton = (WifiButton) findViewById(R.id.wifi_bt);
        mWifiButton.setOnClickFinishedListener(new WifiButton.OnClickFinishedListener() {
            @Override
            public void onFinished() {
                handleFinishClick();
            }
        });
        mLoading = (ImageView) findViewById(R.id.searching);
    }
    public void handleFinishClick() {
        mWifiButton.setVisibility(View.GONE);

        Animation animUp = AnimationUtils.loadAnimation(this,
                R.anim.searching_scale_up);
        animUp.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                mLoading.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mLoading.setAnimation(animUp);
    }


}