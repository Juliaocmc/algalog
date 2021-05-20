package com.algalog.algalog.api.config;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@Profile("local")
public class LocalConfig {

    private final String host;

    private final Integer port;

    private final String user;

    private final String password;

    private String dbName;

    @Autowired
    public LocalConfig() throws Exception {
        System.out.println("*************** CREATING LOCAL CONFIG ******************");

      //        POC REMOTO 
     this.user = "postgres";
     this.password = "123456";
     this.host = "localhost";
     this.port = 5432;
     this.dbName = "algalog";
    }

    @Bean
    @Primary
    public DataSource dataSource() {

        String url = String.format("jdbc:postgresql://%s:%s/%s", this.host, this.port, this.dbName);
        System.out.println("@@@@@@ LOCAL DATABASE: " + url);
        return DataSourceBuilder.create().username(this.user).password(this.password).url(url).build();
    }

    @Bean
    public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.createEntityManager();
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() throws SQLException {

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setShowSql(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("com.algalog.algalog.api.domain.model");
        factory.setDataSource(dataSource());
        factory.afterPropertiesSet();

        return factory.getObject();

    }

}
