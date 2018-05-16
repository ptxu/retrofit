/**
 * Copyright: Copyright (c) 2018 
 * Company:深圳市深网视界科技有限公司
 * 
 * @author dell
 * @date 2018年4月28日 下午5:33:22
 * @version V1.0
 */
package com.ptxu.retrofit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import retrofit2.Retrofit;

/**
 * @ClassName: RestAdapterConfig
 * @Description: TODO
 * @author dell
 * @date 2018年4月28日 下午5:33:22
 *
 */
@Configuration
public class RestAdapterConfig {

    /**
     * 获取RestAdapter单例Bean
     * 
     * @return
     */
    @Bean
    public Retrofit getRestAdapter() {
        /**
         * setEndpoint("http://localhost:8081"):指定基本的URL， API接口中的URL是相对于该URL的路径的， 不能少了协议名，例如写成：localhost:8081就不行
         */
        Retrofit adapter = new Retrofit.Builder().baseUrl("http://localhost:8081").build();
        return adapter;
    }

}
