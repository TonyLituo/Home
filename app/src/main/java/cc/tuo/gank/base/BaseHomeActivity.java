package cc.tuo.gank.base;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

/**
 * Created by Jinx on 2017/6/8.
 * <p>
 * 封装除了通用布局以外的东西;  主页继承；普通页继承Base
 */

public abstract class BaseHomeActivity extends AppCompatActivity{
    /**
     * 设置状态栏透明，内容延伸到状态栏
     */
    protected void setTranslucentStatus() {
        //判断当前SDK版本号，如果是4.4以上，就是支持沉浸式状态栏的
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }
}
