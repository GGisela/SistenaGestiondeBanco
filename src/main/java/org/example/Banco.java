package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Banco {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in)  ;
        ArrayList<Cuenta> listaCuentas =new ArrayList<>();
        ArrayList<Sucursal> listSucursales=new ArrayList<>();
        int opcion=0;

          // Datos del Super Admin (Harcodeados por ahora)
        String superUser = "admin";
        String superPass = "123";

        // Sucursales precargadas
        listSucursales.add(new Sucursal("Sede Central", "Av. Rivadavia 100", "adminSede1", "pass1"));
        listSucursales.add(new Sucursal("Anexo Lanús", "9 de Julio 1200", "adminLanus", "pass2"));



        //inicio del sietema , valida credenciales para acceder
        //pantalla de incio *


            System.out.println("\n--SISTEMA BANCARIO ---");
            System.out.print("Usuario: ");
            String userIn = sc.nextLine();
            System.out.print("Password: ");
            String passIn = sc.nextLine();
            //------------------------------------------
            System.out.println("-------------------------------------------");


            boolean ejecutarSistema = true;
            while (ejecutarSistema) {
                System.out.println("\n------------------------------------------");
                System.out.println("   SISTEMA DE GESTION BANCARIA" );
                System.out.println("--------------------------------------");
                System.out.print("Usuario: ");
                String userIn = sc.nextLine();
                System.out.print("Password: ");
                String passIn = sc.nextLine();

                // --- NIVEL 1  SUPER ADMIN ---
                // Buscamos si es un Admin de Sucursal o un Usuario

                if (userIn.equals(superUser) && passIn.equals(superPass)) {
                        menuSuperAdmin(sc, listSucursales);
                    }
                    else {
                        // Buscamos si es un Admin de Sucursal o un Usuario
                        Sucursal sucursalLogueada = null;
                        Cuenta usuarioLogueado = null;

                        // Validamos Admin de Sucursal
                        for (Sucursal s : listSucursales) {
                            if (s.adminUser.equals(userIn) && s.adminPass.equals(passIn)) {
                                sucursalLogueada = s;
                                break;
                            }
                        }

                        // Validamos Usuario (Cliente) si no se encontró un admin
                        if (sucursalLogueada == null) {
                            for (Sucursal s : listSucursales) {
                                for (Cuenta c : s.listaCuentas) {
                                    if (c.usuario.equals(userIn) && c.pass.equals(passIn)) {
                                        usuarioLogueado = c;
                                        break;
                                    }
                                }
                            }
                        }

                        if (sucursalLogueada != null) {
                            menuAdminSucursal(sc, sucursalLogueada, listSucursales);
                        } else if (usuarioLogueado != null) {
                            menuUsuario(sc, usuarioLogueado, listSucursales);
                        } else {
                            System.out.println("Credenciales incorrectas. Intente de nuevo.");
                        }
                    }
                }
            }
//---------------------------- metodos de menus

    private static void menuSuperAdmin(Scanner sc, ArrayList<Sucursal> sucursales) {
        int op = 0;
        while (op != 3) {
            System.out.println("\n  Perfil:  SUPER ADMINISTRADOR ( BANCO )");
            System.out.println("1. Alta de Sucursal");
            System.out.println("2. Ver Reporte total del Banco");
            System.out.println("3. Cerrar Sesion");
            System.out.print("Seleccione una opcion : ");
            op = sc.nextInt(); sc.nextLine();

        switch (op) {
            case 1:
                System.out.print("Nombre de Sucursal: ");
                String nSuc = sc.nextLine();
                System.out.print("Direccion: ");
                System.out.print("User Admin Local: "); String u = sc.nextLine();
                System.out.print("Pass Admin Local: "); String p = sc.nextLine();
                sucursales.add(new Sucursal(n, d, u, p));
                System.out.println("Sucursal registrada con Correctamente");
                System.out.println("--------------------------");
                break;
            case 2:
                mostrarReporteGeneral(sucursales);
            break;

         }

       }
    }
    private static void menuAdminSucursal(Scanner sc, Sucursal miSucursal, ArrayList<Sucursal> todas) {
        int op = 0;

            while (op != 4) {
            System.out.println("\n----- Perfil: ADMIN SUCURSAL (" + miSucursal.nombreSucursal + ")");
                System.out.println("1. Alta de Cuenta (Cliente)");
                System.out.println("2. Cargar Saldo - DEPOSITAR");
                System.out.println("3. Lista de Clientes de mi Sucursal");
                System.out.println("4. Cerrar Sesión");
                op = sc.nextInt(); sc.nextLine();

                //---------------validamos si es +18 y se crea una cuenta
                if (op == 1) {
                    Cuenta nueva = new Cuenta();
                    System.out.print("Nombre Titular: "); nueva.nombreCliente = sc.nextLine();
                    System.out.print("Edad: "); nueva.edad = sc.nextInt(); sc.nextLine();
                    if (nueva.edad < 18) {
                        System.out.println("No se puede cargar cuenta , es menor de Edad");
                        continue;
                    }
                    System.out.print("Nro de Cuenta: "); nueva.numeroDeCuenta = sc.nextInt(); sc.nextLine();
                    System.out.print("Usuario para Login: "); nueva.usuario = sc.nextLine();
                    System.out.print("Password para Login: "); nueva.pass= sc.nextLine();
                    System.out.print("Ciudad: "); String city = sc.nextLine();
                    nueva.direccion = new Direccion("S/N", 0, city);
                    miSucursal.listaCuentas.add(nueva);
                    System.out.println("Cuenta creada exitosamente en " + miSucursal.nombreSucursal);
                } else if (op == 2) {

                }
        }
    }
}