package tn.Dari.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.AllArgsConstructor;
import tn.Dari.entities.RoleName;
import tn.Dari.services.UserServiceImpl;

@Configuration
@EnableWebSecurity
@Order(101)
@AllArgsConstructor

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
  private  UserServiceImpl userservice;
  private  BCryptPasswordEncoder bCryptPasswordEncoder ;
	@Override
	protected void configure (AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(daoAuthenticationProvider());
		auth.inMemoryAuthentication()
        .withUser("DariAdmin").password(bCryptPasswordEncoder.encode("AdminDari")).roles("Admin");
				
	}
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider =
				new DaoAuthenticationProvider();
		provider.setPasswordEncoder(bCryptPasswordEncoder);
		provider.setUserDetailsService(userservice);
		return provider;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/api/v*/registration/**").permitAll()
		.antMatchers("http://localhost:8082").permitAll()
		.antMatchers("/api/v*/AllUsers/**").hasRole("Admin")
		.antMatchers("/api/v*/FindUser/{id}/**").hasRole("Admin")
		.antMatchers("/api/v*/UpdateUser/**").hasRole("Admin")
		.antMatchers("/api/v*/DeleteUser/{id}/**").hasRole("Admin")
		.anyRequest()
		.authenticated().and()
		.formLogin();
	}

}
