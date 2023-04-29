package configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebMvc
public class SecurityConfig extends WebMvcConfigurerAdapter {
	@Bean
	public BCryptPasswordEncoder securityPasswordEncoder() {
	    return new BCryptPasswordEncoder();
	}
}