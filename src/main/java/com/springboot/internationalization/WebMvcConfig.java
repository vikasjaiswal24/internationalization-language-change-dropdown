package com.springboot.internationalization;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 * By default, a Spring Boot application will look for properties files
 * under the src/main/resources folder.
*/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	/**
	 * In order for our application to be able to determine which locale is currently being used, 
	 * we need to add a LocaleResolver bean.
	 * 
	 * The LocaleResolver interface has implementations that determine the current locale 
	 * based on the session, cookies, the Accept-Language header, or a fixed value.
	 */
    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(Locale.US);
        return sessionLocaleResolver;
    }

    /**
	 * Next, we need to add an interceptor bean that will switch to a new
	 * locale based on the value of the language parameter appended to a request
	 */
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("language");
        return localeChangeInterceptor;
    }

    /**
	 * In order to take effect, this bean needs to be added to the application’s interceptor registry.
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
}