package umg.fabricadesillas;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Materiales {

    private String nombre;
    private double precioPorUnidad;
    private int disponibilidad;

    public Materiales(String nombre, double precioPorUnidad, int disponibilidad) {
        this.nombre = nombre;
        this.precioPorUnidad = precioPorUnidad;
        this.disponibilidad = disponibilidad;
    }

    public void menuGestionMateriales() {
        Scanner scanner = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("Menú de Gestión de Materiales");
            System.out.println("1. Comprar Materiales");
            System.out.println("2. Almacenar Material");
            System.out.println("3. Separar Material");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    comprarMateriales();
                    break;
                case 2:
                    almacenarMaterial();
                    break;
                case 3:
                    separarMaterial();
                    break;
                case 4:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
            }
        } while (opcion != 4);
    }

    public void comprarMateriales() {
        Scanner registroCompra = new Scanner(System.in);

        System.out.println("Ingrese el nombre del material a comprar:");
        String nombreMaterial = registroCompra.nextLine();

        System.out.println("Ingrese la cantidad de " + nombreMaterial + " a comprar:");
        int cantidadAComprar = registroCompra.nextInt();

        if (cantidadAComprar <= 0) {
            System.out.println("La cantidad a comprar debe ser mayor que cero.");
            return;
        }

        if (cantidadAComprar > disponibilidad) {
            System.out.println("No hay suficientes " + nombreMaterial + " disponibles para comprar.");
            return;
        }

        System.out.println("Ingrese el precio por unidad de " + nombreMaterial + ":");
        double precioUnidad = registroCompra.nextDouble();

        // Reducir la disponibilidad en función de la cantidad comprada.
        this.disponibilidad -= cantidadAComprar;

        // Registra la compra en un archivo de registro.
        registrarCompraEnArchivo(nombreMaterial, cantidadAComprar, precioUnidad);

        System.out.println(cantidadAComprar + " unidades de " + nombreMaterial + " compradas con éxito.");
    }

    private void registrarCompraEnArchivo(String nombreMaterial, int cantidadComprada, double precioUnidad) {
        try (FileWriter archivo = new FileWriter("/Users/josesalazar/NetBeansProjects/Tarea1/tarea1/registro_compras.txt", true); PrintWriter escritor = new PrintWriter(archivo)) {
            // Obtener la fecha actual
            java.util.Date fechaActual = new java.util.Date();
            String fechaCompra = fechaActual.toString();
            double costoTotal = cantidadComprada * precioUnidad;

            // Escribir los detalles de la compra en el archivo.
            escritor.println("Fecha: " + fechaCompra);
            escritor.println("Material: " + nombreMaterial);
            escritor.println("Cantidad comprada: " + cantidadComprada);
            escritor.println("Precio por unidad: $" + precioUnidad);
            escritor.println("Costo total: $" + costoTotal);
            escritor.println("----------------------------------");
        } catch (IOException e) {
            System.err.println("Error al registrar la compra en el archivo.");
            e.printStackTrace();
        }
    }

    public void almacenarMaterial() {
        Scanner registroMaterial = new Scanner(System.in);

        System.out.println("Ingrese el nombre del nuevo material:");
        String nombreMaterial = registroMaterial.nextLine();

        System.out.println("Ingrese la cantidad de " + nombreMaterial + " a agregar al inventario:");
        int cantidadAgregar = registroMaterial.nextInt();

        if (cantidadAgregar <= 0) {
            System.out.println("La cantidad a agregar debe ser mayor que cero.");
            return;
        }

        // Aumentar la disponibilidad en función de la cantidad agregada.
        this.disponibilidad += cantidadAgregar;

        // Registra la adición al inventario en un archivo de registro.
        registrarAdicionEnArchivo(nombreMaterial, cantidadAgregar);

        System.out.println(cantidadAgregar + " unidades de " + nombreMaterial + " agregadas al inventario con éxito.");
    }

    private void registrarAdicionEnArchivo(String nombreMaterial, int cantidadAgregada) {
        try (FileWriter archivo = new FileWriter("/Users/josesalazar/NetBeansProjects/Tarea1/tarea1/registro_inventario.txt", true); PrintWriter escritor = new PrintWriter(archivo)) {
            // Obtener la fecha actual
            java.util.Date fechaActual = new java.util.Date();
            String fechaAdicion = fechaActual.toString();

            // Escribir los detalles de la adición al inventario en el archivo.
            escritor.println("Fecha: " + fechaAdicion);
            escritor.println("Material: " + nombreMaterial);
            escritor.println("Cantidad agregada: " + cantidadAgregada);
            escritor.println("----------------------------------");
        } catch (IOException e) {
            System.err.println("Error al registrar la adición al inventario en el archivo.");
            e.printStackTrace();
        }
    }

    public void separarMaterial() {
        Scanner registroSeparacion = new Scanner(System.in);

        System.out.println("Ingrese el nombre del material a separar:");
        String nombreMaterial = registroSeparacion.nextLine();

        System.out.println("Ingrese la cantidad de " + nombreMaterial + " a separar del inventario:");
        int cantidadSeparar = registroSeparacion.nextInt();

        if (cantidadSeparar <= 0) {
            System.out.println("La cantidad a separar debe ser mayor que cero.");
            return;
        }

        if (cantidadSeparar > disponibilidad) {
            System.out.println("No hay suficientes " + nombreMaterial + " disponibles para separar.");
            return;
        }

        // Reducir la disponibilidad en función de la cantidad separada.
        this.disponibilidad -= cantidadSeparar;

        // Registra la separación en un archivo de registro.
        registrarSeparacionEnArchivo(nombreMaterial, cantidadSeparar);

        System.out.println(cantidadSeparar + " unidades de " + nombreMaterial + " separadas del inventario con éxito.");
    }

    private void registrarSeparacionEnArchivo(String nombreMaterial, int cantidadSeparada) {
        try (FileWriter archivo = new FileWriter("/Users/josesalazar/NetBeansProjects/Tarea1/tarea1/registro_separacion.txt", true); PrintWriter escritor = new PrintWriter(archivo)) {
            // Obtener la fecha actual
            java.util.Date fechaActual = new java.util.Date();
            String fechaSeparacion = fechaActual.toString();

            // Escribir los detalles de la separación en el archivo.
            escritor.println("Fecha: " + fechaSeparacion);
            escritor.println("Material: " + nombreMaterial);
            escritor.println("Cantidad separada: " + cantidadSeparada);
            escritor.println("----------------------------------");
        } catch (IOException e) {
            System.err.println("Error al registrar la separación en el archivo.");
            e.printStackTrace();
        }
    }

    int getDisponibilidad() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
