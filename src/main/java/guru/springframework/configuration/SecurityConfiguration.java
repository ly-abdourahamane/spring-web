package guru.springframework.configuration;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
 
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
 
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
    	//to allow everything to go through
    	//to permit all requests coming from the root context
        httpSecurity.authorizeRequests().antMatchers("/").permitAll();
    	
    	//Allowing all access to the url path /console/*
    	//httpSecurity.authorizeRequests().antMatchers("/").permitAll().and()
        //.authorizeRequests().antMatchers("/console/**").permitAll(); 
    	
    	//this security configuration will:
        // Allows all requests to the /, /products, /product/show/*, /console/** paths
        // Secures all other paths of the application to require authentication
        // Allows everyone to view a custom /login page specified by loginPage()
        // Permits all to make logout calls    	
    	/*httpSecurity
        .authorizeRequests().antMatchers("/","/products","/product/show/*","/console/**").permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin().loginPage("/login").permitAll()
        .and()
        .logout().permitAll();*/


    	//httpSecurity.csrf().disable(); //Disable CRSF (Cross-Site Request Forgery). By default, Spring Security will protect against CRSF attacks
    	//httpSecurity.headers().frameOptions().disable(); //Since the H2 database console runs inside a frame, you need to enable this in in Spring Security
    }
    
    //it configures in-memory authentication with two users.
    //The first user with the username user and a password user is assigned a role of USER.
    //The second user with the username admin and a password admin is assigned a role of ADMIN.    
    /*@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("admin").password("admin").roles("ADMIN")
                .and().withUser("user").password("user").roles("USER");;
    }*/
 
}