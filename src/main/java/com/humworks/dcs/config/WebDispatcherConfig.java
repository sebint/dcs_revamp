package com.humworks.dcs.config;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.humworks.dcs.interceptors.MenuListInterceptor;

@Configuration 
@EnableWebMvc
@ComponentScan(basePackages = "com.humworks.dcs")
public class WebDispatcherConfig extends WebMvcConfigurerAdapter {
	
	private static final Charset UTF8 = Charset.forName("UTF-8");
	
	@Autowired
	RoleIdToRoleConverter roleIdToRoleConverter;
	
	@Bean
	public InternalResourceViewResolver getInternalResourceViewresolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/core/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setOrder(0);
		return viewResolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/").setCachePeriod(31556926);
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("login");
		registry.addViewController("/404").setViewName("error/404");
	}
	
	@Bean
	public MessageSource messageSource(){
		ResourceBundleMessageSource messageStore = new ResourceBundleMessageSource();
		messageStore.setBasename("messages");
		return messageStore;
	}
	
	@Bean
	public LocaleResolver localeResolver(){
		SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
		sessionLocaleResolver.setDefaultLocale(Locale.ENGLISH);
		return sessionLocaleResolver;
	}
	@Bean
	public MenuListInterceptor menuListInterceptor() {
	    return new MenuListInterceptor();
	}
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("locale");
		registry.addInterceptor(localeChangeInterceptor);
		registry.addInterceptor(menuListInterceptor()).addPathPatterns("/**");
	}
	
	// Config UTF-8 Encoding.
   @Override
   public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
       StringHttpMessageConverter stringConverter = new StringHttpMessageConverter();
       stringConverter.setSupportedMediaTypes(Arrays.asList(new MediaType("text", "plain", UTF8)));
       converters.add(stringConverter);
 
       // Add other converters ...
   }
   
   /*
    * Configure Converter to be used.
    * In our example, we need a converter to convert string values[Roles] to UserProfiles in newUser.jsp
    */
   @Override
   public void addFormatters(FormatterRegistry registry) {
       registry.addConverter(roleIdToRoleConverter);
   }
}
