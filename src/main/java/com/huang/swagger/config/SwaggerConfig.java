package com.huang.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @Author Cucumber
 * @Description
 * @Date Created in 2021-04-06 10:42
 */
@Configuration
@EnableSwagger2//开启swagger2
public class SwaggerConfig {

    //配置多个分组只需要实现多个Docket实例
    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("亚索");
    }

    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("石头人");
    }

    @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("永恩");
    }

    //配置了Swagger的Docket的bean实例
    @Bean
    public Docket docket(Environment environment){

        //设置要显示的Swagger环境
        Profiles profiles = Profiles.of("dev");

        //通过environment.acceptsProfiles判断是否处在自己设定的环境当中
        boolean flag = environment.acceptsProfiles(profiles);


        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("黄文凯")
                //是否启动Swagger，如果为true，则Swagger能在浏览器中访问，反之则不能
                .enable(true)
                .select()
                //RequestHandlerSelectors,配置要扫描接口的方式
                //basePackage：指定要扫描的包
                //withClassAnnotation:扫描类上的注解，参数是一个注解的反射对象
                //withMethodAnnotation:扫描方法上的注解
                .apis(RequestHandlerSelectors.basePackage("com.huang.swagger.controller"))
                //过滤路径
                //.paths(PathSelectors.ant("/huang/**"))
                .build();
    }

    //配置Swagger信息
    private ApiInfo apiInfo(){
        //作者信息
        Contact contact = new Contact("黄文凯", "https://blog.huangstudy.com/", "804454897@qq.com");
        return new ApiInfo(
                "黄文凯的SwaggerAPI文档",
                "活到老学到老",
                "v1.0",
                "https://blog.huangstudy.com/",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList()
        );
    }

}
