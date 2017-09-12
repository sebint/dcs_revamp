package com.humworks.dcs.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import liquibase.integration.spring.SpringLiquibase;

@Configuration
@EnableTransactionManagement
@ComponentScan({"com.humworks.dcs.config"})
@PropertySource(value={"classpath:application.properties"})
public class HibernateConfig {

	@Autowired
	private Environment environment;
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(){
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] {"com.humworks.dcs.entities"});
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName(environment.getRequiredProperty("connection.driver_class"));
		driverManagerDataSource.setUrl(environment.getRequiredProperty("connection.url"));
		driverManagerDataSource.setUsername(environment.getRequiredProperty("connection.username"));
		driverManagerDataSource.setPassword(environment.getRequiredProperty("connection.password"));
		return driverManagerDataSource;
	}
	
	private Properties hibernateProperties(){
		Properties properties = new Properties();
		properties.put("connection.CharSet", environment.getRequiredProperty("charSet"));
		properties.put("connection.characterEncoding", environment.getRequiredProperty("characterEncoding"));
		properties.put("connection.useUnicode", environment.getRequiredProperty("useUnicode"));
		properties.put("dialect", environment.getRequiredProperty("dialect"));
		properties.put("show_sql", environment.getRequiredProperty("show_sql"));
		properties.put("cache.provider_class", environment.getRequiredProperty("cache.provider_class"));
//		properties.put("format_sql", environment.getRequiredProperty("format_sql"));
		return properties;
	}
	
	@Bean
	public SpringLiquibase liquibase() {
	    SpringLiquibase liquibase = new SpringLiquibase();
	    liquibase.setChangeLog("classpath:liquibase/liquibase-changeLog.xml");
	    liquibase.setDataSource(dataSource());
	    return liquibase;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory){
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory);
		return transactionManager;
	}
	
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslationPostProcessor(){
		return new PersistenceExceptionTranslationPostProcessor();
	}
}
