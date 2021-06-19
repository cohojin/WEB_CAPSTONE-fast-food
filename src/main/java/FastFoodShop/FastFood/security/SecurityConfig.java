package FastFoodShop.FastFood.security;

//
//

import FastFoodShop.FastFood.encode.BCryptImpl;
import FastFoodShop.FastFood.encode.EncryptHandler;
import FastFoodShop.FastFood.jwt.JwtAuthenticationFilter;
import FastFoodShop.FastFood.jwt.JwtTokenProvider;
import FastFoodShop.FastFood.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private MemberService memberService;
    private final JwtTokenProvider jwtTokenProvider;



    @Override
    public void configure(WebSecurity web) throws Exception
    {
        // static 디렉터리의 하위 파일 목록은 인증 무시 ( = 항상통과 )
        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**","/images/**","/font/**","/html/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // session x
                .and()
                .authorizeRequests() // check authorize
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasRole("USER")
                .anyRequest().permitAll() // permit all
                .and()
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider),
                        UsernamePasswordAuthenticationFilter.class);
        http.cors().disable()
                .csrf().disable()
                .formLogin()
                .loginPage("/members/login").permitAll()
                .usernameParameter("userid")
                .passwordParameter("userpw")
                .successForwardUrl("/members/loginSuc")
                .failureForwardUrl("/members/loginFal");

         // 403 예외처리 핸들링

    }


    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Bean
    public EncryptHandler encryptConfigure() {

        return new BCryptImpl();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {

        return super.authenticationManagerBean();
    }


}
