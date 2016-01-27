package com.fpmislata.spartanbank_service.persistence.dao;

import java.util.List;

/**
 *
 * @author PEDRO DEL BARRIO
 */
public interface GenericDAO<T> {

    T get(int id);

    T insert(T t);

    T update(T t);

    boolean delete(int id);

    List<T> findAll();
}
