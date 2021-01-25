package com.zhongsm.login;

import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zhongsm.common.constant.ARouterMapping;
import com.zhongsm.common.BaseActivity;

@Route(path = ARouterMapping.Login.Login)
public class LoginActivity extends BaseActivity {

    @Override
    public int assertLayoutResID() {
        return R.layout.login_activity_login;
    }

    @Override
    public void doOnCreated() {
        Button btn = findViewById(R.id.btn_login);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(321);
                finish();
            }
        });
    }

    @Override
    public void doOnStart() {

    }

    @Override
    public void doOnRestart() {

    }

    @Override
    public void doOnResume() {

    }

    @Override
    public void doOnPause() {

    }

    @Override
    public void doOnStop() {

    }

    @Override
    public void doOnDestroy() {

    }
}