/**
 * Copyright: Copyright (c) 2018 
 * Company:深圳市深网视界科技有限公司
 * 
 * @author dell
 * @date 2018年4月28日 下午5:41:14
 * @version V1.0
 */
package com.ptxu.retrofit.test;

import java.io.IOException;

import com.ptxu.retrofit.api.HotelAPI;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * @ClassName: Test
 * @Description: TODO
 * @author dell
 * @date 2018年4月28日 下午5:41:14
 *
 */
public class Test {

    /**
     * @Title: main
     * @Description: TODO
     * @param args
     */
    public static void main(String[] args) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://localhost:8081/").build();
        HotelAPI service = retrofit.create(HotelAPI.class);

        Call<ResponseBody> call = service.getHotelList();
        // 用法和OkHttp的call如出一辙,
        // 不同的是如果是Android系统回调方法执行在主线程
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    System.out.println(response.body().string());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
            }
        });
        System.out.println("a");
    }

}
