
package Entidades;

import java.time.LocalTime;


public class Ruta {
    
    private int IdRuta;
    private String origen;
    private String destino;
    private LocalTime duracionEstimada;

    public Ruta() {
    }

    public Ruta(int IdRuta, String origen, String destino, LocalTime duracionEstimada) {
        this.IdRuta = IdRuta;
        this.origen = origen;
        this.destino = destino;
        this.duracionEstimada = duracionEstimada;
    }

    public Ruta(String origen, String destino, LocalTime duracionEstimada) {
        this.origen = origen;
        this.destino = destino;
        this.duracionEstimada = duracionEstimada;
    }

    public int getIdRuta() {
        return IdRuta;
    }

    public void setIdRuta(int IdRuta) {
        this.IdRuta = IdRuta;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalTime getDuracionEstimada() {
        return duracionEstimada;
    }

    public void setDuracionEstimada(LocalTime duracionEstimada) {
        this.duracionEstimada = duracionEstimada;
    }

    @Override
    public String toString() {
        return "Ruta{" + "IdRuta=" + IdRuta + ", origen=" + origen + ", destino=" + destino + ", duracionEstimada=" + duracionEstimada + '}';
    }
    
    
}
