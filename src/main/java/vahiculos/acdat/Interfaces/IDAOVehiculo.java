/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package vahiculos.acdat.Interfaces;

import java.util.List;
import vahiculos.acdat.Servicio.Vehiculo;

/**
 *
 * @author Dam
 */
public interface IDAOVehiculo {
    
    public int insertarVehiculo(Vehiculo vehiculo);

    public int eliminarVehiculo(String matricula);

    public Vehiculo getVehiculo(String matricula);

    public List<Vehiculo> getVehiculos();

    public Vehiculo modificarVehiculo(String matriculaAntigua, String matriculaNueva, String marca, String modelo);
    
}
