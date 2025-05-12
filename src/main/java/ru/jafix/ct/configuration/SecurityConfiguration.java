package ru.jafix.ct.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration {
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .cors(e -> e.disable())
                .csrf(e -> e.disable())
                .authorizeHttpRequests(e -> e
                        .requestMatchers(HttpMethod.POST, "/api/users").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/api/users").hasAuthority("admin")
                        .requestMatchers(HttpMethod.PUT, "/api/users").hasAnyAuthority("admin", "teacher")
                        .requestMatchers(HttpMethod.GET, "/api/users").authenticated()
                        .anyRequest().denyAll())
                .formLogin(AbstractHttpConfigurer::disable)
                ;
        return http.build();
    }
}
