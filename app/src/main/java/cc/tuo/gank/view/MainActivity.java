package cc.tuo.gank.view;

import android.support.annotation.NonNull;
import android.view.View;

import butterknife.OnClick;
import cc.tuo.gank.R;
import cc.tuo.gank.base.BaseActivity;
import cc.tuo.gank.utils.RxLancher;

public class MainActivity extends BaseActivity {


    @NonNull
    @Override
    protected int getLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected String setToolbarTitle() {
        return "小姐姐的主页";
    }


    @OnClick({R.id.btn1, R.id.btn2, R.id.btn3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                showErrorView();
                break;
            case R.id.btn2:
                RxLancher.newIntance(this, BilibiliActivity.class).start();
                break;
            case R.id.btn3:
                RxLancher.newIntance(this, FirstActivity.class).start();
                break;
        }
    }
}
