package com.zhongsm.cloudlibrary;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zhongsm.common.constant.ARouterMapping;
import com.zhongsm.common.BaseActivity;

@Route(path = ARouterMapping.Home.Home)
public class HomeActivity extends BaseActivity {

    @Override
    public int assertLayoutResID() {
        return R.layout.app_activity_home;
    }

    @Override
    public void doOnCreated() {

    }

    @Override
    public void doOnStart() {

    }

    @Override
    public void doOnResume() {

    }

    @Override
    public void onBackPressed() {
        setResult(321);
        super.onBackPressed();
    }
}