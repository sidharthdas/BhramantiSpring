package com.sid.utils;

import javax.servlet.Filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

@Configuration
public class SpringSecurity extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.addFilterBefore(new CorsFilter(), ChannelProcessingFilter.class).authorizeRequests().anyRequest()
				.permitAll().and().httpBasic();
		httpSecurity.csrf().disable();

	}
}

