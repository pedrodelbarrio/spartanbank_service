package com.fpmislata.spartanbank_service.security;

/**
 *
 * @author PEDRO DEL BARRIO
 */
public interface PasswordManager {

    String encrypt(String plain);

    boolean check(String inputPassword, String encryptedPassword);

}
