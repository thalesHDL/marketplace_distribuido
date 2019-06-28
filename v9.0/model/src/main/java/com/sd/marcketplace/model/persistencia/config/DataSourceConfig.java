package com.sd.marcketplace.model.persistencia.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.persistence.SharedCacheMode;
import javax.sql.DataSource;

import org.hibernate.SharedSessionBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.SharedEntityManagerCreator;
import org.springframework.orm.jpa.support.SharedEntityManagerBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.sd.marcketplace.model.persistencia.repository")
public class DataSourceConfig {

	@Bean(destroyMethod = "close")
	@Primary
	public DataSource dataSoruce(Environment env) {
		HikariConfig dataSourceConfig = new HikariConfig();
		dataSourceConfig.setDriverClassName(env.getRequiredProperty("spring.datasource.driver-class-name"));
		dataSourceConfig.setJdbcUrl(env.getRequiredProperty("spring.datasource.url"));
		dataSourceConfig.setUsername(env.getRequiredProperty("spring.datasource.username"));
		dataSourceConfig.setPassword(env.getRequiredProperty("spring.datasource.password"));
		return new HikariDataSource(dataSourceConfig);
	}

	@Bean
	@Primary
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, Environment env) {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource);
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManagerFactoryBean.setPackagesToScan("com.sd.marcketplace.model.persistencia.table");
		entityManagerFactoryBean.setJpaProperties(jpaProperties(env));
		return entityManagerFactoryBean;
	}
	
//	@Bean
//	@Primary
//	public SharedEntityManagerBean sharedEntityManager(LocalContainerEntityManagerFactoryBean entityManagerFactory, Environment env, TransactionTemplate transactionTemplate) {
//		SharedEntityManagerCreator.createSharedEntityManager(entityManagerFactory.getEntityManagerInterface(), jpaProperties(env), true, transactionTemplate.getClass());
//		SharedEntityManagerBean sharedEntityManager = new SharedEntityManagerBean();
//		return sharedEntityManager();
//	}

	@Bean
	@Primary
	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}
	
	private Properties jpaProperties(Environment env) {
		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.dialect", env.getRequiredProperty("spring.jpa.hibernate.dialect"));
		jpaProperties.put("hibernate.naming.physical-strategy", env.getRequiredProperty("spring.jpa.hibernate.naming.physical-strategy"));
		jpaProperties.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("spring.jpa.hibernate.hbm2ddl.auto"));
		jpaProperties.put("hibernate.format_sql", env.getRequiredProperty("spring.jpa.hibernate.format_sql"));
		jpaProperties.put("hibernate.show_sql", env.getRequiredProperty("spring.jpa.hibernate.show_sql"));
		return jpaProperties;
	}

}
