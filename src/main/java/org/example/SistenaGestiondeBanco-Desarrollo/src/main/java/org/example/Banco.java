package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Banco {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in)  ;
        ArrayList<Cuenta> listaCuentas =new ArrayList<>();
        ArrayList<Sucursal> listSucursales=new ArrayList<>();
        int opcion=0;

        //se crea menu para el admin
        while (opcion!=6){

            System.out.println("\n---MENU DEL ADMINISTRADOR---");
            System.out.println("-1.Agrega Sucursal");
            System.out.println("-2.Alta de cliente (saldo 0)");
            System.out.println("-3.Carga saldo(Deposito)");
            System.out.println("-4.Trasferencias entre cuentas ");
            System.out.println("-5.Retiro por cajero(Sucursal) ");
            System.out.println("-6.Salir ");
            System.out.println("Seleccione una Opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            //Ingreso de datos --------------------------------------------------------

        switch (opcion) {
            case 1:
                System.out.print("Nombre de Sucursal: ");
                String nSuc = sc.nextLine();
                System.out.print("Direccion: ");
                String dSuc = sc.nextLine();
                listSucursales.add(new Sucursal(nSuc, dSuc));
                System.out.printf("sucursal agregada .");
                break;
            case 2:
                System.out.print("Nombre de Cliente: ");
                String nom = sc.nextLine();
                System.out.print("Edad: ");
                int edad = sc.nextInt();
                sc.nextLine();

                if (edad >= 18) {
                    System.out.println(" Ingrese Direcion del cliente");
                    System.out.print("Calle : ");
                    String calle = sc.nextLine();
                    System.out.print("Altura: ");
                    int altura = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nro de cuenta : ");
                    int nro = sc.nextInt();
                    sc.nextLine();//limpiar bu

                    Cuenta nuevoCta = new Cuenta();
                    nuevoCta.nombreCliente = nom;
                    nuevoCta.numeroDeCuenta = nro;

                    listaCuentas.add(nuevoCta);

                } else {
                    System.out.print("Menor de Edad, NO SE PUEDE CREAR UNA CUENTA X ");

            }
            break;

        case 3:
            //se le agrega saldo manuelmente
            System.out.print("Nro de Cuenta a Cargar :");
             int ctaBuscar =sc.nextInt();
            System.out.print("ingrese el monto a Depositar: ");
            double monto =sc.nextDouble();

            for (Cuenta c : listaCuentas){
                if(c.numeroDeCuenta ==ctaBuscar) c.saldo += monto;
            }
            break;

            case 4 :

                //retiro de sucursal fisicamente
                if(listSucursales.isEmpty()) {
                    System.out.println("No hay sucursales Fisicas Registradas");

                }else {
                    System.out.printf(" Monto a Retirar: ");
                    double retiro =sc.nextDouble();
                    //agregar logica de resta
                }
                break;

        }

    }

    }
}