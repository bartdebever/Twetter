package com.bartdebever.twetter.beans;

import com.bartdebever.twetter.helpers.JwtTokenGenerator;
import com.bartdebever.twetter.helpers.UserAuthHelper;
import com.bartdebever.twetter.helpers.interfaces.IJwtTokenGenerator;
import com.bartdebever.twetter.helpers.interfaces.IUserAuthHelper;
import com.bartdebever.twetter.services.Local.LocalRoleService;
import com.bartdebever.twetter.services.Local.LocalTwitService;
import com.bartdebever.twetter.services.UserService;
import com.bartdebever.twetter.services.interfaces.IRoleService;
import com.bartdebever.twetter.services.interfaces.ITwitService;
import com.bartdebever.twetter.services.interfaces.IUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Class used to configure Beans so that Spring can implement them in the right methods.
 */
@Configuration
public class BeanConfiguration {

    @Bean
    public IRoleService roleService() {
        return new LocalRoleService();
    }

    @Bean
    public ITwitService twitService() {
        return new LocalTwitService();
    }

    @Bean
    public IUserService userService(){
        return new UserService();
    }

    @Bean
    public IJwtTokenGenerator tokenGenerator() {
        return new JwtTokenGenerator();
    }

    @Bean
    public IUserAuthHelper userAuthHelper() {
        return new UserAuthHelper();
    }
}
