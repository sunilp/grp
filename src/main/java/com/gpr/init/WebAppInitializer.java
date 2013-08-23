package com.gpr.init;

import com.gpr.db.repository.PersistenceConfiguration;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
	protected Class<?>[] getRootConfigClasses() {
        return null; //new Class<?>[]{PersistenceConfiguration.class};
    }

    @Override
	protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    @Override
	protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
