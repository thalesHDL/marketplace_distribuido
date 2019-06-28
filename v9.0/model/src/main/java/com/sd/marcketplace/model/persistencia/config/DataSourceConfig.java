package com.sd.marcketplace.model.persistencia.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.sd.marcketplace.model.persistencia.repository")
public class DataSourceConfig {

	@Bean(destroyMethod = "close")
	public DataSource dataSoruce(Environment env) {
		HikariConfig dataSourceConfig = new HikariConfig();
		dataSourceConfig.setDriverClassName(env.getRequiredProperty("spring.datasource.driver-class-name"));
		dataSourceConfig.setJdbcUrl(env.getRequiredProperty("spring.datasource.url"));
		dataSourceConfig.setUsername(env.getRequiredProperty("spring.datasource.username"));
		dataSourceConfig.setPassword(env.getRequiredProperty("spring.datasource.password"));
		return new HikariDataSource(dataSourceConfig);
	}
	
	@Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setShowSql(true);
        hibernateJpaVendorAdapter.setGenerateDdl(false);
        hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
        return hibernateJpaVendorAdapter;
    }
	
	@Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager();
    }

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, Environment env, JpaVendorAdapter jpaVendorAdapter) {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource);
		entityManagerFactoryBean.setPackagesToScan("com.sd.marcketplace.model.persistencia.table");
		entityManagerFactoryBean.setJpaProperties(jpaProperties(env));
		entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
		entityManagerFactoryBean.setPersistenceUnitName("marcketplace");
		return entityManagerFactoryBean;
	}

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory, DataSource dataSource) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setDataSource(dataSource);
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}

	private Properties jpaProperties(Environment env) {
		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.dialect", env.getRequiredProperty("spring.jpa.hibernate.dialect"));
		jpaProperties.put("hibernate.naming.physical-strategy",
				env.getRequiredProperty("spring.jpa.hibernate.naming.physical-strategy"));
		jpaProperties.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("spring.jpa.hibernate.hbm2ddl.auto"));
		jpaProperties.put("hibernate.format_sql", env.getRequiredProperty("spring.jpa.hibernate.format_sql"));
		jpaProperties.put("hibernate.show_sql", env.getRequiredProperty("spring.jpa.hibernate.show_sql"));
		return jpaProperties;
	}

}
