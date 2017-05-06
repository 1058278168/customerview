package com.android.propertyanimation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /**
     * 补间动画移动的是画面，效果看起来是移动了但是属性并没有移动，所以点击图片的时候还是点击原来的地方才会有效果；
     * 属性动画移动的不只是效果，连同属性一块移动，图片最后移动到的位置就是其属性的最后位置
     */
    ImageView iv_animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv_animation = (ImageView) findViewById(R.id.iv_animation);
        iv_animation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "点击了图片", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 播放补间动画
     */
    public void testTweenAnimation(View v) {
        TranslateAnimation ta = new TranslateAnimation(0, iv_animation.getWidth(), 0,
                iv_animation.getHeight());
        ta.setDuration(1000);
        ta.setFillAfter(true);
        iv_animation.startAnimation(ta);
    }

    /**
     * 播放属性动画
     */
    public void testPropertyAnimation(View v) {
        //第一种实现
//        ObjectAnimator oaWidth = new ObjectAnimator().ofFloat(iv_animation, "translationX", 0,
//                30);
//        ObjectAnimator oaRo = new ObjectAnimator().ofFloat(iv_animation, "rotation", 0, 90);
//        ObjectAnimator oaHeight = new ObjectAnimator().ofFloat(iv_animation, "translationY", 0,
//                30);
//        AnimatorSet set = new AnimatorSet();
//        set.setDuration(1000);
//        set.playTogether(oaWidth, oaRo, oaHeight);
//        set.start();

        //第二种实现
        iv_animation.animate().rotationXBy(iv_animation.getWidth()).rotationYBy(iv_animation
                .getHeight()).setDuration(2000).setInterpolator(new BounceInterpolator()).start();
    }

    /**
     * 重置补间动画
     */
    public void reset(View v) {
        iv_animation.clearAnimation();
    }
}
