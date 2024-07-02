package com.upe.brinquedotecaapi.config;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable).cors(httpSecurityCorsConfigurer -> httpSecurityCorsConfigurer.configure(http))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, "/api/v1/parent/register")
                        .permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/v1/brinquedista/register")
                        .permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/v1/brinquedista/login")
                        .permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/v1/parent/login")
                        .permitAll()

                        .requestMatchers(HttpMethod.GET, "/api/v1/parent")
                        .hasAuthority("RESPONSAVEL")

                        .requestMatchers(HttpMethod.GET, "/api/v1/parent/list")
                        .hasAuthority("RESPONSAVEL")
                        .requestMatchers(HttpMethod.POST, "/api/v1/appointment/agendar")
                        .hasAuthority("RESPONSAVEL")
                        .requestMatchers(HttpMethod.GET, "/api/v1/appointment/listar-semana")
                        .hasAnyAuthority("BRINQUEDISTA", "ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/v1/brinquedista/info")
                        .hasAnyAuthority("BRINQUEDISTA")




                        .requestMatchers(HttpMethod.POST, "/api/v1/child")
                        .hasAnyAuthority("RESPONSAVEL")

                        .requestMatchers(HttpMethod.GET, "/api/v1/child")
                        .hasAnyAuthority("RESPONSAVEL")

                        .requestMatchers(HttpMethod.GET, "/api/v1/child/list")
                        .hasAnyAuthority("RESPONSAVEL")


                        .requestMatchers("/v3/**", "/swagger-ui/**")
                        .permitAll()
                        .anyRequest().authenticated())
                .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}