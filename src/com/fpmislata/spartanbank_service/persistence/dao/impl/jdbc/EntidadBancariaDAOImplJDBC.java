package com.fpmislata.spartanbank_service.persistence.dao.impl.jdbc;

import com.fpmislata.spartanbank_service.business.domain.EntidadBancaria;
import com.fpmislata.spartanbank_service.persistence.dao.EntidadBancariaDAO;
import com.fpmislata.spartanbank_service.persistence.jdbc.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author PEDRO DEL BARRIO
 */
public class EntidadBancariaDAOImplJDBC implements EntidadBancariaDAO {

    @Autowired
    private ConnectionFactory connectionFactory;

    @Override
    public EntidadBancaria get(int idEntidadBancaria) {
        try {
            EntidadBancaria entidadBancaria;
            Connection connection = connectionFactory.getConnection();
            String sql = "SELECT * FROM entidadbancaria WHERE idEntidadBancaria=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idEntidadBancaria);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                entidadBancaria = new EntidadBancaria();
                entidadBancaria.setIdEntidadBancaria(resultSet.getInt("idEntidadBancaria"));
                entidadBancaria.setNombre(resultSet.getString("nombre"));
                entidadBancaria.setCodigoEntidad(resultSet.getString("codigoEntidad"));
                entidadBancaria.setFechaCreacion(resultSet.getDate("fechaCreacion"));
                entidadBancaria.setDireccion(resultSet.getString("direccion"));
                entidadBancaria.setCif(resultSet.getString("cif"));
            } else {
                entidadBancaria = null;
            }
            if (resultSet.next()) {
                throw new RuntimeException("Demasiadas filas devueltas");
            } else {
                //No tengo que hacer nada
            }

            preparedStatement.close();
            connectionFactory.closeConnection(connection);
            return entidadBancaria;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public EntidadBancaria insert(EntidadBancaria entidadBancaria) {
        try {
            EntidadBancaria entidadBancariaInsertada;
            Connection connection = connectionFactory.getConnection();
            String sql = "INSERT INTO entidadbancaria(nombre, codigoEntidad, fechaCreacion, direccion, cif) VALUES(?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, entidadBancaria.getNombre());
            preparedStatement.setString(2, entidadBancaria.getCodigoEntidad());
            if (entidadBancaria.getFechaCreacion() == null) {
                preparedStatement.setDate(3, null);
            } else {
                preparedStatement.setDate(3, new java.sql.Date(entidadBancaria.getFechaCreacion().getTime()));
            }
            preparedStatement.setString(4, entidadBancaria.getDireccion());
            preparedStatement.setString(5, entidadBancaria.getCif());
            int numFilasInsertadas = preparedStatement.executeUpdate();

            if (numFilasInsertadas == 0) {
                throw new RuntimeException("0 filas insertadas");
            } else if (numFilasInsertadas == 1) {
                ResultSet resultSetGeneratedKeys = preparedStatement.getGeneratedKeys();

                if (resultSetGeneratedKeys.next()) {
                    int idEntidadBancariaInsertada = resultSetGeneratedKeys.getInt(1);
                    entidadBancariaInsertada = this.get(idEntidadBancariaInsertada);
                } else {
                    throw new RuntimeException();
                }
            } else if (numFilasInsertadas > 1) {
                throw new RuntimeException("Demasiadas filas insertadas: " + numFilasInsertadas);
            } else {
                throw new RuntimeException("Soy un paranoico: " + numFilasInsertadas);
            }

            preparedStatement.close();
            connectionFactory.closeConnection(connection);
            return entidadBancariaInsertada;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public EntidadBancaria update(EntidadBancaria entidadBancaria) {
        try {
            EntidadBancaria entidadBancariaActualizada;
            Connection connection = connectionFactory.getConnection();
            String sql = "UPDATE entidadbancaria SET nombre=?, codigoEntidad=?, fechaCreacion=?, direccion=?, cif=? WHERE idEntidadBancaria=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, entidadBancaria.getNombre());
            preparedStatement.setString(2, entidadBancaria.getCodigoEntidad());
            if (entidadBancaria.getFechaCreacion() == null) {
                preparedStatement.setDate(3, null);
            } else {
                preparedStatement.setDate(3, new java.sql.Date(entidadBancaria.getFechaCreacion().getTime()));
            }
            preparedStatement.setString(4, entidadBancaria.getDireccion());
            preparedStatement.setString(5, entidadBancaria.getCif());
            preparedStatement.setInt(6, entidadBancaria.getIdEntidadBancaria());
            int numFilasActualizadas = preparedStatement.executeUpdate();

            if (numFilasActualizadas == 0) {
                throw new RuntimeException("0 filas actualizadas");
            } else if (numFilasActualizadas == 1) {
                entidadBancariaActualizada = this.get(entidadBancaria.getIdEntidadBancaria());
            } else if (numFilasActualizadas > 1) {
                throw new RuntimeException("Demasiadas filas actualizadas: " + numFilasActualizadas);
            } else {
                throw new RuntimeException("Soy un paranoico: " + numFilasActualizadas);
            }

            preparedStatement.close();
            connectionFactory.closeConnection(connection);
            return entidadBancariaActualizada;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public boolean delete(int idEntidadBancaria) {
        try {
            Connection connection = connectionFactory.getConnection();
            String sql = "DELETE FROM entidadbancaria WHERE idEntidadBancaria=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idEntidadBancaria);
            int numFilasBorradas = preparedStatement.executeUpdate();

            preparedStatement.close();
            connectionFactory.closeConnection(connection);

            if (numFilasBorradas == 0) {
                return false;
            } else if (numFilasBorradas == 1) {
                return true;
            } else if (numFilasBorradas > 1) {
                throw new RuntimeException("Demasiadas filas borradas: " + numFilasBorradas);
            } else {
                throw new RuntimeException("Soy un paranoico: " + numFilasBorradas);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<EntidadBancaria> findAll() {
        try {
            List<EntidadBancaria> entidadesBancarias = new ArrayList<>();
            Connection connection = connectionFactory.getConnection();
            String sql = "SELECT * FROM entidadbancaria";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                EntidadBancaria entidadBancaria = new EntidadBancaria();
                entidadBancaria.setIdEntidadBancaria(resultSet.getInt("idEntidadBancaria"));
                entidadBancaria.setNombre(resultSet.getString("nombre"));
                entidadBancaria.setCodigoEntidad(resultSet.getString("codigoEntidad"));
                entidadBancaria.setFechaCreacion(resultSet.getDate("fechaCreacion"));
                entidadBancaria.setDireccion(resultSet.getString("direccion"));
                entidadBancaria.setCif(resultSet.getString("cif"));
                entidadesBancarias.add(entidadBancaria);
            }

            preparedStatement.close();
            connectionFactory.closeConnection(connection);
            return entidadesBancarias;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<EntidadBancaria> findByNombre(String nombre) {
        try {
            List<EntidadBancaria> entidadesBancarias = new ArrayList<>();
            Connection connection = connectionFactory.getConnection();
            String sql = "SELECT * FROM entidadbancaria WHERE nombre=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nombre);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                EntidadBancaria entidadBancaria = new EntidadBancaria();
                entidadBancaria.setIdEntidadBancaria(resultSet.getInt("idEntidadBancaria"));
                entidadBancaria.setNombre(resultSet.getString("nombre"));
                entidadBancaria.setCodigoEntidad(resultSet.getString("codigoEntidad"));
                entidadBancaria.setFechaCreacion(resultSet.getDate("fechaCreacion"));
                entidadBancaria.setDireccion(resultSet.getString("direccion"));
                entidadBancaria.setCif(resultSet.getString("cif"));
                entidadesBancarias.add(entidadBancaria);
            }

            preparedStatement.close();
            connectionFactory.closeConnection(connection);
            return entidadesBancarias;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
