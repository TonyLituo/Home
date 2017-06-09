package cc.tuo.gank.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import java.io.Serializable;

/**
 * Created by Jinx on 2017/5/26.
 * <p>
 * intent封装  实现activity页面跳转
 */

public class RxLancher {
    /**
     * 要发生跳转的activity
     */
    private Activity activity;
    /**
     * 目标activity
     */
    private Class<?> cla;

    private Intent intent;
    /**
     * 响应码
     */
    private int code = -1;

    /**
     * 主线程handler
     */
    private Handler handler;
    /**
     * 跳转延时
     */
    private static final int DELAY_TIME = 300;

    private RxLancher() {
        handler = new Handler(Looper.getMainLooper());
    }

    public static RxLancher newIntance(Activity activity, Class<?> cla) {
        RxLancher rxLancher = new RxLancher();
        rxLancher.activity = activity;
        rxLancher.cla = cla;
        rxLancher.intent = new Intent(activity, cla);
        return rxLancher;
    }

    /**
     * 请求码
     *
     * @param code
     * @return
     */
    public RxLancher code(int code) {
        this.code = code;
        return this;
    }

    /**
     * 结束当前页面
     *
     * @return
     */
    public RxLancher finish() {
        activity.finish();
        return this;
    }

    /**
     * <p>
     * 执行跳转
     */
    public void start() {
        if (null == activity && null == cla) {
            return;
        }
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (code == -1) {
                    activity.startActivity(intent);

                } else {
                    activity.startActivityForResult(intent, code);
                }
            }
        }, DELAY_TIME);
    }


    /**
     * 添加传递数据   基本数据类型，Serializable对象
     *
     * @param name
     * @param value
     * @return
     */
    public RxLancher put(String name, boolean value) {
        intent.putExtra(name, value);
        return this;
    }

    public RxLancher put(String name, byte value) {
        intent.putExtra(name, value);
        return this;
    }

    public RxLancher put(String name, char value) {
        intent.putExtra(name, value);
        return this;
    }

    public RxLancher put(String name, short value) {
        intent.putExtra(name, value);
        return this;
    }

    public RxLancher put(String name, int value) {
        intent.putExtra(name, value);
        return this;
    }

    public RxLancher put(String name, long value) {
        intent.putExtra(name, value);
        return this;
    }

    public RxLancher put(String name, float value) {
        intent.putExtra(name, value);
        return this;
    }

    public RxLancher put(String name, double value) {
        intent.putExtra(name, value);
        return this;
    }

    public RxLancher put(String name, String value) {
        intent.putExtra(name, value);
        return this;
    }

    public RxLancher put(String name, CharSequence value) {
        intent.putExtra(name, value);
        return this;
    }

    public RxLancher put(String name, Serializable value) {
        intent.putExtra(name, value);
        return this;
    }

    public RxLancher put(String name, Bundle value) {
        intent.putExtra(name, value);
        return this;
    }

}
