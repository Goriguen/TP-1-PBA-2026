package tp;

import java.util.Scanner;

public class Menu {

    private Paquete[] paquetes = new Paquete[10];
    private Vehiculo[] vehiculos = new Vehiculo[5];
    private PuntoDeDistribucion[] puntos = new PuntoDeDistribucion[10];

    private int cantPaquetes = 0;
    private int cantVehiculos = 0;
    private int cantPuntos = 0;

    private Repartidor sam;

    private Scanner sc = new Scanner(System.in);

    //=================MENU PRINCIPAL===========================
    public void ejecutar() {

        if (sam == null) {
            PuntoDeDistribucion inicio = new PuntoDeDistribucion("Central", 0, 0);
            sam = new Repartidor("Sam", 20.0, inicio, null);
        }

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
        int nro = sc.nextInt();
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
    private void menuVehiculos() {
        int op;

        do {
            System.out.println("\n=== Submenu 2 - Gestion de vehiculos ===");
            System.out.println("1. Registrar vehiculo");
            System.out.println("2. Listar vehiculos");
            System.out.println("0. Volver");
            System.out.print("Opcion: ");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    registrarVehiculo();
                    break;
                case 2:
                    listarVehiculos();
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

    //MÉTODOS DE SUB-MENU 2:

    private void registrarVehiculo() {
        if (cantVehiculos >= vehiculos.length) {
            System.out.println("No se pueden registrar mas vehiculos (sistema lleno).");
            return;
        }

        System.out.println("\n--- Registrar vehiculo ---");
        System.out.println("1. Moto");
        System.out.println("2. Camion");
        System.out.print("Tipo: ");
        int tipo = sc.nextInt();
        sc.nextLine();

        System.out.print("ID: ");
        String id = sc.nextLine();

        System.out.print("Capacidad de carga (Kg): ");
        double capacidad = sc.nextDouble();
        sc.nextLine();

        if (capacidad <= 0) {
            System.out.println("Capacidad invalida. Debe ser mayor a 0.");
            return;
        }

        if (tipo == 1) {
            vehiculos[cantVehiculos] = new Moto(id, capacidad);
            cantVehiculos++;
            System.out.println("Moto registrada.");
        } else if (tipo == 2) {
            System.out.print("Tiene remolque? (1=si, 0=no): ");
            int rem = sc.nextInt();
            sc.nextLine();

            boolean tieneRemolque;
            if (rem == 1) {
                tieneRemolque = true;
            } else if (rem == 0) {
                tieneRemolque = false;
            } else {
                System.out.println("Opcion invalida. Debe ser 1 o 0.");
                return;
            }

            vehiculos[cantVehiculos] = new Camion(tieneRemolque, id, capacidad);
            cantVehiculos++;
            System.out.println("Camion registrado.");
        } else {
            System.out.println("Tipo invalido. No se registro el vehiculo.");
        }
    }

    private void listarVehiculos() {
        if (cantVehiculos == 0) {
            System.out.println("No hay vehiculos registrados.");
            return;
        }

        System.out.println("\n--- Lista de vehiculos ---");
        for (int i = 0; i < cantVehiculos; i++) {
            Vehiculo v = vehiculos[i];

            // acá se demuestra el polimorfismo:
            // recorremos como Vehiculo[] y llamamos descripcionTipo() en cada uno.
            System.out.println((i + 1) + ") " + v.descripcionTipo() + " --> " + v.toString());
        }
    }

    //=================SUB-MENU N°3: PUNTOS DE DISTRIBUCION===========================
    private void menuPuntos() {
        int op;

        do {
            System.out.println("\n=== Submenu 3 - Gestion de puntos de distribucion ===");
            System.out.println("1. Registrar punto");
            System.out.println("2. Conectar todos los puntos");
            System.out.println("3. Ver estado de la red");
            System.out.println("0. Volver");
            System.out.print("Opcion: ");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1: registrarPunto();
                    break;
                case 2: conectarTodosLosPuntos();
                    break;
                case 3: verEstadoDeLaRed();
                    break;
                case 0: System.out.println("Volviendo...");
                    break;
                default: System.out.println("Opcion invalida.");
                    break;
            }

            if (op != 0) {
                System.out.println("\nEnter para continuar...");
                sc.nextLine();
            }

        } while (op != 0);
    }

    //MÉTODOS DE SUB-MENU 3:

    private void registrarPunto() {
        if (cantPuntos >= puntos.length) {
            System.out.println("No se pueden registrar mas puntos (sistema lleno).");
            return;
        }

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        if (nombre.trim().isEmpty()) {
            System.out.println("Nombre invalido. No puede estar vacio.");
            return;
        }

        System.out.print("Coordenada X: ");
        double x = sc.nextDouble();
        sc.nextLine();

        System.out.print("Coordenada Y: ");
        double y = sc.nextDouble();
        sc.nextLine();

        PuntoDeDistribucion p = new PuntoDeDistribucion(nombre, x, y);
        puntos[cantPuntos] = p;
        cantPuntos++;

        System.out.println("Punto registrado.");
    }

    private void conectarTodosLosPuntos() {
        if (cantPuntos == 0) {
            System.out.println("No hay puntos registrados.");
            return;
        }

        Conectable[] red = new Conectable[cantPuntos];
        for (int i = 0; i < cantPuntos; i++) {
            red[i] = puntos[i];
        }

        System.out.println("\n--- Conectando puntos ---");
        for (int i = 0; i < red.length; i++) {
            // El método ya imprime "Conectado" o "No pudo ser conectado"
            red[i].conectarALaRed();
        }
    }

    private void verEstadoDeLaRed() {
        if (cantPuntos == 0) {
            System.out.println("No hay puntos registrados.");
            return;
        }

        Conectable[] red = new Conectable[cantPuntos];
        for (int i = 0; i < cantPuntos; i++) {
            red[i] = puntos[i];
        }

        System.out.println("\n--- Estado de la red ---");
        for (int i = 0; i < red.length; i++) {
            boolean conectado = red[i].estaConectado();
            System.out.println((i + 1) + ") " + red[i].getNombreNodo()
                    + " Conectado=" + (conectado ? "SI" : "NO"));
        }
    }


    //=================SUB-MENU N°4: REPARTIDOR===========================
    private void menuRepartidor() {
        int op;

        do {
            System.out.println("\n=== Submenu 4 - Repartidor ===");
            System.out.println("1. Equipar vehiculo");
            System.out.println("2. Viajar a un destino");
            System.out.println("3. Ver estado del repartidor");
            System.out.println("4. Descansar");
            System.out.println("5. Cargar bateria");
            System.out.println("6. Simular carga");
            System.out.println("0. Volver");
            System.out.print("Opcion: ");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    equiparVehiculoSam();
                    break;
                case 2:
                    viajarConSam();
                    break;
                case 3:
                    verEstadoRepartidor();
                    break;
                case 4:
                    descansarSam();
                    break;
                case 5:
                    cargarBateriaVehiculoSam();
                    break;
                case 6:
                    simularCarga();
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

    //MÉTODOS DE SUB-MENU 4:

    private void equiparVehiculoSam() {
        if (cantVehiculos == 0) {
            System.out.println("No hay vehiculos registrados.");
            return;
        }

        System.out.println("\n--- Vehiculos ---");
        for (int i = 0; i < cantVehiculos; i++) {
            System.out.println((i + 1) + ") " + vehiculos[i]);
        }

        System.out.print("Elegí numero de vehiculo: ");
        int nro = sc.nextInt();
        sc.nextLine();

        int numeroIndice = nro - 1;
        if (numeroIndice < 0 || numeroIndice >= cantVehiculos) {
            System.out.println("Numero invalido.");
            return;
        }

        sam.equiparVehiculo(vehiculos[numeroIndice]);
    }

    private void viajarConSam() {
        if (cantPuntos == 0) {
            System.out.println("No hay puntos registrados.");
            return;
        }

        System.out.println("\n--- Puntos ---");
        for (int i = 0; i < cantPuntos; i++) {
            System.out.println((i + 1) + ") " + puntos[i]);
        }

        System.out.print("Elegí numero de destino: ");
        int nro = sc.nextInt();
        sc.nextLine();

        int numeroIndice = nro - 1;
        if (numeroIndice < 0 || numeroIndice >= cantPuntos) {
            System.out.println("Numero invalido.");
            return;
        }

        PuntoDeDistribucion destino = puntos[numeroIndice];

        Vehiculo v = sam.getVehiculoActual();
        double resistenciaAntes = sam.getResistencia();
        double bateriaAntes;

        if (v != null) {
            bateriaAntes = v.bateriaDisponible();
        } else {
            bateriaAntes = 0.0;
        }

        sam.viajarA(destino);

        if (sam.getUbicacionActual() == destino) {
            destino.setVisitado(true);
            System.out.println("Visita registrada. Ahora se puede conectar este nodo a la red.");
        }

        if (v != null) {
            double bateriaDespues = v.bateriaDisponible();
            System.out.println("Bateria consumida: " + String.format("%.2f", (bateriaAntes - bateriaDespues)));
        } else {
            double resistenciaDespues = sam.getResistencia();
            System.out.println("Resistencia consumida: " + String.format("%.2f", (resistenciaAntes - resistenciaDespues)));
        }
    }

    private void verEstadoRepartidor() {
        System.out.println(sam);
    }

    private void descansarSam() {
        sam.descansar();
        System.out.println("Resistencia actual: " + sam.getResistencia());
    }

    private void cargarBateriaVehiculoSam() {
        Vehiculo v = sam.getVehiculoActual();
        if (v == null) {
            System.out.println("Sam no tiene vehiculo equipado.");
            return;
        }

        System.out.print("Cantidad a recargar: ");
        double cant = sc.nextDouble();
        sc.nextLine();

        v.cargarBateria(cant);
        System.out.println("Bateria actual (%): " + String.format("%.2f", v.bateriaDisponible()));
    }

    private void simularCarga() {
        if (cantPaquetes == 0) {
            System.out.println("No hay paquetes registrados.");
            return;
        }

        System.out.println("\n--- Paquetes ---");
        for (int i = 0; i < cantPaquetes; i++) {
            System.out.println((i + 1) + ") " + paquetes[i]);
        }

        System.out.print("Elegí numero de paquete: ");
        int nro = sc.nextInt();
        sc.nextLine();

        int numeroIndice = nro - 1;
        if (numeroIndice < 0 || numeroIndice >= cantPaquetes) {
            System.out.println("Numero invalido.");
            return;
        }

        boolean ok = sam.puedeCargar(paquetes[numeroIndice]);
        System.out.println(ok ? "SI puede cargar" : "NO puede cargar");
    }
}