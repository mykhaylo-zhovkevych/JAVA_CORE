package ch.wiss._3.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

/* private static final String[] EVERYONE = {"/public"};

    @Bean
    public UserDetailsService users(@Autowired PasswordEncoder pwEnc) {
        UserDetails user = User.builder()
                .username("user")
                .password(pwEnc.encode("top"))
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password(pwEnc.encode("secret"))
                .roles("USER", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()) //disable Cross-Site Request Forgery (CSRF) prevention
                .cors(Customizer.withDefaults()) //configure CORS: Cross Origin Request Sharing
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers(HttpMethod.POST, "/items").hasRole("ADMIN");
                    auth.requestMatchers(EVERYONE).permitAll();
                    auth.anyRequest().authenticated();
                })
                .formLogin(Customizer.withDefaults()) //für Login-Form im Browser
                .httpBasic(Customizer.withDefaults()); //für cURL, Postman, Insomnia
        return http.build();
    } */

@Autowired private UserDetailsServiceImpl userDetailsServiceImpl;
@Bean
public DaoAuthenticationProvider authenticationProvider() {
DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
authProvider.setUserDetailsService(userDetailsServiceImpl);
authProvider.setPasswordEncoder(passwordEncoder());
return authProvider;
}
@Bean
public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
return authConfig.getAuthenticationManager();
}
@Bean
public PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }
private static final String[] EVERYONE = { "/api/auth/**", "/hello" };
@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
http.csrf(csrf -> csrf.disable())
.cors(Customizer.withDefaults())
.authorizeHttpRequests(auth -> auth.requestMatchers(EVERYONE).permitAll()
.anyRequest().authenticated()) //add anything u need
.formLogin(Customizer.withDefaults()) // für Login-Form
.httpBasic(Customizer.withDefaults()); // für CURL, Postman
return http.build();
}
}