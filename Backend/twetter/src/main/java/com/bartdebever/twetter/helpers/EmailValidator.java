package com.bartdebever.twetter.helpers;

import com.bartdebever.twetter.helpers.interfaces.IEmailValidator;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class EmailValidator implements IEmailValidator {

    @Override
    public boolean validateEmail(String email) {
        // Framework doesn't do this so guess we do now..
        if(CSharp.isNullOrWhitespace(email)) {
            return false;
        }

        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            return false;
        }

        return true;
    }
}
