/**
 * Copyright: Copyright (c) 2018 
 * Company:深圳市深网视界科技有限公司
 * 
 * @author dell
 * @date 2018年4月28日 下午5:35:29
 * @version V1.0
 */
package com.ptxu.retrofit.api;

import com.ptxu.retrofit.domain.Hotel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @ClassName: HotelAPI
 * @Description: TODO
 * @author dell
 * @date 2018年4月28日 下午5:35:29
 *
 */
public interface HotelAPI {

    /**
     * GET请求带查询参数
     */
    @GET("/hotel/getHotelWithQueryParameter")
    public Call<ResponseBody> getHotelWithQueryParameter(@Query("hotelname") String hotelname);

    /**
     * POST请求
     */
    @POST("/hotel/getHotelList")
    public Call<ResponseBody> getHotelList();

    /**
     * POST请求,带参数JavaBean
     */
    @POST("/hotel/getHotelListWithBody")
    public Call<ResponseBody> getHotelListWithBody(@Body Hotel hotel);

}
