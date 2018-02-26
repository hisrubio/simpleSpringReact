package es.salesianos.database;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DatabaseConfiguration {


	/**
	 * The @Bean annotation is used to declare a Spring bean and the DI
	 * requirements. The @Bean annotation is equivalent to the <bean> tag, the
	 * method name is equivalent to the id attribute within the <bean> tag.
	 * 
	 * <bean id="mySqlDataSource" class="org.apache.commons.dbcp2.BasicDataSource"
	 * destroy-method="close" p:driverClassName="${jdbc.mysql.driverClassName}"
	 * p:url="${jdbc.mysql.url}" p:username="${jdbc.mysql.username}" p:password=
	 * "${jdbc.mysql.password}" />
	 * 
	 * @return
	 */
	
	@Bean
	public DriverManagerDataSource h2DataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		return dataSource;
	}

}
