package com.fpmislata.spartanbank_service.business.domain;

/**
 *
 * @author PEDRO DEL BARRIO
 */
public class Usuario {

    private int idUsuario;
    private String nombre, encryptedPassword;
    private Rol rol;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nombre, String encryptedPassword, Rol rol) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.encryptedPassword = encryptedPassword;
        this.rol = rol;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

}
