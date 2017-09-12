package com.humworks.dcs.config;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.mvc.WebContentInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.humworks.dcs.interceptors.MenuListInterceptor;

@Configuration 
@EnableWebMvc
@ComponentScan(basePackages = "com.humworks.dcs")
@PropertySource(value={"classpath:application.properties"})
public class WebDispatcherConfig extends WebMvcConfigurerAdapter {
	
	private static final Charset UTF8 = Charset.forName("UTF-8");
	
	@Autowired
	RoleIdToRoleConverter roleIdToRoleConverter;
	
	@Autowired
	private Environment environment;
	
	public void setRoleIdToRoleConverter(RoleIdToRoleConverter roleIdToRoleConverter) {
		this.roleIdToRoleConverter = roleIdToRoleConverter;
	}

	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

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
	
	//prevents the form to redirect to previous page after logout
	@Bean
	public WebContentInterceptor webContentInterceptor() {
        WebContentInterceptor interceptor = new WebContentInterceptor();
        interceptor.setCacheSeconds(0);
        return interceptor;
    }
	
	@Bean
	public JavaMailSender getJavaMailSender(){
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(environment.getRequiredProperty("mail.host"));
		mailSender.setPort(Integer.parseInt(environment.getRequiredProperty("mail.port")));
		mailSender.setUsername(environment.getRequiredProperty("mail.sender"));
		mailSender.setPassword("");
		
		Properties javaMailProperties = new Properties();
		javaMailProperties.put("mail.smtp.starttls.enable", environment.getRequiredProperty("mail.smtp.starttls.enable"));
		javaMailProperties.put("mail.smtp.auth", environment.getRequiredProperty("mail.amtp.auth"));
		javaMailProperties.put("mail.transport.protocol", environment.getRequiredProperty("mail.transport.protocol"));
		javaMailProperties.put("mail.debug", environment.getRequiredProperty("mail.debug"));
		
		mailSender.setJavaMailProperties(javaMailProperties);
		return mailSender;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("locale");
		registry.addInterceptor(localeChangeInterceptor);
		registry.addInterceptor(menuListInterceptor()).addPathPatterns("/**");
		registry.addInterceptor(webContentInterceptor());
	}
	
	// Config UTF-8 Encoding.
   @Override
   public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
       StringHttpMessageConverter stringConverter = new StringHttpMessageConverter();
       stringConverter.setSupportedMediaTypes(Arrays.asList(new MediaType("text", "plain", UTF8)));
       //for Json (Ajax post request)
       converters.add(new MappingJackson2HttpMessageConverter());
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
