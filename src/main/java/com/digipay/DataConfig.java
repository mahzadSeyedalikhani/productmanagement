package com.digipay;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@ComponentScan("com.digipay")
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.digipay")
public class DataConfig {
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost/PRODUCT";
    private final String USERNAME = "root";
    private final String PASSWORD = "password";
    private final String PROPERTY_SHOW_SQL = "hibernate.show._sql";
    private final String PROPERTY_DIALECT = "hibernate.dialect";

    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory(){

        LocalContainerEntityManagerFactoryBean lfb = new LocalContainerEntityManagerFactoryBean();
        lfb.setDataSource(dataSource());
        lfb.setJpaProperties(hibernateProps());

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        lfb.setJpaVendorAdapter(vendorAdapter);
        lfb.setPackagesToScan("com.digipay");
        return lfb;
    }

    @Bean
    DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUrl(URL);
        ds.setUsername(USERNAME);
        ds.setPassword(PASSWORD);
        ds.setDriverClassName(DRIVER);
        return ds;
    }

    @Bean
    Properties hibernateProps(){
        Properties properties = new Properties();
        properties.setProperty(PROPERTY_DIALECT, "org.hibernate.dialect.MySQLDialect");
        properties.setProperty(PROPERTY_SHOW_SQL, "true");
        properties.setProperty("hibernate.hbm2ddl.auto","update");
        return properties;
    }

    @Bean
    JpaTransactionManager transactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

}
