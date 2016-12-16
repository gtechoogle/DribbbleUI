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
import com.skyfishjy.library.RippleBackground;

public class MainActivity extends Activity {
    private WifiButton mWifiButton;
    private ImageView mLoading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWifiButton = (WifiButton) findViewById(R.id.wifi_bt);
        mLoading = (ImageView) findViewById(R.id.searching);
        mWifiButton.setOnClickFinishedListener(new WifiButton.OnClickFinishedListener() {
            @Override
            public void onFinished() {
                handleFinishClick();
            }
        });
    }
    public void handleFinishClick() {
        mWifiButton.setVisibility(View.GONE);
        Animation animUp = AnimationUtils.loadAnimation(this,
                R.anim.searching_scale_up);
        mLoading.setAnimation(animUp);
        animUp.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                mLoading.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                final RippleBackground rippleBackground=(RippleBackground)findViewById(R.id.content);
                rippleBackground.startRippleAnimation();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}