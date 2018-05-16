/**
 * Copyright: Copyright (c) 2018 
 * Company:深圳市深网视界科技有限公司
 * 
 * @author dell
 * @date 2018年4月28日 下午5:35:29
 * @version V1.0
 */
package com.ptxu.retrofit.api;

import java.util.List;

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
public interface HotelGsonAPI {

    /**
     * GET请求带查询参数
     */
    @GET("/hotel/getHotelWithQueryParameter")
    public Call<List<Hotel>> getHotelWithQueryParameter(@Query("hotelname") String hotelname);

    /**
     * POST请求
     */
    @POST("/hotel/getHotelList")
    public Call<List<Hotel>> getHotelList();

    /**
     * POST请求,带参数JavaBean
     */
    @POST("/hotel/getHotelListWithBody")
    public Call<List<Hotel>> getHotelListWithBody(@Body Hotel hotel);

}
