package country.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import country.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
    private JwtAuthenticationFilter jwtFilter;

	@Autowired
    private JwtAuthenticationEntryPoint entryPoint;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
		.csrf()
        .disable()
        .cors()
        .disable()
        .authorizeRequests()
        .antMatchers("/token").permitAll()
        .antMatchers("/register").permitAll()
        .antMatchers("/country/all").permitAll()
        .antMatchers("/send-otp").permitAll()
        .antMatchers("/api/leads").permitAll()
        .antMatchers("/api/leads/{id}").permitAll()
        .antMatchers("/api/Oppo").permitAll()
        .antMatchers("/api/OppoAll").permitAll()
        .antMatchers("/api/Oppo/{id}").permitAll()
        .antMatchers("/api/account").permitAll()
        .antMatchers("/api/account/{id}").permitAll()
        .antMatchers("/api/Contacts").permitAll()
        .antMatchers("/api/Contacts/{id}").permitAll()
        .antMatchers("/api/task").permitAll()
        .antMatchers("/api/leadsAll").permitAll()
        .antMatchers("/api/task/{id}").permitAll()
        .antMatchers("/forgot").permitAll()
        .antMatchers("/change-password").permitAll()
        .antMatchers("/new-password").permitAll()
        .antMatchers("/api/insertTask").permitAll()
        .antMatchers("/api/accountname").permitAll()
        .antMatchers("/state/all").permitAll()
        .antMatchers("/city/all").permitAll()
        .antMatchers("/register").permitAll()
        .antMatchers("/username").permitAll()
        .antMatchers("/forgotPass").hasRole("USER")
        .antMatchers(HttpMethod.OPTIONS).permitAll()
        .anyRequest().authenticated()
        .and()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
        .exceptionHandling().authenticationEntryPoint(entryPoint);
		
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

	}
	
	//over
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService);
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
	
}
