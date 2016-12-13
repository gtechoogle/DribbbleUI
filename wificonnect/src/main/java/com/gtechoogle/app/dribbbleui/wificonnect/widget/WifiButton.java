package com.gtechoogle.app.dribbbleui.wificonnect.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.gtechoogle.app.dribbbleui.wificonnect.R;

/**
 * Created by MTK54273 on 12/13/2016.
 */

public class WifiButton extends Button {
    private OnClickFinishedListener mListener;

    public WifiButton(Context context) {
        super(context);
    }

    public WifiButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackground(context.getDrawable(R.drawable.round_button));
    }

    @Override
    public boolean performClick() {
        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.wifi_button_effect);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Animation scaleDown = AnimationUtils.loadAnimation(getContext(),
                        R.anim.wifi_button_scale_down);
                startAnimation(scaleDown);
                scaleDown.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        if (mListener != null) {
                            mListener.onFinished();
                        }
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        startAnimation(animation);
        return super.performClick();
    }

    public void setOnClickFinishedListener(OnClickFinishedListener listener) {
        mListener = listener;
    }
    public interface OnClickFinishedListener {
        void onFinished();
    }
}
