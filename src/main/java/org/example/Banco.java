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
            System.out.println("-------------------------------------------");
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
                    System.out.print("Ciudad: ");
                    String ciudad = sc.nextLine();

                    System.out.print("Nro de cuenta : ");
                    int nro = sc.nextInt();
                    sc.nextLine();//limpiar bu

                    Cuenta nuevoCta = new Cuenta();
                    nuevoCta.nombreCliente = nom;
                    nuevoCta.numeroDeCuenta = nro;
                    nuevoCta.edad = edad;
                    nuevoCta.direccion = new Direccion (calle, altura, ciudad);

                    listaCuentas.add(nuevoCta);
                    System.out.println("Cuenta creada .");
                    System.out.println("-------------------------------------------");

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
                if(c.numeroDeCuenta ==ctaBuscar) {
                    c.saldo += monto;
                    System.out.println("Saldo actualizado: $" + c.saldo);
                    System.out.println("-------------------------------------------");
                }
            }
            break;

            case 4:
                System.out.print("Nro Cuenta Origen: ");
                int origenID = sc.nextInt();
                System.out.print("Nro Cuenta Destino: ");
                int destinoID = sc.nextInt();
                System.out.print("Monto a Transferir: ");
                double montoTrans = sc.nextDouble();

                Cuenta cOrigen = null, cDestino = null;
                for (Cuenta c : listaCuentas) {
                    if (c.numeroDeCuenta == origenID) cOrigen = c;
                    if (c.numeroDeCuenta == destinoID) cDestino = c;
                }

                if (cOrigen != null && cDestino != null) {
                    Trasferencias.ejecutar(cOrigen, cDestino, montoTrans);
                } else {
                    System.out.println("Una o ambas cuentas no existen.");
                }
                break;

            case 5:
                if (listSucursales.isEmpty()) {
                    System.out.println("No hay sucursales físicas registradas.");
                } else {
                    System.out.print("Nro de Cuenta para retiro: ");
                    int ctaRetiroID = sc.nextInt();
                    System.out.print("Monto a Retirar: ");
                    double retiro = sc.nextDouble();

                    for (Cuenta c : listaCuentas) {
                        if (c.numeroDeCuenta == ctaRetiroID) {
                            if (c.saldo >= retiro) {
                                c.saldo -= retiro;
                                System.out.println("Retiro exitoso de la sucursal. Nuevo saldo: $" + c.saldo);
                                System.out.println("-------------------------------------------");
                            } else {
                                System.out.println("Saldo insuficiente.");
                                System.out.println("-------------------------------------------");
                            }
                        }
                    }
                }
                break;


                //esta parte hace el balance total y muestra la info general cargada
            case 7:
                System.out.println("\n--REPORTE GENERAL DEL BANCO--- ");

                // --- Sucursales
                System.out.println("\n[Sucursales Fisicas]");
                if (listSucursales.isEmpty()) {
                    System.out.println("No hay sucursales registradas");
                } else {
                    for (Sucursal s : listSucursales) {
                        System.out.println(" > " + s.nombreSucursal + " (Dir: " + s.direccionFisica + ")");
                    }
                }

                //  MUESTRA CUENTAS Y BALANCE !
                System.out.println("\n Estado de Cuentas :");
                if (listaCuentas.isEmpty()) {
                    System.out.println("No hay cuentas registradas");
                } else {

                    double saldoTotalBanco = 0; // Variable para sumarlo todo

                    System.out.printf("%-15s | %-10s | %-20s | %-10s%n", "TITULAR", "CUENTA", "CIUDAD", "SALDO");
                    System.out.println("----------------------------------------------------------------------");

                    for (Cuenta c : listaCuentas) {
                        // Navegamos EL OBJETO DIRECION  Cuenta -> Direccion -> Ciudad
                        System.out.printf("%-15s | %-10d | %-20s | $%.2f%n",
                                c.nombreCliente,
                                c.numeroDeCuenta,
                                c.direccion.ciudad,
                                c.saldo);

                        saldoTotalBanco += c.saldo; // Acumulamos el saldo de cada cuenta
                    }

                    System.out.println("----------------------------------------------------------------------");
                    System.out.printf("TOTAL DINERO EN BANCO: $%.2f%n", saldoTotalBanco);
                    //System.out.println("CANTIDAD DE CLIENTES: " + listaCuentas.size());
                }
                System.out.println("=-------------------------------\n");
                break;

        }

    }

    }
}