package com.avg.poc.springboot.daojdbc;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.avg.poc.springboot.daojdbc")
public class JDBCConfig {

    private final String JDBC_DRIVER_CLASSSNAME = "org.h2.Driver";
    private final String JDBC_URL = "jdbc:h2:file:./data/db";
    private final String JDBC_USER = "sa";
    private final String JDBC_PASSWORD = "password";

    @Bean(name = "h2DataSource")
    @Primary
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(JDBC_DRIVER_CLASSSNAME);
        dataSourceBuilder.url(JDBC_URL);
        dataSourceBuilder.username(JDBC_USER);
        dataSourceBuilder.password(JDBC_PASSWORD);
        return dataSourceBuilder.build();
    }

//    <bean id="h2DataSource" class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close">
//        <property name="driverClassName" value="org.h2.Driver"/>
//        <property name="url" value="dbc:h2:file:./data/db"/>
//        <property name="username" value="sa"/>
//        <property name="password" value="password"/>
//    </bean>

    @Bean(name = "h2EmbeddedDataSource")
    public DataSource getEmbeddedDataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:schema.sql")
                .addScript("classpath:data.sql").build();
    }

}
