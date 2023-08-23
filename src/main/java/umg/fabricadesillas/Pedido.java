/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umg.fabricadesillas;

import java.util.Date;

/**
 *
 * @author josesalazar
 */
public class Pedido {
    //declaracion de variables

    private int Cantidad;
    private String TipoSilla;
    private Date FechaPedido;
//declaracion de GET y SET

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public String getTipoSilla() {
        return TipoSilla;
    }

    public void setTipoSilla(String TipoSilla) {
        this.TipoSilla = TipoSilla;
    }

    public Date getFechaPedido() {
        return FechaPedido;
    }

    public void setFechaPedido(Date FechaPedido) {
        this.FechaPedido = FechaPedido;
    }

}
