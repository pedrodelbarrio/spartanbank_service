package com.fpmislata.spartanbank_service.persistence.jdbc.impl;

import com.fpmislata.spartanbank_service.persistence.jdbc.ConnectionFactory;
import com.fpmislata.spartanbank_service.persistence.jdbc.DataSourceFactory;
import java.sql.Connection;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author PEDRO DEL BARRIO
 */
public class ConnectionFactoryImplDataSource implements ConnectionFactory {

    @Autowired
    private DataSourceFactory dataSourceFactory;

    @Override
    public Connection getConnection() {
        try {
            DataSource dataSource = dataSourceFactory.getDataSource();
            return dataSource.getConnection();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
