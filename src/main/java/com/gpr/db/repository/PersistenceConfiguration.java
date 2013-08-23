package com.gpr.db.repository;

import com.gpr.db.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

//TODO: Need to figure out why this config file does not load from init package
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories
    @ComponentScan(basePackages = {"com.gpr.db.domain"})
    @PropertySource("classpath:/db-config.properties")
    public class PersistenceConfiguration {

	public PersistenceConfiguration() {
	    super();
	}

    @Autowired
	private Environment env;

    @Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        final LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        try {
			factoryBean.setDataSource(dataSource());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
        factoryBean.setPackagesToScan(User.class.getPackage().getName());
        final JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter() {
		{
		    setDatabase(Database.POSTGRESQL);
		    setDatabasePlatform(env.getProperty("dataSource.dialect"));
		    setShowSql(Boolean.valueOf(true));
		    setGenerateDdl(Boolean.valueOf(true));
		}
	    };
        factoryBean.setJpaVendorAdapter(vendorAdapter);
        factoryBean.setJpaProperties(additionlProperties());
        return factoryBean;
    }

    @Bean
	public DataSource dataSource() throws URISyntaxException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("dataSource.driverClass"));
        
        URI dbUri = new URI(System.getenv("DATABASE_URL"));

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
        
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
	public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
						   this.entityManagerFactory().getObject());
        return transactionManager;
    }

    @Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }

	final Properties additionlProperties() {
	    return new Properties() {
		{
		    setProperty("hibernate.hbm2ddl.auto", "auto");
		    setProperty("hibernate.ejb.naming_strategy", org.hibernate.cfg.ImprovedNamingStrategy.class.getName());
		}
	    };
	}
    }