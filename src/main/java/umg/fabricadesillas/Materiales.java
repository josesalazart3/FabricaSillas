/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.fabricadesillas;

/**
 *
 * @author josesalazar
 */
public class Materiales {
    //declaracion de variables

    private String nombre;
    private double PrecioPorUnidad;
    private int Disponibilidad;

    //declaracion de GET y SET
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioPorUnidad() {
        return PrecioPorUnidad;
    }

    public void setPrecioPorUnidad(double PrecioPorUnidad) {
        this.PrecioPorUnidad = PrecioPorUnidad;
    }

    public int getDisponibilidad() {
        return Disponibilidad;
    }

    public void setDisponibilidad(int Disponibilidad) {
        this.Disponibilidad = Disponibilidad;
    }

}
