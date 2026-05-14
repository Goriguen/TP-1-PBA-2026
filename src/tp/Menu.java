package tp;

import java.util.Scanner;

public class Menu {

    private static final int MAX_PAQUETES = 10;
    private static final int MAX_VEHICULOS = 5;
    private static final double COSTO_RESISTENCIA_POR_KM = 0.8;
    // Se usa un valor chico para simular una partida real con pocos nodos activos.
    private static final int MAX_PUNTOS = 10;

    private final Scanner scanner;
    private final Paquete[] paquetes;
    private int cantidadPaquetes;

    private final Vehiculo[] vehiculos;
    private int cantidadVehiculos;

    private final PuntoDeDistribucion[] puntos;
    private int cantidadPuntos;

    private Repartidor sam;

    public Menu() {
        scanner = new Scanner(System.in);
        paquetes = new Paquete[MAX_PAQUETES];
        vehiculos = new Vehiculo[MAX_VEHICULOS];
        puntos = new PuntoDeDistribucion[MAX_PUNTOS];

        PuntoDeDistribucion puntoInicial = new PuntoDeDistribucion("Base", 0, 0);
        puntoInicial.setVisitado(true);
        puntos[0] = puntoInicial;
        cantidadPuntos = 1;

        sam = new Repartidor("Sam", 140, puntoInicial, null);
    }

    public void iniciar() {
        int opcion;
        do {
            mostrarMenuPrincipal();
            opcion = leerEnteroEnRango("Elegí una opción: ", 0, 4);

            switch (opcion) {
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
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private void mostrarMenuPrincipal() {
        System.out.println("\n===== MENÚ PRINCIPAL =====");
        System.out.println("1. Gestión de paquetes");
        System.out.println("2. Gestión de vehículos");
        System.out.println("3. Gestión de puntos de distribución");
        System.out.println("4. Repartidor");
        System.out.println("0. Salir");
    }

    private void menuPaquetes() {
        int opcion;
        do {
            System.out.println("\n--- Gestión de paquetes ---");
            System.out.println("1. Registrar paquete");
            System.out.println("2. Clonar paquete");
            System.out.println("3. Listar paquetes");
            System.out.println("4. Ordenar por prioridad");
            System.out.println("0. Volver");

            opcion = leerEnteroEnRango("Elegí una opción: ", 0, 4);

            switch (opcion) {
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
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private void registrarPaquete() {
        if (cantidadPaquetes >= MAX_PAQUETES) {
            System.out.println("No hay más espacio para paquetes.");
            return;
        }

        String id = leerTextoNoVacio("ID del paquete: ");
        while (existePaqueteConId(id)) {
            System.out.println("Ya existe un paquete con ese ID.");
            id = leerTextoNoVacio("ID del paquete: ");
        }

        String descripcion = leerTextoNoVacio("Descripción: ");
        double peso = leerDoubleMayorQueCero("Peso (kg): ");
        boolean urgente = leerBooleanoSiNo("¿Es urgente? (s/n): ");

        paquetes[cantidadPaquetes] = new Paquete(id, descripcion, peso, urgente);
        cantidadPaquetes++;

        System.out.println("Paquete registrado correctamente.");
    }

    private void clonarPaquete() {
        if (cantidadPaquetes == 0) {
            System.out.println("No hay paquetes para clonar.");
            return;
        }

        listarPaquetesConIndice();
        int indice = leerEnteroEnRango("Elegí el índice del paquete a clonar: ", 0, cantidadPaquetes - 1);

        if (cantidadPaquetes >= MAX_PAQUETES) {
            System.out.println("No hay más espacio para agregar el clon.");
            return;
        }

        // Se usa clone() para cumplir el requisito del TP y luego se crea
        // una nueva instancia con el nuevo ID porque Paquete no tiene setter de id.
        Paquete paqueteClonado = (Paquete) paquetes[indice].clone();

        String nuevoId = leerTextoNoVacio("Nuevo ID para el paquete clonado: ");
        while (existePaqueteConId(nuevoId)) {
            System.out.println("Ya existe un paquete con ese ID.");
            nuevoId = leerTextoNoVacio("Nuevo ID para el paquete clonado: ");
        }

        Paquete nuevoPaquete = new Paquete(
                nuevoId,
                paqueteClonado.getDescripcion(),
                paqueteClonado.getPeso(),
                paqueteClonado.isUrgente()
        );

        paquetes[cantidadPaquetes] = nuevoPaquete;
        cantidadPaquetes++;

        System.out.println("Paquete clonado y registrado correctamente.");
    }

    private void listarPaquetes() {
        if (cantidadPaquetes == 0) {
            System.out.println("No hay paquetes cargados.");
            return;
        }

        System.out.println("\nLista de paquetes:");
        for (int i = 0; i < cantidadPaquetes; i++) {
            System.out.println(paquetes[i]);
        }
    }

    private void listarPaquetesConIndice() {
        System.out.println("\nPaquetes disponibles:");
        for (int i = 0; i < cantidadPaquetes; i++) {
            System.out.println(i + ". " + paquetes[i]);
        }
    }

    private void ordenarPaquetesPorPrioridad() {
        if (cantidadPaquetes < 2) {
            System.out.println("No hay suficientes paquetes para ordenar.");
            return;
        }

        for (int i = 0; i < cantidadPaquetes - 1; i++) {
            for (int j = 0; j < cantidadPaquetes - 1 - i; j++) {
                if (paquetes[j].compareTo(paquetes[j + 1]) > 0) {
                    Paquete aux = paquetes[j];
                    paquetes[j] = paquetes[j + 1];
                    paquetes[j + 1] = aux;
                }
            }
        }

        System.out.println("Paquetes ordenados por prioridad:");
        listarPaquetes();
    }

    private void menuVehiculos() {
        int opcion;
        do {
            System.out.println("\n--- Gestión de vehículos ---");
            System.out.println("1. Registrar vehículo");
            System.out.println("2. Listar vehículos");
            System.out.println("0. Volver");

            opcion = leerEnteroEnRango("Elegí una opción: ", 0, 2);

            switch (opcion) {
                case 1:
                    registrarVehiculo();
                    break;
                case 2:
                    listarVehiculos();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private void registrarVehiculo() {
        if (cantidadVehiculos >= MAX_VEHICULOS) {
            System.out.println("No hay más espacio para vehículos.");
            return;
        }

        System.out.println("Tipo de vehículo:");
        System.out.println("1. Moto");
        System.out.println("2. Camión");
        int tipo = leerEnteroEnRango("Elegí tipo: ", 1, 2);

        String id = leerTextoNoVacio("ID del vehículo: ");
        while (existeVehiculoConId(id)) {
            System.out.println("Ya existe un vehículo con ese ID.");
            id = leerTextoNoVacio("ID del vehículo: ");
        }

        double capacidad = leerDoubleMayorQueCero("Capacidad de carga (kg): ");

        if (tipo == 1) {
            vehiculos[cantidadVehiculos] = new Moto(id, capacidad);
        } else {
            boolean tieneRemolque = leerBooleanoSiNo("¿Tiene remolque? (s/n): ");
            vehiculos[cantidadVehiculos] = new Camion(tieneRemolque, id, capacidad);
        }

        cantidadVehiculos++;
        System.out.println("Vehículo registrado correctamente.");
    }

    private void listarVehiculos() {
        if (cantidadVehiculos == 0) {
            System.out.println("No hay vehículos cargados.");
            return;
        }

        System.out.println("\nLista de vehículos:");
        // Funciona por polimorfismo: el array es Vehiculo[],
        // pero Java ejecuta la versión de descripcionTipo() según el objeto real (Moto o Camion).
        for (int i = 0; i < cantidadVehiculos; i++) {
            System.out.println(i + ". Tipo: " + vehiculos[i].descripcionTipo() + " | " + vehiculos[i]);
        }
    }

    private void menuPuntos() {
        int opcion;
        do {
            System.out.println("\n--- Gestión de puntos de distribución ---");
            System.out.println("1. Registrar punto");
            System.out.println("2. Conectar todos los puntos");
            System.out.println("3. Ver estado de la red");
            System.out.println("0. Volver");

            opcion = leerEnteroEnRango("Elegí una opción: ", 0, 3);

            switch (opcion) {
                case 1:
                    registrarPunto();
                    break;
                case 2:
                    conectarTodosLosPuntos();
                    break;
                case 3:
                    verEstadoRed();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private void registrarPunto() {
        if (cantidadPuntos >= MAX_PUNTOS) {
            System.out.println("No hay más espacio para puntos de distribución.");
            return;
        }

        String nombre = leerTextoNoVacio("Nombre del punto: ");
        double x = leerDouble("Coordenada X: ");
        double y = leerDouble("Coordenada Y: ");

        puntos[cantidadPuntos] = new PuntoDeDistribucion(nombre, x, y);
        cantidadPuntos++;

        System.out.println("Punto registrado correctamente.");
    }

    private void conectarTodosLosPuntos() {
        if (cantidadPuntos == 0) {
            System.out.println("No hay puntos cargados.");
            return;
        }

        Conectable[] nodos = new Conectable[cantidadPuntos];
        for (int i = 0; i < cantidadPuntos; i++) {
            nodos[i] = puntos[i];
        }

        for (int i = 0; i < nodos.length; i++) {
            System.out.print("Conectando " + nodos[i].getNombreNodo() + " -> ");
            nodos[i].conectarALaRed();
        }
    }

    private void verEstadoRed() {
        if (cantidadPuntos == 0) {
            System.out.println("No hay puntos cargados.");
            return;
        }

        System.out.println("\nEstado de la red:");
        for (int i = 0; i < cantidadPuntos; i++) {
            System.out.println(puntos[i]);
        }
    }

    private void menuRepartidor() {
        int opcion;
        do {
            System.out.println("\n--- Repartidor ---");
            System.out.println("1. Equipar vehículo");
            System.out.println("2. Viajar a un destino");
            System.out.println("3. Ver estado del repartidor");
            System.out.println("4. Descansar");
            System.out.println("5. Cargar batería");
            System.out.println("6. Simular carga de paquete");
            System.out.println("0. Volver");

            opcion = leerEnteroEnRango("Elegí una opción: ", 0, 6);

            switch (opcion) {
                case 1:
                    equiparVehiculoRepartidor();
                    break;
                case 2:
                    viajarRepartidor();
                    break;
                case 3:
                    verEstadoRepartidor();
                    break;
                case 4:
                    sam.descansar();
                    System.out.println("Sam descansó correctamente.");
                    break;
                case 5:
                    cargarBateriaRepartidor();
                    break;
                case 6:
                    simularCarga();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private void equiparVehiculoRepartidor() {
        if (cantidadVehiculos == 0) {
            System.out.println("No hay vehículos registrados.");
            return;
        }

        listarVehiculos();
        int indice = leerEnteroEnRango("Elegí el índice del vehículo a equipar: ", 0, cantidadVehiculos - 1);
        sam.equiparVehiculo(vehiculos[indice]);
    }

    private void viajarRepartidor() {
        if (cantidadPuntos == 0) {
            System.out.println("No hay puntos registrados.");
            return;
        }

        listarPuntosConIndice();
        int indiceDestino = leerEnteroEnRango("Elegí el destino: ", 0, cantidadPuntos - 1);

        PuntoDeDistribucion destino = puntos[indiceDestino];
        PuntoDeDistribucion origen = sam.getUbicacionActual();

        double distancia = origen.distanciaA(destino);

        if (sam.getVehiculoActual() != null) {
            double costoBateria = sam.getVehiculoActual().consumoDeBateria(distancia);
            System.out.printf("Costo estimado del viaje en batería: %.2f%%%n", costoBateria);
        } else {
            double costoResistencia = distancia * COSTO_RESISTENCIA_POR_KM;
            System.out.printf("Costo estimado del viaje a pie en resistencia: %.2f%n", costoResistencia);
        }

        sam.viajarA(destino);

        if (sam.getUbicacionActual() == destino) {
            destino.setVisitado(true);
            System.out.println("Destino marcado como visitado.");
        } else {
            System.out.println("No se pudo completar el viaje.");
        }
    }

    private void verEstadoRepartidor() {
        System.out.println(sam);
    }

    private void cargarBateriaRepartidor() {
        Vehiculo vehiculo = sam.getVehiculoActual();
        if (vehiculo == null) {
            System.out.println("Sam no tiene un vehículo equipado.");
            return;
        }

        double cantidad = leerDoubleMayorQueCero("Cantidad a cargar: ");
        vehiculo.cargarBateria(cantidad);
        System.out.printf("Batería actual: %.2f%%%n", vehiculo.bateriaDisponible());
    }

    private void simularCarga() {
        if (cantidadPaquetes == 0) {
            System.out.println("No hay paquetes registrados.");
            return;
        }

        listarPaquetesConIndice();
        int indice = leerEnteroEnRango("Elegí el paquete a simular: ", 0, cantidadPaquetes - 1);

        boolean resultado = sam.puedeCargar(paquetes[indice]);
        System.out.println("Resultado de la simulación: " + resultado);
    }

    private void listarPuntosConIndice() {
        System.out.println("\nPuntos disponibles:");
        for (int i = 0; i < cantidadPuntos; i++) {
            System.out.println(i + ". " + puntos[i]);
        }
    }

    private int leerEnteroEnRango(String mensaje, int minimo, int maximo) {
        int valor;
        while (true) {
            System.out.print(mensaje);
            if (scanner.hasNextInt()) {
                valor = scanner.nextInt();
                scanner.nextLine();
                if (valor >= minimo && valor <= maximo) {
                    return valor;
                }
            } else {
                scanner.nextLine();
            }
            System.out.println("Valor inválido. Debe estar entre " + minimo + " y " + maximo + ".");
        }
    }

    private double leerDouble(String mensaje) {
        double valor;
        while (true) {
            System.out.print(mensaje);
            if (scanner.hasNextDouble()) {
                valor = scanner.nextDouble();
                scanner.nextLine();
                return valor;
            } else {
                scanner.nextLine();
                System.out.println("Valor inválido. Ingresá un número.");
            }
        }
    }

    private double leerDoubleMayorQueCero(String mensaje) {
        double valor;
        while (true) {
            valor = leerDouble(mensaje);
            if (valor > 0) {
                return valor;
            }
            System.out.println("El valor debe ser mayor a 0.");
        }
    }

    private String leerTextoNoVacio(String mensaje) {
        String texto;
        do {
            System.out.print(mensaje);
            texto = scanner.nextLine().trim();
            if (texto.isEmpty()) {
                System.out.println("El texto no puede estar vacío.");
            }
        } while (texto.isEmpty());
        return texto;
    }

    private boolean leerBooleanoSiNo(String mensaje) {
        String valor;
        while (true) {
            System.out.print(mensaje);
            valor = scanner.nextLine().trim().toLowerCase();
            if (valor.equals("s")) {
                return true;
            } else if (valor.equals("n")) {
                return false;
            }
            System.out.println("Ingresá 's' o 'n'.");
        }
    }

    private boolean existePaqueteConId(String id) {
        for (int i = 0; i < cantidadPaquetes; i++) {
            if (paquetes[i].getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    private boolean existeVehiculoConId(String id) {
        for (int i = 0; i < cantidadVehiculos; i++) {
            if (vehiculos[i].getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }
}
