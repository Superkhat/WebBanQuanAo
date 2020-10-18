package com.dev.Sales.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.dev.Sales.Beans.NormalPasswordEncoder;



@Configuration
@EnableWebSecurity
public class SecurityConf extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
		
		
        .antMatchers("/css/**", "/js/**", "/img/**", "/vendor/**", "/bootstrap/**"
        		, "/plugins/**", "/less/**", "/summernote/**"
        		, "/files/**").permitAll()
        
        
        .antMatchers("/Admin/**").authenticated()
        
        .and() // kết hợp với điều kiện.
        
        /////// L O G O U T ///////
        // khi click vào button logout thì không cần login.
        // khi click vào button này thì dữ liệu user trên session sẽ bị xoá.
        .logout().logoutUrl("/perform_logout").logoutSuccessUrl("/Login")
        .invalidateHttpSession(true) // xoá hết dữ liệu trên seesion
        .deleteCookies("JSESSIONID") // xoá hết dữ liệu trên cokies.
        .permitAll()
        
        .and() // kết hợp với điều kiện.
        
        /////// L O G I N ///////
        .formLogin() // thực hiện xác thực qua form(username và password)
        .loginPage("/Login") // trang login do mình thiết kế.
        .loginProcessingUrl("/perform_login") // link action for form post.
        .defaultSuccessUrl("/Admin/index", true) // when user success authenticated then go to this url.
        .failureUrl("/Login?login_error=true") // nhập username, password sai thì redirect về trang nào.
        .permitAll();
	}
	
	@Bean public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }
	
	@Autowired private UserDetailsService userDetailsService;
	
	@Autowired public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// thực hiện gắn kết AuthenticationManager với UserDetailsService.  
		auth.userDetailsService(userDetailsService).passwordEncoder(new NormalPasswordEncoder());
	}
}
