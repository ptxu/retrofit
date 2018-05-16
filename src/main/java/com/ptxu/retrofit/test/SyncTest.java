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
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * @ClassName: Test
 * @Description: TODO
 * @author dell
 * @date 2018年4月28日 下午5:41:14
 *
 */
public class SyncTest {

    /**
     * @Title: main
     * @Description: TODO
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://localhost:8081/").build();
        HotelAPI service = retrofit.create(HotelAPI.class);

        Call<ResponseBody> call = service.getHotelList();
        Call<ResponseBody> callClone = call.clone();

        Response<ResponseBody> response = call.execute();
        // System.out.println(response.errorBody().string());
        System.out.println(response.code());
        ResponseBody responseBody = response.body();
        System.out.println(responseBody.string());
        System.out.println("a");
        System.out.println(callClone.execute().body().string());

    }

}
