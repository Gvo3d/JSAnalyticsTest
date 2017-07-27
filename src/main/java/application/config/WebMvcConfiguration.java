package application.config;

import application.support.HttpSender;
import application.support.StatisticsHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@EnableWebMvc
@ComponentScan({"application"})
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".html");
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/webapp/WEB-INF/views/morgan/**").addResourceLocations("/morgan/");
        registry.addResourceHandler("/morgan/**").addResourceLocations("/morgan/");
    }

    @Bean
    StatisticsHandlerInterceptor statisticsHandlerInterceptor(){
        return new StatisticsHandlerInterceptor();
    }

    @Bean
    HttpSender httpSender(){
        return new HttpSender();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(statisticsHandlerInterceptor());
        super.addInterceptors(registry);
    }
}