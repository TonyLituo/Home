package cc.tuo.gank.base;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cc.tuo.gank.R;

public abstract class BaseActivity extends AppCompatActivity {

    FrameLayout contentView;

    @BindView(R.id.base_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.toolbar_title)
    TextView mTitle;
    @BindView(R.id.error_view)
    FrameLayout mErrorView;

    protected Unbinder mUnbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Logger.d(this.getClass().getSimpleName());

        setContentView(R.layout.base_activity);
//这里不能用butterknife绑定  还未初始化；也不能先初始化Butterknife，不然找不到contentView中的控件

        contentView = (FrameLayout) this.findViewById(R.id.base_contentview);

        contentView.addView(View.inflate(this, getLayoutResID(), null));

        mUnbinder = ButterKnife.bind(this);

        showToolbar();

        initView();

        setSupportActionBar(mToolbar);
        //显示返回键
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //原来的标题隐藏
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mTitle.setText(setToolbarTitle());
        showContentView();

        //透明状态栏内容延伸到状态栏，
        // 去掉默认的toolbar，xml中：android:fitsSystemWindows="false"
        //子类中调用 hideToolbar();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
        mUnbinder = null;
    }

    /**
     * 显示错误页面
     */
    public void showErrorView() {
        mErrorView.setVisibility(View.VISIBLE);
        contentView.setVisibility(View.GONE);
    }

    /**
     * 显示内容页面
     */
    public void showContentView() {
        mErrorView.setVisibility(View.GONE);
        contentView.setVisibility(View.VISIBLE);
    }

    /**
     * 隐藏toolbar
     */
    public void hideToolbar() {
        mToolbar.setVisibility(View.GONE);
    }

    /**
     * 显示toolbar
     */
    public void showToolbar() {
        mToolbar.setVisibility(View.VISIBLE);
    }

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

    /**
     * 布局ID
     */

    @LayoutRes
    @NonNull
    protected abstract int getLayoutResID();

    /**
     * 初始化视图
     */
    protected abstract void initView();

    /**
     * 标题
     *
     * @return
     */
    protected abstract String setToolbarTitle();
}
