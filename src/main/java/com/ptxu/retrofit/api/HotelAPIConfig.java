/**
 * Copyright: Copyright (c) 2018 
 * Company:深圳市深网视界科技有限公司
 * 
 * @author dell
 * @date 2018年4月28日 下午5:38:27
 * @version V1.0
 */
package com.ptxu.retrofit.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import retrofit2.Retrofit;

/**
 * @ClassName: HotelAPIConfig
 * @Description: TODO
 * @author dell
 * @date 2018年4月28日 下午5:38:27
 *
 */
@Configuration
public class HotelAPIConfig {
    @Autowired
    private Retrofit adapter;

    @Bean
    public HotelAPI getHotelAPI() {
        return adapter.create(HotelAPI.class);
    }
}
