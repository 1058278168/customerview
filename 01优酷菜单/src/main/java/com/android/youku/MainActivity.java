package com.android.youku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.android.youku.tools.Tools;

public class MainActivity extends AppCompatActivity {

    private ImageView icon_home;
    private ImageView icon_menu;
    private RelativeLayout level1, level2, level3;

    /**
     * 是否显示最外侧圆环
     */
    private boolean isShowLevel3 = true;

    /**
     * 是否显示中间圆环
     */
    private boolean isShowLevel2 = true;

    /**
     * 是否显示最内侧圆环
     */
    private boolean isShowLevel1 = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        icon_home = (ImageView) findViewById(R.id.icon_home);
        icon_menu = (ImageView) findViewById(R.id.icon_menu);
        level1 = (RelativeLayout) findViewById(R.id.level1);
        level2 = (RelativeLayout) findViewById(R.id.level2);
        level3 = (RelativeLayout) findViewById(R.id.level3);
        icon_home.setOnClickListener(new MyOnclickListener());
        icon_menu.setOnClickListener(new MyOnclickListener());
    }

    class MyOnclickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.icon_home://home
                    if (isShowLevel2) {
                        isShowLevel2 = false;
                        Tools.hideView(level2);
                        if (isShowLevel3) {
                            isShowLevel3 = false;
                            Tools.hideView(level3, 200);
                        }
                    } else {
                        isShowLevel2 = true;
                        Tools.showView(level2);
                    }
                    break;
                case R.id.icon_menu://菜单
                    if (isShowLevel3) {
                        isShowLevel3 = false;
                        Tools.hideView(level3);
                    } else {
                        isShowLevel3 = true;
                        Tools.showView(level3);
                    }
                    break;
                case R.id.level1:

                    break;
                case R.id.level2:

                    break;
                case R.id.level3:

                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == event.KEYCODE_MENU) {
            if (isShowLevel1) {
                isShowLevel1 = false;
                Tools.hideView(level1);
                if (isShowLevel2) {
                    isShowLevel2 = false;
                    Tools.hideView(level2, 200);
                    if (isShowLevel3) {
                        isShowLevel3 = false;
                        Tools.hideView(level3, 400);
                    }
                }
            } else {
                isShowLevel1 = true;
                isShowLevel2 = true;
                Tools.showView(level1);
                Tools.showView(level2, 200);
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
