package com.bartdebever.twetter.beans;

import com.bartdebever.twetter.beans.interfaces.IRoleBean;
import com.bartdebever.twetter.beans.interfaces.ITwitBean;
import com.bartdebever.twetter.beans.interfaces.IUserBean;
import com.bartdebever.twetter.beans.local.LocalRoleBean;
import com.bartdebever.twetter.beans.local.LocalTwitBean;
import com.bartdebever.twetter.beans.local.LocalUserBean;
import com.bartdebever.twetter.helpers.JwtTokenGenerator;
import com.bartdebever.twetter.helpers.interfaces.IJwtTokenGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Class used to configure Beans so that Spring can implement them in the right methods.
 */
@Configuration
public class BeanConfiguration {
    @Bean
    public IUserBean userBean() {
        return new LocalUserBean();
    }

    @Bean
    public ITwitBean twitBean() {
        return new LocalTwitBean();
    }

    @Bean
    public IRoleBean roleBean() {
        return new LocalRoleBean();
    }

    @Bean
    public IJwtTokenGenerator tokenGenerator() {
        return new JwtTokenGenerator();
    }
}
