package hustime.member.configuration;

import java.util.Arrays;
import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.savedrequest.NullRequestCache;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.google.common.collect.ImmutableList;
import com.mysql.cj.x.protobuf.MysqlxCrud.Delete;

import hustime.member.member.service.MemberAccessDeniedHandler;
import hustime.member.member.service.MyUserService;
import hustime.member.member.service.RememberMeTokenService;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/dist/**","/vendor/**","/css/**","/js/**","/images/**", "/resources/**/**", "/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		http
			// 접근허용
			.authorizeRequests() 
			// 여기다가 지정안해주면 권한이 없어서 접근할 수 없음.
			//.antMatchers("/dist/**", "/vendor/**", "/css/**", "/js/**", "/images/**", "/resources/**/**", "/h2-console/**", "/webjars/**", "/register", "/index", "/", "/hu_login", "/password", "/lostPwd").permitAll()
			.antMatchers("/**").permitAll()
			.and()
			//.anyRequest().authenticated()
			
//			// iframe 허용
//			.headers()
//			.frameOptions().disable()
//			.and()
		
//			// DB 어드민 접속 허용
			.csrf()
			.ignoringAntMatchers("/h2-console/**", "/community/**", "/member/**")
			.and()
			
			// 로그인
			.formLogin()
			.loginPage("/hu_login")
			.loginProcessingUrl("/sign-in")
			.defaultSuccessUrl("/")
			.failureUrl("/login?error")
			.usernameParameter("email")
			.passwordParameter("password")
			.permitAll()
			.and()
			
			// 예외처리
			.exceptionHandling().accessDeniedHandler(MemberAccessDeniedHandler())
			.and()
			.rememberMe()
			.key("hustar")
			.rememberMeParameter("remember-me")
			.rememberMeCookieName("hustarcookie")
			.tokenValiditySeconds(86400) // 1day
			.tokenRepository(rememberMeTokenService()).userDetailsService(myUserService())
			.and()
			
			// 로그아웃
			.logout()
			.invalidateHttpSession(true)
			.clearAuthentication(true)
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/login?logout")
			.permitAll()
			.and();
			
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(myUserService()).passwordEncoder(bCryptPasswordEncoder());
	}
	
	@Bean
	public FilterRegistrationBean getSpringSecurityFilterChainBindedToError(
			@Qualifier("springSecurityFilterChain") Filter springSecurityFilterChain) {

		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(springSecurityFilterChain);
		registration.setDispatcherTypes(EnumSet.allOf(DispatcherType.class));
		return registration;
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public MyUserService myUserService() throws Exception{
		return new MyUserService();
	}
	
	@Bean
	public RememberMeTokenService rememberMeTokenService() throws Exception{
		return new RememberMeTokenService();
	}
	
	@Bean
	public MemberAccessDeniedHandler MemberAccessDeniedHandler() throws Exception{
		return new MemberAccessDeniedHandler();
	}

}
