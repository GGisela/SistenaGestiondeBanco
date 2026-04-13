package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Cuenta objCuenta = new Cuenta("Cuenta Sueldo","calle falsa",161871681,22,0);
//
        System.out.println("---------------------------");

        Cuenta objCuenta2 = new Cuenta("Caja de ahorro en Pesos","Las flores 10",20202020,25,0);

        Cuenta objCuenta3= new Cuenta("Cuenta Corrinte","Av Avestruz 4",303030303,36,0);
//
        Cuenta objCuenta4 = new Cuenta("CAjade Ahorros","Piedras  20",40404040,44,0);
//
        System.out.println("---------------------------");
        Cuenta objCuenta5 = new Cuenta("Cuenta sueldo","La serena",50550550,55,0);
//
        System.out.println("---------------------------");
        Cuenta objCuenta6 = new Cuenta("Cuenta Sueldo","la Meduza",606060,68,0);
//
        System.out.println("---------------------------");

        System.out.println("---------------------------");


        System.out.printf("cuentas:" + objCuenta.tipoDeCuenta+ "Nro de Cuenta: " + objCuenta.direccion + "Direccion: " +objCuenta.direccion +
                "Saldo en Cuenta : " +objCuenta.saldo);

        System.out.printf("cuentas:" + objCuenta2.tipoDeCuenta+ "Nro de Cuenta: " + objCuenta2.direccion + "Direccion: " +objCuenta2.direccion +
                "Saldo en Cuenta : " +objCuenta2.saldo);

        System.out.printf("cuentas:" + objCuenta3.tipoDeCuenta+ "Nro de Cuenta: " + objCuenta3.direccion + "Direccion: " +objCuenta3.direccion +
                "Saldo en Cuenta : " +objCuenta3.saldo);

        System.out.printf("cuentas:" + objCuenta4.tipoDeCuenta+ "Nro de Cuenta: " + objCuenta4.direccion + "Direccion: " + objCuenta4.direccion +
                "Saldo en Cuenta : " +objCuenta4.saldo);

        System.out.printf("cuentas:" + objCuenta5.tipoDeCuenta+ "Nro de Cuenta: " + objCuenta5.direccion + "Direccion: " +objCuenta5.direccion +
                "Saldo en Cuenta : " +objCuenta5.saldo);

        System.out.printf("cuentas:" + objCuenta6.tipoDeCuenta+ "Nro de Cuenta: " + objCuenta6.direccion + "Direccion: " +objCuenta6.direccion +
                "Saldo en Cuenta : " +objCuenta6.saldo);

    }
}