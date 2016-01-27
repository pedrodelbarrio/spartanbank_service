package com.fpmislata.spartanbank_service.business.domain;

import java.util.Date;

/**
 *
 * @author PEDRO DEL BARRIO
 */
public class EntidadBancaria {

    private int idEntidadBancaria;
    private String nombre, codigoEntidad, direccion, cif;
    private Date fechaCreacion;

    public EntidadBancaria() {
    }

    public EntidadBancaria(int idEntidadBancaria, String nombre, String codigoEntidad, String direccion, String cif, Date fechaCreacion) {
        this.idEntidadBancaria = idEntidadBancaria;
        this.nombre = nombre;
        this.codigoEntidad = codigoEntidad;
        this.direccion = direccion;
        this.cif = cif;
        this.fechaCreacion = fechaCreacion;
    }

    public int getIdEntidadBancaria() {
        return idEntidadBancaria;
    }

    public void setIdEntidadBancaria(int idEntidadBancaria) {
        this.idEntidadBancaria = idEntidadBancaria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoEntidad() {
        return codigoEntidad;
    }

    public void setCodigoEntidad(String codigoEntidad) {
        this.codigoEntidad = codigoEntidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

}
