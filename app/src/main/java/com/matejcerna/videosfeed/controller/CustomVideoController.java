package com.matejcerna.videosfeed.controller;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import com.matejcerna.videosfeed.R;

public class CustomVideoController extends MediaController {
    public static boolean full = false;

    private ImageButton fullScreenBtn;
    Context mContext;
    Activity activity;
    VideoView mVideoView;

    public CustomVideoController(Context context, Activity activity, VideoView videoView) {
        super(new ContextThemeWrapper(context, R.style.AppTheme));
        this.activity = activity;
        mContext = context;
        mVideoView = videoView;
    }

    @Override
    public void setAnchorView(View view) {
        super.setAnchorView(view);
        FrameLayout.LayoutParams frameParams = new FrameLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        frameParams.gravity = Gravity.RIGHT | Gravity.TOP;
        frameParams.setMargins(12, 14, 10, 12);

        View v = AddFullScreenBtn();
        addView(v, frameParams);
    }

    @Override
    public void hide() {
        super.hide();
    }

    @Override
    public void show(int timeout) {
        super.show(0);
    }

    private View AddFullScreenBtn() {
        fullScreenBtn = new ImageButton(mContext);
        if (full)
            fullScreenBtn.setImageResource(R.drawable.ic_fullscreen_exit);
        else
            fullScreenBtn.setImageResource(R.drawable.ic_fullscreen);
        fullScreenBtn.setBackgroundColor(Color.TRANSPARENT);
        fullScreenBtn.setOnClickListener(new OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            public void onClick(View v) {
                if (full) {
                    activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
                    fullScreenBtn.setImageResource(R.drawable.ic_fullscreen);
                    activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                    full = false;

                    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
                    params.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
                    params.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
                    params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
                    params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
                    mVideoView.setLayoutParams(params);
                } else {
                    activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
                    ((AppCompatActivity) activity).getSupportActionBar().hide();
                    fullScreenBtn.setImageResource(R.drawable.ic_fullscreen_exit);
                    activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                    full = true;

                    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
                    params.removeRule(RelativeLayout.ALIGN_PARENT_LEFT);
                    params.removeRule(RelativeLayout.ALIGN_PARENT_TOP);
                    params.removeRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                    params.removeRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
                    mVideoView.setLayoutParams(params);
                }
            }
        });
        return fullScreenBtn;
    }
}
