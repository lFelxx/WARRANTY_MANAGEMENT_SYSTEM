
package com.mycompany.models;


public class Users {
    private String id_users;
    private String name;
    private String apellido_p;
    private String apellido_m;
    private String direccion;
    private String telefono;

    public void setId_users(String id_users) {
        this.id_users = id_users;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setApellido_p(String apellido_p) {
        this.apellido_p = apellido_p;
    }

    public void setApellido_m(String apellido_m) {
        this.apellido_m = apellido_m;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getId_users() {
        return id_users;
    }

    public String getName() {
        return name;
    }

    public String getApellido_p() {
        return apellido_p;
    }

    public String getApellido_m() {
        return apellido_m;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }
    
}
