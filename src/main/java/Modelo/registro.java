/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


public class registro {

   
    
    int idColmenaH;
    int idColmena;
    int idFabrica;
    String ubicacion;
    int sumaKilos;

  

   
    public int getIdColmenaH() {
        return idColmenaH;
    }

    public void setIdColmenaH(int idColmenaH) {
        this.idColmenaH = idColmenaH;
    }

    public int getIdColmena() {
        return idColmena;
    }

    public void setIdColmena(int idColmena) {
        this.idColmena = idColmena;
    }

    public int getIdFabrica() {
        return idFabrica;
    }

    public void setIdFabrica(int idFabrica) {
        this.idFabrica = idFabrica;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getSumaKilos() {
        return sumaKilos;
    }

    public void setSumaKilos(int sumaKilos) {
        this.sumaKilos = sumaKilos;
    }

    @Override
    public String toString() {
        return "registro{" + "idColmenaH=" + idColmenaH + ", idColmena=" + idColmena + ", idFabrica=" + idFabrica + ", ubicacion=" + ubicacion + ", sumaKilos=" + sumaKilos + '}';
    }

    
      
}
