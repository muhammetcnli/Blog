package com.atlas.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // CSRF'yi kapat (Gerekliyse)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login", "/register","/secure" ,"/css/**", "/js/**", "/webjars/**").permitAll() // Statik dosyalar ve giriş sayfası açık
                        .anyRequest().authenticated() // Diğer tüm istekler için kimlik doğrulama gerektir
                )
                .formLogin(login -> login
                        .loginPage("/login") // Özel login sayfasını kullan
                        .defaultSuccessUrl("/index", true) // Başarılı giriş sonrası yönlendirilecek sayfa
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout") // Çıkış yapma URL'si
                        .logoutSuccessUrl("/login?logout") // Çıkış sonrası yönlendirme
                        .permitAll()
                );

        return http.build();
    }
}
