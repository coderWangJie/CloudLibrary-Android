package com.zhongsm.launcher;

import android.content.Intent;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.zhongsm.common.BaseActivity;
import com.zhongsm.common.constant.ARouterMapping;
import com.zhongsm.common.util.LogUtil;
import com.zhongsm.common.util.PushUtil;
import com.zhongsm.net.NetworkUtil;
import com.zhongsm.net.ResponseHandler;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Route(path = ARouterMapping.Home.Main)
public class MainActivity extends BaseActivity {

    private long lastBackTime;

    TextView tv;

    @Override
    public int assertLayoutResID() {
        return R.layout.launcher_activity_main;
    }

    @Override
    public void doOnCreated() {
        Button btn1 = findViewById(R.id.btn1);
        tv = findViewById(R.id.tv);
        Button btn2 = findViewById(R.id.btn2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(ARouterMapping.Login.Login).navigation(MainActivity.this, 1);

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtil.d(BaseActivity.TAG, "===== " + PushUtil.readDevicePushID(MainActivity.this));
            }
        });
    }

    @Override
    public void doOnStart() {

    }

    @Override
    public void doOnResume() {
//        OkHttpClient client = new OkHttpClient();
//        Request request = new Request.Builder()
//                .url("http://apis.juhe.cn/simpleWeather/query?city=宁波")
//                .get()
//                .build();
//
//        client.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(@NotNull Call call, @NotNull IOException e) {
//                LogUtil.e("WangJ", "", e);
//                tv.setText(e.getMessage());
//
//            }
//
//            @Override
//            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
//                String result = response.body().string();
//                LogUtil.d("WangJ", result);
//
//                tv.setText(result);
//            }
//        });
        NetworkUtil.get("http://apis.juhe.cn/simpleWeather/query?city=宁波", new ResponseHandler(Looper.myLooper()) {
            @Override
            public void success(String message) {
                tv.setText(message);
            }

            @Override
            public void fail(String message) {
                tv.setText(message);
            }
        });

    }

    @Override
    public void onBackPressed() {
        LogUtil.d(BaseActivity.TAG, "lastBackTime = " + lastBackTime);
        // TODO System.currentTimeMillis在高并发下会有性能瓶颈，这里是否需要考虑
        long now = System.currentTimeMillis();
        LogUtil.d(BaseActivity.TAG, "now = " + now);

        if (now - lastBackTime > 1500) {
            lastBackTime = now;
            Toast.makeText(this, "如要退出，请双击返回", Toast.LENGTH_SHORT).show();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        LogUtil.d(BaseActivity.TAG, "requestCode: " + requestCode + "\nresultCode:" + resultCode);
    }
}