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
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.DriverManagerDataSource;

import liquibase.integration.spring.SpringLiquibase;

@Configuration
@EnableTransactionManagement
@ComponentScan({"com.humworks.dcs.config"})
@PropertySource(value={"classpath:application.properties"})
public class HibernateConfig {

	@Autowired
	private Environment environment;
	
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}
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
/*		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName(environment.getRequiredProperty("connection.driver_class"));
		driverManagerDataSource.setUrl(environment.getRequiredProperty("connection.url"));
		driverManagerDataSource.setUsername(environment.getRequiredProperty("connection.username"));
		driverManagerDataSource.setPassword(environment.getRequiredProperty("connection.password"));
		return driverManagerDataSource;*/
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClass(environment.getRequiredProperty("connection.driver_class"));
		driverManagerDataSource.setJdbcUrl(environment.getRequiredProperty("connection.url"));
		driverManagerDataSource.setUser(environment.getRequiredProperty("connection.username"));
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
		properties.put("hibernate.cache.use_query_cache", environment.getRequiredProperty("cache.use_query_cache"));
		properties.put("hibernate.cache.use_second_level_cache", environment.getRequiredProperty("cache.use_second_level_cache"));
		properties.put("hibernate.cache.region.factory_class", environment.getRequiredProperty("hibernate.cache.region.factory_class"));
//		properties.put("cache.provider_class", environment.getRequiredProperty("cache.provider_class"));
//		properties.put("format_sql", environment.getRequiredProperty("format_sql"));
				
		properties.put("hibernate.c3p0.min_size", environment.getRequiredProperty("c3p0.minPoolSize"));
		properties.put("hibernate.c3p0.max_size", environment.getRequiredProperty("c3p0.maxPoolSize"));
		properties.put("hibernate.c3p0.timeout", environment.getRequiredProperty("c3p0.maxIdleTime"));
		properties.put("hibernate.c3p0.max_statements", environment.getRequiredProperty("c3p0.maxStatements"));
		properties.put("hibernate.c3p0.idle_test_period", environment.getRequiredProperty("c3p0.idleConnectionTestPeriod"));
		return properties;
	}
	
	//Liquibase
	
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
