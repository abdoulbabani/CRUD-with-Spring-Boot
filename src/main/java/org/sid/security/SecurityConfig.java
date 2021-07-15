package org.sid.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		PasswordEncoder passwordEncoder = passwordEncoder();

		auth.inMemoryAuthentication().withUser("user1").password(passwordEncoder.encode("1234")).roles("user");
		auth.inMemoryAuthentication().withUser("user2").password(passwordEncoder.encode("1234")).roles("user");
		auth.inMemoryAuthentication().withUser("user3").password(passwordEncoder.encode("1234")).roles("user", "ADMIN");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
 
		/* cette requette permet d afficher la page login*/
		http.formLogin();
		
		/* cette requette permet de specifier que seul admin est authauriser a la faire*/
		
		http.authorizeRequests().antMatchers("/save**/**", "/delesupprimer**/**", "/Ajouter**/**").hasRole("ADMIN");
		
		/* cette requette permet de specifier que seul Utilisateur User est authauriser a la faire*/
		
		http.authorizeRequests().antMatchers("/index**/**").hasRole("user");
		
		/**http.authorizeRequests().anyRequest().authenticated();
		 * 
		 */
		http.csrf();

		/* utiliser cette methode pour afficher les pages par defaut */

		http.exceptionHandling().accessDeniedPage("/notAuthorized");
	}

	
	/*
	 * la classe new BCryptPasswordEncoder() return un objet de type PasswordEncoder
	 * qui possede une methode encode() pour coder le mot de pass avant la
	 * 
	 * sauvegarde et l utilisation de BEAN veut dire qu on pourrait utiliser cette
	 * objet dans d autres class de l apllication apres l insjection de @Autowired
	 */
	  
	 
	@Bean

	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
