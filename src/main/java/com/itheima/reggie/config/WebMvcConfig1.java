package com.itheima.reggie.config;

//import com.itheima.reggie.common.JacksonObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig1 implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/backend/**").addResourceLocations("classpath:/backend/");
        registry.addResourceHandler("/front/**").addResourceLocations("classpath:/front/");

    }
}
//@Override
//protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
//    MappingJackson2CborHttpMessageConverter messageConverter = new MappingJackson2CborHttpMessageConverter();
//    messageConverter.setObjectMapper(new JacksonObjectMapper());
//    converters.add(0,messageConverter);
//}

