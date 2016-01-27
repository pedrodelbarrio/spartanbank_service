package com.fpmislata.spartanbank_service.security.impl;

import com.fpmislata.spartanbank_service.security.PasswordManager;
import org.jasypt.util.password.StrongPasswordEncryptor;

/**
 *
 * @author PEDRO DEL BARRIO
 */
public class PasswordManagerImplJasypt implements PasswordManager {

    private StrongPasswordEncryptor strongPasswordEncryptor = new StrongPasswordEncryptor();

    @Override
    public String encrypt(String plain) {
        return strongPasswordEncryptor.encryptPassword(plain);
    }

    @Override
    public boolean check(String inputPassword, String encryptedPassword) {
        return strongPasswordEncryptor.checkPassword(inputPassword, encryptedPassword);
    }

}
