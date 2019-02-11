package com.bartdebever.twetter.helpers;

import com.bartdebever.twetter.beans.interfaces.IUserBean;
import com.bartdebever.twetter.helpers.interfaces.IJwtTokenGenerator;
import com.bartdebever.twetter.helpers.interfaces.IUserAuthHelper;
import com.bartdebever.twetter.models.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserAuthHelper implements IUserAuthHelper {

    @Autowired
    private IUserBean userBean;

    @Autowired
    private IJwtTokenGenerator tokenGenerator;

    public User getUserByToken(String token) {
        String id = tokenGenerator.verifyToken(token);
        int idInt = Integer.parseInt(id);

        return userBean.getUser(idInt);
    }
}
