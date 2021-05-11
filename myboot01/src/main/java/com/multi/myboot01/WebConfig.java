package com.multi.myboot01;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //현재클래스 설정 모든 결과 xml 파일 <bean
//@ComponentScan <context;component-scan.대신)
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**")//url 설정
                .addResourceLocations("file:///c:/upload/");//실제경로
        registry.addResourceHandler("/faceimages/**")
        		.addResourceLocations("file:///c:/python_source/images/");

    }
}


