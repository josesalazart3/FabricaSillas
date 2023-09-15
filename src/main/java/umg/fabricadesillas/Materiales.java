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
        try (FileWriter archivo = new FileWriter("/Users/josesalazar/NetBeansProjects/Tarea1/tarea1/registro_compras.txt", true);
             PrintWriter escritor = new PrintWriter(archivo)) {
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

    
}
