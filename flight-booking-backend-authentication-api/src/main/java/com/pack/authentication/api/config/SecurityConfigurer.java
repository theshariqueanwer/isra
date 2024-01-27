package com.pack.authentication.api.config;


import com.pack.authentication.api.filter.JwtFilter;
import com.pack.authentication.api.service.SecureUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.firewall.HttpFirewall;

@Configuration
@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecureUserDetailsService secureUserDetailsService;

    @Autowired
    private JwtFilter jwtFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
        auth.userDetailsService(secureUserDetailsService);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

//    @Autowired
//    private HttpFirewall httpFirewall;

//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        //@formatter:off
//        super.configure(web);
//        web.httpFirewall(allowUrlEncodedSlashHttpFirewall());
//    }

    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
//        http.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic();
        http
                .authorizeRequests()
                // ==================================================================================
                .antMatchers("/swagger-ui/**").permitAll()
                // ==================================================================================
                .antMatchers(HttpMethod.GET, "/home").permitAll()
                .antMatchers(HttpMethod.POST, "/registerUser").permitAll()
                .antMatchers(HttpMethod.POST, "/loginUserByUserName").permitAll()
                // ===================================================================================
                .antMatchers(HttpMethod.GET, "/findAllUser").permitAll()
                .antMatchers(HttpMethod.GET, "/findUserById/**").permitAll()
                .antMatchers(HttpMethod.GET, "/findUserByUserName/**").permitAll()
                .antMatchers(HttpMethod.GET, "/findUserByUserFullName/**").permitAll()
                .antMatchers(HttpMethod.PUT, "/updateUserById/**").permitAll()
                .antMatchers(HttpMethod.PUT, "/updateUserByUser").permitAll()
                .antMatchers(HttpMethod.DELETE, "/deleteUserById/**").permitAll()
                .antMatchers(HttpMethod.DELETE, "/deleteAllUser").permitAll()
                // ===================================================================================
                .antMatchers(HttpMethod.POST, "/savePassenger").permitAll()
                .antMatchers(HttpMethod.POST, "/postPassenger").permitAll()
                .antMatchers(HttpMethod.GET, "/getPassengerByPassengerId/**").permitAll()
                .antMatchers(HttpMethod.GET, "/getAllPassenger").permitAll()
                // ===================================================================================
                .antMatchers(HttpMethod.POST, "/savePayment").permitAll()
                .antMatchers(HttpMethod.POST, "/postPayment").permitAll()
                .antMatchers(HttpMethod.GET, "/getPaymentByPaymentId/**").permitAll()
                .antMatchers(HttpMethod.GET, "/getAllPayment").permitAll()
                // ===================================================================================
                .antMatchers(HttpMethod.POST,"/saveFlight").permitAll()
                .antMatchers(HttpMethod.GET, "/getAllFlight").permitAll()
                .antMatchers(HttpMethod.GET, "/getFlightByFlightId/**").permitAll()
                // ===================================================================================
                .antMatchers(HttpMethod.POST, "/searchFlightByFromAndToAndDate").permitAll()
                .antMatchers(HttpMethod.POST, "/flightBook").permitAll()
                .antMatchers(HttpMethod.POST, "/bookFlight").permitAll()
                // ===================================================================================
                .antMatchers(HttpMethod.GET, "/getAllFlightBook").permitAll()
                .antMatchers(HttpMethod.GET, "/getFlightBookByFlightBookId/**").permitAll()
                // ===================================================================================
                .antMatchers(HttpMethod.POST, "/forgot_password").permitAll()
                .antMatchers(HttpMethod.GET, "/reset_password").permitAll()
                .antMatchers(HttpMethod.POST,"/reset_password").permitAll()
                .antMatchers(HttpMethod.GET, "\"/reset_password?token=\" + token").permitAll()
                .antMatchers(HttpMethod.POST, "\"/reset_password?token=\" + token").permitAll()
                // ===================================================================================
                .anyRequest().fullyAuthenticated()
                .and()
                .httpBasic();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.cors();
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
//        super.configure(web);
        web.ignoring()
                .antMatchers(HttpMethod.GET, "/home")
                .antMatchers(HttpMethod.POST, "/registerUser")
                .antMatchers(HttpMethod.POST, "/loginWithUserName")
                .antMatchers(HttpMethod.POST, "/loginUserByUserName")
                .antMatchers(HttpMethod.PUT, "/updateUserByUser")
        // ==========================================================================================
                .antMatchers(HttpMethod.POST, "/savePassenger")
                .antMatchers(HttpMethod.POST, "/postPassenger")
                .antMatchers(HttpMethod.GET, "/getPassengerByPassengerId/**")
                .antMatchers(HttpMethod.GET, "/getAllPassenger")
        // ==========================================================================================
                .antMatchers(HttpMethod.POST, "/savePayment")
                .antMatchers(HttpMethod.POST, "/postPayment")
                .antMatchers(HttpMethod.GET, "/getPaymentByPaymentId/**")
                .antMatchers(HttpMethod.GET, "/getAllPayment")
        // ==========================================================================================
                .antMatchers(HttpMethod.POST,"/saveFlight")
                .antMatchers(HttpMethod.GET, "/getAllFlight")
                .antMatchers(HttpMethod.GET, "/getFlightByFlightId/**")
        // ==========================================================================================
                .antMatchers(HttpMethod.POST, "/searchFlightByFromAndToAndDate")
                .antMatchers(HttpMethod.POST, "/flightBook")
                .antMatchers(HttpMethod.POST, "/bookFlight")
        // ===========================================================================================
                .antMatchers(HttpMethod.GET, "/getAllFlightBook")
                .antMatchers(HttpMethod.GET, "/getFlightBookByFlightBookId/**")
        // ===========================================================================================
                .antMatchers(HttpMethod.POST, "/forgot_password")
                .antMatchers(HttpMethod.GET, "/reset_password")
                .antMatchers(HttpMethod.POST,"/reset_password")
                .antMatchers(HttpMethod.GET, "\"/reset_password?token=\" + token")
                .antMatchers(HttpMethod.POST, "\"/reset_password?token=\" + token");
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }



    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
