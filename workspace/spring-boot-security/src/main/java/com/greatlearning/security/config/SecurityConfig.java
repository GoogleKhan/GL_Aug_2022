package com.greatlearning.security.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder passwordEncoder = getEncoder();

		auth.inMemoryAuthentication().passwordEncoder(passwordEncoder).withUser("Adam")
				.password(passwordEncoder.encode("1234")).roles("OWNER").and().withUser("Riya")
				.password(passwordEncoder.encode("4321")).roles("CLERK");
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/h2-console/**");
	}

	PasswordEncoder getEncoder() {
		return new BCryptPasswordEncoder();
	}

}
