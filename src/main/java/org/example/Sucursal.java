package org.example;

import java.util.ArrayList;

public class Sucursal {

    public String nombreSucursal;
    public String direccionFisica;
    public String adminUser;     // Credenciales del admin de esta sucursal
    public String adminPass;
    public ArrayList<Cuenta> listaCuentas; // Las cuentas pertenecen a la sucursal

    public Sucursal(String nombre, String direccion, String adminUser, String adminPass) {
        this.nombreSucursal = nombre;
        this.direccionFisica = direccion;
        this.adminUser = adminUser;
        this.adminPass = adminPass;
        this.listaCuentas = new ArrayList<>();

    }
}
