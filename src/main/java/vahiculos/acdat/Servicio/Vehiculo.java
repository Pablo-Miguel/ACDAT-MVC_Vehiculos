/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vahiculos.acdat.Servicio;

import java.util.Objects;

/**
 *
 * @author Dam
 */
public class Vehiculo {

    private String marca, modelo, matricula;
    
    public Vehiculo() {
        
    }
    
    public Vehiculo(String matricula) {
        this.matricula = matricula;
    }

    public Vehiculo(String marca, String modelo, String matricula) {

        this.marca = marca;
        this.modelo = modelo;
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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.matricula);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehiculo other = (Vehiculo) obj;
        return Objects.equals(this.matricula, other.matricula);
    }

    @Override
    public String toString() {
        return "Vehiculo [marca=" + marca + ", modelo=" + modelo + ", matricula=" + matricula + "]";
    }
}
