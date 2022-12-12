package com.BikkadIT.Config;

import java.util.Properties;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
public class HibernateConfig {

	@Value("${db.driver}")
	private String DRIVER;
	@Value("${db.url}")
	private String URL;
	@Value("${db.username}")
	private String USERNAME;
	@Value("${db.password}")
	private String PASSWORD;
	@Value("${hp.dialect}")
	private String DIALECT;
	@Value("${hp.hbm2ddl}")
	private String HBM2DDL;
	@Value("${hp.show_sql}")
	private String SHOW_SQL;
	@Value("${hp.packageToScan}")
	private String PACKAGETOSCAN;
	
	
	
	@Bean
	public DriverManagerDataSource dataSource()
	{
		DriverManagerDataSource ds= new DriverManagerDataSource();
		ds.setDriverClassName(DRIVER);
		ds.setUrl(URL);
		ds.setUsername(USERNAME);
		ds.setPassword(PASSWORD);
		return ds;
		
	}
	@Bean
	public LocalSessionFactoryBean factoryBean()
	{
		LocalSessionFactoryBean sf= new LocalSessionFactoryBean();
		sf.setDataSource(dataSource());
		
		Properties p= new Properties();
		p.put(Environment.DIALECT,DIALECT);
		p.put(Environment.HBM2DDL_AUTO,HBM2DDL);
		p.put(Environment.SHOW_SQL, SHOW_SQL);
		sf.setHibernateProperties(p);
		sf.setPackagesToScan(PACKAGETOSCAN);
		return sf;
		
		
	}
}
