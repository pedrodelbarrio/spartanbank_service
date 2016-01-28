package com.fpmislata.spartanbank_service.persistence.jdbc;

import javax.sql.DataSource;

/**
 *
 * @author PEDRO DEL BARRIO
 */
public interface DataSourceFactory {

    DataSource getDataSource();
}
