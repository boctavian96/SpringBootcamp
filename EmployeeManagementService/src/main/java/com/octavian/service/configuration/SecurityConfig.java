package com.octavian.service.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	// JDBC Support.
	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

		// Custom Security Tables. Example
		/*
		 * jdbcUserDetailsManager.
		 * setUsersByUsernameQuery("select user_id, pw, active from memebers where user_id=?"
		 * );
		 * 
		 * jdbcUserDetailsManager.
		 * setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id=?"
		 * );
		 */
		// Se uita automat dupa 'users' si 'authorities'.
		return jdbcUserDetailsManager;
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeHttpRequests(this::authorizedRequests);

		httpSecurity.httpBasic(Customizer.withDefaults());

		// Disable CSRF
		httpSecurity.csrf(csrf -> csrf.disable());

		return httpSecurity.build();
	}

	private void authorizedRequests(
			AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry c) {

		/*
		 * ** - Wildcard for all subtypes.
		 */

		c.requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
				.requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
				.requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN");
	}

	/*
	 * @Bean public InMemoryUserDetailsManager userDetailsManager() { //Use only for
	 * demo purposes. UserDetails octavian =
	 * User.builder().username("Octavian").password("{noop}g55326116g")
	 * .roles("MANAGER", "ADMIN", "EMPLOYEE").build();
	 * 
	 * UserDetails adelina =
	 * User.builder().username("Adelas").password("{noop}kopite").roles("MANAGER",
	 * "EMPLOYEE") .build();
	 * 
	 * UserDetails dani =
	 * User.builder().username("Julan").password("{noop}pulan").roles("EMPLOYEE").
	 * build();
	 * 
	 * return new InMemoryUserDetailsManager(octavian, adelina, dani); }
	 */
}
