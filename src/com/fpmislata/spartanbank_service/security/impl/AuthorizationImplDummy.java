package com.fpmislata.spartanbank_service.security.impl;

import com.fpmislata.spartanbank_service.business.domain.Usuario;
import com.fpmislata.spartanbank_service.security.Authorization;

/**
 *
 * @author PEDRO DEL BARRIO
 */
public class AuthorizationImplDummy implements Authorization {

    @Override
    public boolean isAuthorizedURL(Usuario usuario, String url, String metodo) {
        return true;
    }

}
