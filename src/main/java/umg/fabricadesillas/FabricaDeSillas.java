/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package umg.fabricadesillas;

import java.util.Scanner;
import umg.fabricadesillas.Materiales;

/**
 *
 * @author josesalazar
 */
public class FabricaDeSillas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FabricaDeSillas fabrica = new FabricaDeSillas();
        Materiales dato2 = new Materiales();

        //Materiales mate = new Materiales();
        int opcion;

        do {
            System.out.println("Menú Principal");
            System.out.println("1. Fabricar Silla");
            System.out.println("2. Administrar Inventario");
            System.out.println("3. Gestionar Pedidos");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Lógica para fabricar una silla
                    break;
                case 2:
                    dato2.comprarMateriales();
    
    
    // Puedes agregar más lógica de administración de inventario aquí si es necesario
    break;

                case 3:
                    // Lógica para gestionar pedidos
                    break;
                case 4:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
            }
        } while (opcion != 4);
    }
}
