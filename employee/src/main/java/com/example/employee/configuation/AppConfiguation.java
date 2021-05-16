package com.example.employee.configuation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;


import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class AppConfiguation {

	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setPackagesToScan("com.example.employee.entity");

		return sessionFactory;
	}

	@Bean
	public DateFormat dateFormat() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		return format;
	}

}
