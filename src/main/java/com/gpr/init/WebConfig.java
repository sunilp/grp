package com.gpr.init;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;


@Configuration
@EnableWebMvc
    @ComponentScan(basePackages = { "com.gpr.mvc.controller","com.gpr.service","com.gpr.db.repository" })
    public class WebConfig extends WebMvcConfigurerAdapter {
 
    @Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**").addResourceLocations("/public/");
    }
 
    @Bean
	public ViewResolver viewResolver() {
    	TilesViewResolver viewResolver = new TilesViewResolver();
        return  viewResolver;
    }
    
    @Bean
    public TilesConfigurer tilesConfigurer(){
    	TilesConfigurer tilesConfigurer = new TilesConfigurer();
    	tilesConfigurer.setDefinitions(new String[]{"/WEB-INF/tiles.xml"});
    	return tilesConfigurer;
    }
    
    }