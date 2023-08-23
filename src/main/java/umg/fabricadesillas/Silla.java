/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.fabricadesillas;

/**
 *
 * @author josesalazar
 */
public class Silla {
    //declaracion de variables

    private String TipoMaterial;
    private String Color;
    private String Estilo;
    
    
    //declaracion de GET y SET

    public String getTipoMaterial() {
        return TipoMaterial;
    }

    public void setTipoMaterial(String TipoMaterial) {
        this.TipoMaterial = TipoMaterial;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public String getEstilo() {
        return Estilo;
    }

    public void setEstilo(String Estilo) {
        this.Estilo = Estilo;
    }

}
