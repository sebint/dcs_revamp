package com.humworks.dcs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("customUserDetailsService")
	UserDetailsService userDetailsService;

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
		auth.authenticationProvider(authenticationProvider());
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}
	
	@Autowired
	CustomAuthSuccessHandler customAuthSuccessHandler;
	
	@Autowired
	CustomAuthFailureHandler customAuthFailureHandler;
	
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
			.antMatchers("/resources/**");
	}

	@Override
    protected void configure(HttpSecurity http) throws Exception {
		
	  http.headers()
	  	.defaultsDisabled()
	  	.cacheControl();
	  
      http.authorizeRequests()
	        .antMatchers("/", "/login", "/logout", "/reset").permitAll()
	        .antMatchers("/dashboard").hasAnyRole("ADMIN","GK","IM","PDO")
	        .antMatchers("/security/**","/design/**","/manage/**").hasRole("ADMIN")
	        .antMatchers("/timeline/**","/assessment/**","/report/**","/security/user/account/**").hasAnyRole("ADMIN","GK")
	        .antMatchers("/assessment/journal-entry/**","/assessment/change-log/**").hasRole("IM")
        .and().formLogin().loginPage("/login").successHandler(customAuthSuccessHandler).failureHandler(customAuthFailureHandler)
        	.usernameParameter("strUserName").passwordParameter("strPassword")
        .and().csrf()
        .and().exceptionHandling().accessDeniedPage("/404");
      
      http.sessionManagement()
//      .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED) Default
      		.invalidSessionUrl("/login?r=is&expired")     		
      		.maximumSessions(1).expiredUrl("/login?r=ms&expired")
      	.and().sessionFixation().migrateSession();
      
      http.logout()
		.logoutSuccessUrl("/logout")
		.invalidateHttpSession(true)
		.deleteCookies("JSESSIONID")
		.and().csrf();
    }
}
