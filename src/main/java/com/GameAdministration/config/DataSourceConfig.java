package com.GameAdministration.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DataSourceConfig {
	
	@Primary
	@Bean(name = "ds1DataSourceProperties")
	@ConfigurationProperties(prefix = "spring.datasource1")
	public DataSourceProperties ds1DataSourceProperties(){
		return new DataSourceProperties();
	}
	
	@Primary
	@Bean(name = "ds1DataSource")
	public DataSource ds1DataSource(@Qualifier("ds1DataSourceProperties") DataSourceProperties datasource){
		return datasource.initializeDataSourceBuilder().build();
	}
	
	@Bean(name = "ds2DataSourceProperties")
	@ConfigurationProperties(prefix = "spring.datasource2")
	public DataSourceProperties ds2DataSourceProperties(){
		return new DataSourceProperties();
	}
	
	@Bean(name = "ds2DataSource")
	public DataSource ds2DataSource(@Qualifier("ds2DataSourceProperties") DataSourceProperties datasource){
		return datasource.initializeDataSourceBuilder().build();
	}

}
