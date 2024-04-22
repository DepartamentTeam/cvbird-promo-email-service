package ai.cvbird.cvbirdpromoemailservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    GoogleSuccessHandler googleSuccessHandler;

    private final String[] PERMITTED_PATTERNS = {"/signin**", "/", "/_next/**", "/static/**", "/user/registration*", "/user_registration", "/signin_error", "logout", "/*.js", "/*.json", "/*.ico"};


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authorize) ->
                        authorize.anyRequest().permitAll()
                ).formLogin(
                        form -> form
                                .loginPage("/signin")
                                .loginProcessingUrl("/signin")
                                //.failureUrl("/signin?error=true")
                                .failureUrl("/signin_error")
                                .permitAll()
                ).oauth2Login().successHandler(googleSuccessHandler)
                .and().logout().logoutSuccessUrl("https://cvbird.ai");
        return http.build();
    }
}