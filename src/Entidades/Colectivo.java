
package Entidades;


public class Colectivo {
    
    private int IdColectivo;
    private String matricula;
    private String marca;
    private String modelo;
    private int capacidad;

    public Colectivo() {
    }

    public Colectivo(int IdColectivo, String matricula, String marca, String modelo, int capacidad) {
        this.IdColectivo = IdColectivo;
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.capacidad = capacidad;
    }

    public Colectivo(String matricula, String marca, String modelo, int capacidad) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.capacidad = capacidad;
    }

    public int getIdColectivo() {
        return IdColectivo;
    }

    public void setIdColectivo(int IdColectivo) {
        this.IdColectivo = IdColectivo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Colectivo{" + "IdColectivo=" + IdColectivo + ", matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", capacidad=" + capacidad + '}';
    }
    
    
}
