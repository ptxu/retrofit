/**
 * Copyright: Copyright (c) 2018 
 * Company:深圳市深网视界科技有限公司
 * 
 * @author dell
 * @date 2018年4月28日 下午5:25:14
 * @version V1.0
 */
package com.ptxu.retrofit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName: Application
 * @Description: TODO
 * @author dell
 * @date 2018年4月28日 下午5:25:14
 *
 */
@SpringBootApplication
@EnableSwagger2
public class Application implements EmbeddedServletContainerCustomizer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * EmbeddedServletContainerCustomizer接口的未实现方法 指定容器的启动端口，之后再浏览器输入localhost:8081/swagger-ui.html即可
     */
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setPort(8081);
    }

}