package com.elephant.user.server.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationManager;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

@Configuration
@EnableWebSecurity
public class OAuth2WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public ResourceServerTokenServices resourceServerTokenServices(){
        RemoteTokenServices tokenServices = new RemoteTokenServices();
        tokenServices.setClientId("userService");
        tokenServices.setClientSecret("123456");
        tokenServices.setCheckTokenEndpointUrl("http://localhost:8080/oauth/check_token");
        return tokenServices;
    }

    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        OAuth2AuthenticationManager oAuth2AuthenticationManager = new OAuth2AuthenticationManager();
        oAuth2AuthenticationManager.setTokenServices(resourceServerTokenServices());
        return oAuth2AuthenticationManager;
    }
}
