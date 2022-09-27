/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vahiculos.acdat.DAOs;

import java.util.ArrayList;
import java.util.List;
import vahiculos.acdat.Servicio.Vehiculo;
import vahiculos.acdat.Interfaces.IDAOVehiculo;

/**
 *
 * @author Dam
 */
public class DAOVehiculoImpl implements IDAOVehiculo {

    private List<Vehiculo> falsaBD;
    private static IDAOVehiculo dao = null;

    private DAOVehiculoImpl() {
        super();
        this.falsaBD = new ArrayList<Vehiculo>();
        falsaBD.add(new Vehiculo("Renault", "Zoe", "2345FDF"));
        falsaBD.add(new Vehiculo("Renault", "Fluence", "0000FTL"));
        falsaBD.add(new Vehiculo("Tesla", "3", "2422FHT"));
        falsaBD.add(new Vehiculo("Tesla", "X", "1221FDF"));

    }

    @Override
    public int insertarVehiculo(Vehiculo vehiculo) {
        if(falsaBD.add(vehiculo)){
            falsaBD.add(vehiculo);
            return 0;
        }

        return -1;
    }

    @Override
    public int eliminarVehiculo(String matricula) {
        if(falsaBD.remove(new Vehiculo(matricula))){
            falsaBD.remove(new Vehiculo(matricula));
            return 0;
        }
        
        return -1;
    }

    @Override
    public int eliminarVehiculos(List<Vehiculo> lstVehiculos) {
        for (Vehiculo lstVehiculo : lstVehiculos) {
            if(!falsaBD.remove(lstVehiculo)){
                return -1;
            }
            falsaBD.remove(lstVehiculo);
        }
        return 0;
    }

    @Override
    public Vehiculo getVehiculo(String matricula) {
        if(falsaBD.contains(new Vehiculo(matricula))){
            for (Vehiculo vehiculo : falsaBD) {
                if(new Vehiculo(matricula).equals(vehiculo)){
                    return vehiculo;
                }
            }
        }
        return null;
    }

    @Override
    public List<Vehiculo> getVehiculos() {
        return this.falsaBD;
    }

    public static IDAOVehiculo getInstance() {
        if (dao == null) {
            dao = new DAOVehiculoImpl();
        }

        return dao;
    }

    @Override
    public int eliminarVehiculo(Vehiculo vehiculo) {
        if(falsaBD.remove(vehiculo)){
            falsaBD.remove(vehiculo);
            return 0;
        }
        
        return -1;
    }
}
