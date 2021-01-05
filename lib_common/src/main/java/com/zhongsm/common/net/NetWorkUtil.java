package com.zhongsm.common.net;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author WangJ
 * @version 0.1
 * @since 2020/12/29
 */
public class NetWorkUtil {
    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    private static final OkHttpClient client = new OkHttpClient.Builder()
            .addNetworkInterceptor(null)
//            .cache(new Cache())
            .build();

    public static void post() {
        client.newCall(null).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                response.body();
            }
        });
    }
}
