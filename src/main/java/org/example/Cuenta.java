package org.example;

public class Cuenta {
    //atributos de las cuentas

    public int numeroDeCuenta;
    public String tipoDeCuenta; //corriente, sueldo, caja de ahorro
    public String direccion;
    public  double saldo;
    public int edad;// hacer un if mayor de 18

//el constructor
    public Cuenta(String tipoDeCuenta,String direccion,int numeroDeCuenta,int edad,double saldo){
        this.edad=edad;
        this.saldo=0;
        this.numeroDeCuenta=numeroDeCuenta;
        this.direccion=direccion;
        this.edad=edad;

    }

}
