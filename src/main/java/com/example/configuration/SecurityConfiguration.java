package com.example.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private DataSource dataSource;

	@Value("${spring.queries.users-query}")
	private String usersQuery;

	@Value("${spring.queries.roles-query}")
	private String rolesQuery;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.jdbcAuthentication().usersByUsernameQuery(usersQuery).authoritiesByUsernameQuery(rolesQuery)
				.dataSource(dataSource).passwordEncoder(bCryptPasswordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception
	{

		http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/login").permitAll()
				.antMatchers("/registration", "/registration/1").permitAll().antMatchers("/fileUpload").permitAll()
				.antMatchers("/uploadStatus").permitAll().antMatchers("/warehouse/listing").permitAll()
				.antMatchers("/home").permitAll().antMatchers("/gifs/**").permitAll().antMatchers("/addEmployee")
				.permitAll().antMatchers("/search").permitAll().antMatchers("/students").permitAll()
				.antMatchers("/blog").permitAll().antMatchers("/orderRequest/listing").permitAll()
				.antMatchers("/saveFileAndForm").permitAll().antMatchers("/mergeForm").permitAll()
				.antMatchers("/orderRequest/paginated/listing").permitAll().antMatchers("/guests/**", "/searchFragment")
				.permitAll().antMatchers("/create/orderRequest/form", "/create/data/orderRequest", "/users/listing",
						"/inputTransactions/listing","/out/data/request","/inputTxn/paginated/listing","/outDataRequest","/saveAndGetInputTxns","/saveAndGetInputTxns/final")
				.permitAll()

				.antMatchers("/upload").permitAll().antMatchers("/warehouse/view/registration").permitAll()
				.antMatchers("/warehouse/registration").permitAll().antMatchers("/admin/**").hasAuthority("ADMIN")
				.anyRequest().authenticated().and().csrf().disable().formLogin().loginPage("/login")
				.failureUrl("/login?error=true").defaultSuccessUrl("/admin/home").usernameParameter("email")
				.passwordParameter("password").and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/").and().exceptionHandling().accessDeniedPage("/access-denied");
	}

	@Override
	public void configure(WebSecurity web) throws Exception
	{
		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}

}