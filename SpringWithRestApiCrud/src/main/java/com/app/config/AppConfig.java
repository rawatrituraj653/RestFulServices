package com.app.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.app.model.User;



@Configuration
@ComponentScan("com.app")
@EnableWebMvc
@EnableTransactionManagement
public class AppConfig {

	@Bean
	public DataSource source() {
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///springDb");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}
	@Bean
	public LocalSessionFactoryBean  factoryBean() {
		LocalSessionFactoryBean bean=new LocalSessionFactoryBean();
		bean.setAnnotatedClasses(User.class);
		bean.setDataSource(source());
		bean.setHibernateProperties(hibernate_prop());
		
		return bean;
	}
	@Bean
	public Properties hibernate_prop() {
		Properties  properties=new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL55Dialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "true");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		
		return properties;
	}
	@Bean
	public HibernateTemplate hibernateTemplate() {
		HibernateTemplate template=new  HibernateTemplate();
		template.setSessionFactory(factoryBean().getObject());
		return template;
	}
	@Bean
	public HibernateTransactionManager transactionManager() {
	HibernateTransactionManager hibernateTransactionManager=new HibernateTransactionManager();
	hibernateTransactionManager.setSessionFactory(factoryBean().getObject());
	return hibernateTransactionManager;
	}

}
