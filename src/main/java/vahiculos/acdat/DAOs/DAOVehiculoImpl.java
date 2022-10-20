/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vahiculos.acdat.DAOs;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import vahiculos.acdat.Servicio.Vehiculo;
import vahiculos.acdat.Interfaces.IDAOVehiculo;

/**
 *
 * @author Dam
 */
public class DAOVehiculoImpl implements IDAOVehiculo {

    private static IDAOVehiculo dao = null;

    private DAOVehiculoImpl() {
        super();

    }

    @Override
    public int insertarVehiculo(Vehiculo vehiculo) {
        try {
            ConexionDB.insertarVehiculo(vehiculo);
            return 0;
        } catch (SQLIntegrityConstraintViolationException ex) {
            return 1;
        } catch (SQLException ex) {
            return -1;
        }
    }

    @Override
    public int eliminarVehiculo(String matricula) {
        return ConexionDB.deleteVehiculo(matricula);
    }

    @Override
    public Vehiculo getVehiculo(String matricula) {
        return ConexionDB.getVehiculo(matricula);
    }

    @Override
    public List<Vehiculo> getVehiculos() {
        return ConexionDB.getVehiculos();
    }

    public static IDAOVehiculo getInstance() {
        if (dao == null) {
            dao = new DAOVehiculoImpl();
        }

        return dao;
    }

    @Override
    public Vehiculo modificarVehiculo(String matriculaAntigua, String matriculaNueva, String marca, String modelo) {
        if (!matriculaAntigua.equals(matriculaNueva)) {
            if (ConexionDB.getVehiculo(matriculaNueva) == null) {
                return ConexionDB.updateVehiculo(matriculaAntigua, matriculaNueva, marca, modelo);
            } else {
                return null;
            }
        } else {
            return ConexionDB.updateVehiculo(matriculaAntigua, matriculaNueva, marca, modelo);
        }
    }

}
