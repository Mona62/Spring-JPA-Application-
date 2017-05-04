package net.antra.deptemp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("a").password("1").roles("USER");
		auth.inMemoryAuthentication().withUser("Mounica").password("Dailu").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("Mouni").password("Mouni").roles("SUPERADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/protected/**").access("hasRole('ROLE_ADMIN')")
//				.antMatchers("/confidential/**").access("hasRole('ROLE_SUPERADMIN')").and().formLogin();
		  http
	        .authorizeRequests()
	        .antMatchers("/", "/main").access("hasAnyRole('USER','ADMIN')")
	        .antMatchers("/manageEmp", "/manageDept", "/addDept","/addEmp").access("hasRole('ADMIN')")
	            .and()
	        .formLogin().loginPage("/login").and().exceptionHandling().accessDeniedPage("/deny");  	
	}

}
