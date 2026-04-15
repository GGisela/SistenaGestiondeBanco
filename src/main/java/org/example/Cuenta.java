package org.example;

public class Cuenta {
    //atributos de las cuentas

    public String nombreCliente;//
    public String tipoDeCuenta; //corriente, sueldo, caja de ahorro
    public int numeroDeCuenta;
    public  String  email;
    public  double saldo;
    public int edad;// hacer un if mayor de 18
    public Direccion direccion;// Usamos el objeto Direccion
    public String usuario;      //  para login del cliente
    public String pass;     //  para login del cliente

    //el constructor
    public Cuenta (){
        this.saldo= 0.0;


        }

    }

