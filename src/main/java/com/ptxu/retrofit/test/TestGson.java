/**
 * Copyright: Copyright (c) 2018 
 * Company:深圳市深网视界科技有限公司
 * 
 * @author dell
 * @date 2018年4月28日 下午5:41:14
 * @version V1.0
 */
package com.ptxu.retrofit.test;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ptxu.retrofit.api.HotelGsonAPI;
import com.ptxu.retrofit.domain.Hotel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @ClassName: Test
 * @Description: TODO
 * @author dell
 * @date 2018年4月28日 下午5:41:14
 *
 */
public class TestGson {

    /**
     * @Title: main
     * @Description: TODO
     * @param args
     */
    public static void main(String[] args) {
        Gson gson = new GsonBuilder()
                // 配置你的Gson
                .setDateFormat("yyyy-MM-dd hh:mm:ss").create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://localhost:8081/")
                // 可以接收自定义的Gson，当然也可以不传
                .addConverterFactory(GsonConverterFactory.create(gson)).build();
        HotelGsonAPI service = retrofit.create(HotelGsonAPI.class);

        Call<List<Hotel>> call = service.getHotelList();
        // 用法和OkHttp的call如出一辙,
        // 不同的是如果是Android系统回调方法执行在主线程
        call.enqueue(new Callback<List<Hotel>>() {
            @Override
            public void onResponse(Call<List<Hotel>> call, Response<List<Hotel>> response) {
                for (Hotel hotel : response.body()) {
                    System.out.println(hotel.toString());
                }
            }

            @Override
            public void onFailure(Call<List<Hotel>> call, Throwable t) {
                // TODO Auto-generated method stub

            }
        });
        System.out.println("a");
    }

}
