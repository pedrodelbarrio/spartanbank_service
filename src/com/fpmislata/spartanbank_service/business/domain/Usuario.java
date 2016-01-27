package com.fpmislata.spartanbank_service.business.domain;

/**
 *
 * @author PEDRO DEL BARRIO
 */
public class Usuario {

    private int idUsuario;
    private String nickName, encryptedPassword, nombre, nif, email;
    private Rol rol;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nickName, String encryptedPassword, String nombre, String nif, String email, Rol rol) {
        this.idUsuario = idUsuario;
        this.nickName = nickName;
        this.encryptedPassword = encryptedPassword;
        this.nombre = nombre;
        this.nif = nif;
        this.email = email;
        this.rol = rol;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

}
