package com.wams.api.config;

import com.wams.api.jwt.JwtAccessDeniedHandler;
import com.wams.api.jwt.JwtAuthenticationEntryPoint;
import com.wams.api.jwt.JwtSecurityConfig;
import com.wams.api.jwt.TokenProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final TokenProvider tokenProvider;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;

    public SecurityConfig(TokenProvider tokenProvider, JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint, JwtAccessDeniedHandler jwtAccessDeniedHandler) {
        this.tokenProvider = tokenProvider;
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
        this.jwtAccessDeniedHandler = jwtAccessDeniedHandler;

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()

//                 세션을 사용하지 않기 때문에 STATELESS로 설정
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

//                오류 핸들링을 우리가 만든걸로 하겠다
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .accessDeniedHandler(jwtAccessDeniedHandler)

//                토큰이 없어도 접근 가능하도록 열어주자
                .and()
                .authorizeRequests()
                .antMatchers("/api/login", "/api/candidate/login", "/api/overseer/login").permitAll()
                .antMatchers("/api/overseer/**").hasAnyAuthority("overseer")
                .antMatchers("/api/candidate/**").hasAnyAuthority("candidate")
                .anyRequest().authenticated()

//                JwtSecurityConfig 적용(JwtFilter 를 addFilterBefore 로 등록해준 클래스)
//                이거 등록 해줘야 사용 가능함
                .and()
                .apply(new JwtSecurityConfig(tokenProvider));
    }
}
