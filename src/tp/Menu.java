package tp;

import java.util.Scanner;

public class Menu {

    private Paquete[] paquetes = new Paquete[10];
    private Vehiculo[] vehiculos = new Vehiculo[5];
    private PuntoDeDistribucion[] puntos = new PuntoDeDistribucion[10];

    private int cantPaquetes = 0;
    private int cantVehiculos = 0;
    private int cantPuntos = 0;

    //cuando inicializemos la partida, cargamos a Sam
    private Repartidor sam = null;

    private Scanner sc = new Scanner(System.in);

    //=================MENU PRINCIPAL===========================
    public void ejecutar() {
        int op;

        do {
            mostrarMenuPrincipal();
            System.out.print("Opcion: ");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    menuPaquetes();
                    break;
                case 2:
                    menuVehiculos();
                    break;
                case 3:
                    menuPuntos();
                    break;
                case 4:
                    menuRepartidor();
                    break;
                case 0:
                    System.out.println("Saliendo del juego...");
                    break;
                default:
                    System.out.println("Opcion invalida.");
                    break;
            }

            if (op != 0) {
                System.out.println("\nEnter para continuar...");
                sc.nextLine();
            }

        } while (op != 0);
    }

    private void mostrarMenuPrincipal() {
        System.out.println("\n=== SISTEMA DE DISTRIBUCION BRIDGES ===");
        System.out.println("1. Gestion de paquetes");
        System.out.println("2. Gestion de vehiculos");
        System.out.println("3. Gestion de puntos de distribucion");
        System.out.println("4. Repartidor");
        System.out.println("0. Salir");
    }

    //=================SUB-MENU N°1: PAQUETES===========================
    private void menuPaquetes() {
        int op;

        do {
            System.out.println("\n=== Submenu 1 - Gestion de paquetes ===");
            System.out.println("1. Registrar paquete");
            System.out.println("2. Clonar paquete");
            System.out.println("3. Listar paquetes");
            System.out.println("4. Ordenar por prioridad");
            System.out.println("0. Volver");
            System.out.print("Opcion: ");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    registrarPaquete();
                    break;
                case 2:
                    clonarPaquete();
                    break;
                case 3:
                    listarPaquetes();
                    break;
                case 4:
                    ordenarPaquetesPorPrioridad();
                    break;
                case 0:
                    System.out.println("Volviendo...");
                    break;
                default:
                    System.out.println("Opcion invalida.");
                    break;
            }

            if (op != 0) {
                System.out.println("\nEnter para continuar...");
                sc.nextLine();
            }

        } while (op != 0);
    }

    //MÉTODOS DE SUB-MENU 1:

    private void registrarPaquete() {
        if (cantPaquetes >= paquetes.length) {
            System.out.println("No se pueden registrar mas paquetes (sistema lleno).");
            return;
        }
        System.out.print("ID: ");
        String id = sc.nextLine();

        System.out.print("Descripcion: ");
        String descripcion = sc.nextLine();

        System.out.print("Peso (kg): ");
        double peso = sc.nextDouble();
        sc.nextLine(); // limpiar Enter

        if (peso <= 0) {
            System.out.println("Peso invalido. Debe ser mayor a 0.");
            return;
        }

        System.out.print("Es urgente? (1=si, 0=no): ");
        int urg = sc.nextInt();
        sc.nextLine(); // limpiar Enter

        boolean urgente = (urg == 1);

        Paquete p = new Paquete(id, descripcion, peso, urgente);
        paquetes[cantPaquetes] = p;
        cantPaquetes++;

        System.out.println("Paquete registrado.");
    }

    private void listarPaquetes() {
        if (cantPaquetes == 0) {
            System.out.println("No hay paquetes registrados.");
            return;
        }

        System.out.println("\n--- Lista de paquetes ---");
        for (int i = 0; i < cantPaquetes; i++) {
            System.out.println((i + 1) + ") " + paquetes[i]);
        }
    }


    private void clonarPaquete() {
        if (cantPaquetes == 0) {
            System.out.println("No hay paquetes para clonar.");
            return;
        }
        if (cantPaquetes >= paquetes.length) {
            System.out.println("No se pueden agregar mas paquetes (sistema lleno).");
            return;
        }

        listarPaquetes();
        System.out.print("Elegí numero de paquete a clonar: ");
        int nroElegido = sc.nextInt();
        sc.nextLine();

        int indicePaquete = nro - 1;
        if (indicePaquete < 0 || indicePaquete >= cantPaquetes) {
            System.out.println("Numero invalido, fuera de rango.");
            return;
        }

        Paquete copia = (Paquete) paquetes[indicePaquete].clone();

        System.out.print("Nuevo ID para el clon: ");
        String nuevoId = sc.nextLine();

        copia.setId(nuevoId);

        paquetes[cantPaquetes] = copia;
        cantPaquetes++;

        System.out.println("Paquete clonado y agregado.");
    }


    private void ordenarPaquetesPorPrioridad() {
        if (cantPaquetes == 0) {
            System.out.println("No hay paquetes para ordenar.");
            return;
        }

        for (int i = 0; i < cantPaquetes - 1; i++) {
            for (int j = 0; j < cantPaquetes - 1; j++) {
                if (paquetes[j].compareTo(paquetes[j + 1]) > 0) {
                    Paquete aux = paquetes[j];
                    paquetes[j] = paquetes[j + 1];
                    paquetes[j + 1] = aux;
                }
            }
        }

        System.out.println("Paquetes ordenados por prioridad.");
        listarPaquetes();
    }


    //=================SUB-MENU N°2: VEHICULOS===========================
    //MÉTODOS DE SUB-MENU 2:

    private void menuVehiculos() {
        System.out.println("\n[Submenu 2 - Vehiculos] (pendiente)");
    }

    //=================SUB-MENU N°3: PUNTOS DE DISTRIBUCION===========================
    //MÉTODOS DE SUB-MENU 3:
    private void menuPuntos() {
        System.out.println("\n[Submenu 3 - Puntos] (pendiente)");
    }

    //=================SUB-MENU N°4: REPARTIDOR===========================
    //MÉTODOS DE SUB-MENU 4:
    private void menuRepartidor() {
        System.out.println("\n[Submenu 4 - Repartidor] (pendiente)");
    }
}