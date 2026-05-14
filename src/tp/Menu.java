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

    private void menuVehiculos() {
        System.out.println("\n[Submenu 2 - Vehiculos] (pendiente)");
    }

    private void menuPuntos() {
        System.out.println("\n[Submenu 3 - Puntos] (pendiente)");
    }

    private void menuRepartidor() {
        System.out.println("\n[Submenu 4 - Repartidor] (pendiente)");
    }
}