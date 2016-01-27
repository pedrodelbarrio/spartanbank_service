package com.fpmislata.spartanbank_service.persistence.jdbc;

import java.sql.Connection;

/**
 *
 * @author PEDRO DEL BARRIO
 */
public interface ConnectionFactory {

    Connection getConnection();

    void closeConnection(Connection connection);
}
