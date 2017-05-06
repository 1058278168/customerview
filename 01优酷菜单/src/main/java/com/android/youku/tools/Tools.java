package com.android.youku.tools;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;

/**
 * Created by shengli.zhang on 2017/4/11.
 */

public class Tools {

    /**
     * 隐藏view
     *
     * @param view
     */
    public static void hideView(ViewGroup view) {
        hideView(view, 0);
    }

    /**
     * 显示view
     *
     * @param view
     */
    public static void showView(ViewGroup view) {
        showView(view, 0);
    }

    /**
     * 设置动画延迟显示
     *
     * @param view
     * @param offset
     */
    public static void showView(ViewGroup view, int offset) {
//        RotateAnimation ra = new RotateAnimation(180, 360, view.getWidth() / 2, view.getHeight());
//        ra.setDuration(500);//设置动画持续时间
//        ra.setFillAfter(true);//设置动画停留在结束的状态
//        ra.setStartOffset(offset);
//        for (int i = 0; i < view.getChildCount(); i++) {
//            View child = view.getChildAt(i);
//            child.setEnabled(true);
//        }
//        view.startAnimation(ra);

        ObjectAnimator oa = new ObjectAnimator().ofFloat(view, "rotation", 180F
                , 360F);
        view.setPivotX(view.getWidth()/2);
        view.setPivotY(view.getHeight());
        AnimatorSet set = new AnimatorSet();
        set.setDuration(500);
        set.play(oa);
        set.setStartDelay(offset);
        set.start();
    }

    /**
     * 延迟动画的隐藏
     *
     * @param view
     * @param offset
     */
    public static void hideView(ViewGroup view, int offset) {
//        RotateAnimation ra = new RotateAnimation(0, 180, view.getWidth() / 2, view.getHeight());
//        ra.setDuration(500);//设置动画持续时间
//        ra.setFillAfter(true);//设置动画停留在结束的状态
//        ra.setStartOffset(offset);//延迟offset时间后播放动画
//        for (int i = 0; i < view.getChildCount(); i++) {
//            View child = view.getChildAt(i);
//            child.setEnabled(false);
//        }
//        view.startAnimation(ra);
        ObjectAnimator oa = new ObjectAnimator().ofFloat(view, "rotation", 0F
                , 180F);
        view.setPivotX(view.getWidth()/2);
        view.setPivotY(view.getHeight());
        AnimatorSet set = new AnimatorSet();
        set.setDuration(500);
        set.play(oa);
        set.setStartDelay(offset);
        set.start();
    }
}
