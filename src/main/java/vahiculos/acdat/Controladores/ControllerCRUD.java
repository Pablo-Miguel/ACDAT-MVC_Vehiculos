/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vahiculos.acdat.Controladores;

import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import vahiculos.acdat.DAOs.DAOVehiculoImpl;
import vahiculos.acdat.Servicio.Vehiculo;

/**
 *
 * @author Nitro
 */
public class ControllerCRUD {

    public static void cargarTabla(JTable tablaVehiculos) {
        List<Vehiculo> lstVehiculos = DAOVehiculoImpl.getInstance().getVehiculos();

        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("Marca");

        modelo.addColumn("Modelo");

        modelo.addColumn("Matricula");

        Object[] registroLeido = new Object[modelo.getColumnCount()];

        for (Vehiculo vehiculo : lstVehiculos) {

            registroLeido[0] = vehiculo.getMarca();

            registroLeido[1] = vehiculo.getModelo();

            registroLeido[2] = vehiculo.getMatricula();

            modelo.addRow(registroLeido);

        }

        tablaVehiculos.setModel(modelo);
    }

    public static boolean insertarVehiculo(String marca, String modelo, String matricula, JTable tablaVehiculos) {
        boolean insertado = false;

        if (DAOVehiculoImpl.getInstance().insertarVehiculo(new Vehiculo(marca, modelo, matricula)) == 0) {
            insertado = true;
            cargarTabla(tablaVehiculos);
        }
        return insertado;
    }
}