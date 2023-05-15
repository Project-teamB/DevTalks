package com.teamproject.devTalks.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.teamproject.devTalks.filter.JwtAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig {

    private JwtAuthenticationFilter jwtAuthenticationFilter;
    
    @Autowired
    public WebSecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }
    
    @Bean
    protected SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception{
    

        httpSecurity.cors().and()
                .csrf().disable()
                .httpBasic().disable()

                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                .antMatchers("/user/signUp", "/user/signIn","/user/{userNumber}").permitAll()
                .antMatchers(HttpMethod.PATCH, "/user/update").hasRole("USER")
                .antMatchers("/admin/signUp", "/admin/signIn").permitAll()
                .antMatchers("/recommendation/**").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/information", "/notice/**", "/qna", "/recruit", "/teacher").permitAll()
                .antMatchers(HttpMethod.POST, "/information",  "/qna", "/recruit", "/teacher").hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/information/**", "/qna/**", "/recruit/**", "/teacher/**").hasRole("USER")
                .antMatchers(HttpMethod.PATCH, "/information/**", "/qna/**", "/recruit/**", "/teacher/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/notice/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"notice/**").hasRole("ADMIN")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated();
                    

        httpSecurity.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();

}
}
