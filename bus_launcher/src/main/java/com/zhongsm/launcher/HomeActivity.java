package com.zhongsm.launcher;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zhongsm.common.constant.ARouterMapping;
import com.zhongsm.common.BaseActivity;

@Route(path = ARouterMapping.Home.Home)
public class HomeActivity extends BaseActivity {

    @Override
    public int assertLayoutResID() {
        return R.layout.launcher_activity_home;
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
}