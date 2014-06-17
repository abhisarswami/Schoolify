package com.bitsatom.schoolify.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.bitsatom.schoolify.authentication.XAuthTokenFilter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	XAuthTokenFilter xAuthTokenFilter;
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/**", "/docs/**").permitAll()
                .anyRequest().authenticated();
        http.csrf().disable().httpBasic().disable();
        http
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
        http.addFilterBefore(xAuthTokenFilter,BasicAuthenticationFilter.class);
        
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	
        auth.userDetailsService(userDetailsService);
    }
    
    

}
