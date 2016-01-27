package com.fpmislata.spartanbank_service.business.service.impl;

import com.fpmislata.spartanbank_service.business.domain.EntidadBancaria;
import com.fpmislata.spartanbank_service.business.service.EntidadBancariaService;
import com.fpmislata.spartanbank_service.persistence.dao.EntidadBancariaDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author PEDRO DEL BARRIO
 */
public class EntidadBancariaServiceImpl implements EntidadBancariaService {

    @Autowired
    private EntidadBancariaDAO entidadBancariaDAO;

    @Override
    public EntidadBancaria get(int id) {
        return entidadBancariaDAO.get(id);
    }

    @Override
    public EntidadBancaria insert(EntidadBancaria entidadBancaria) {
        return entidadBancariaDAO.insert(entidadBancaria);
    }

    @Override
    public EntidadBancaria update(EntidadBancaria entidadBancaria) {
        return entidadBancariaDAO.update(entidadBancaria);
    }

    @Override
    public boolean delete(int id) {
        return entidadBancariaDAO.delete(id);
    }

    @Override
    public List<EntidadBancaria> findAll() {
        return entidadBancariaDAO.findAll();
    }

    @Override
    public List<EntidadBancaria> findByNombre(String nombre) {
        return entidadBancariaDAO.findByNombre(nombre);
    }

}
