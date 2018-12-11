package org.wonderming.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2018/12/11
 * @Time: 10:52
 * @Project: youqu
 * @Package: org.wonderming.config
 */

/**
 * 加载集成测试类需要加这个注释
 */
@WebAppConfiguration
/**
 * 启用Swagger2
 */
@EnableSwagger2
/**
 * 可从中导入SpringMVC配置
 */
@EnableWebMvc
@ComponentScan(basePackages = "org.wonderming.controller")
public class SwaggerConfig {

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("YouQu Project RestFull Api Document")
                .description("YouQu项目接口测试")
                .version("v1.0")
                .termsOfServiceUrl("https://github.com/WonderMing13")
                .build();

    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }


}
