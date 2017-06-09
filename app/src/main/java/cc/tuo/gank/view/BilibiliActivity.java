package cc.tuo.gank.view;

import android.os.Bundle;
import android.support.annotation.Nullable;

import cc.tuo.gank.R;
import cc.tuo.gank.base.BaseHomeActivity;

public class BilibiliActivity extends BaseHomeActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTranslucentStatus();
        setContentView(R.layout.activity_bilibili);
    }
}
