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
import vahiculos.acdat.Vista.PanelCRUD;

/**
 *
 * @author Nitro
 */
public class ControllerCRUD {

    public static void cargarTabla(JTable tablaVehiculos) { //DefaultTableModel modeloDeDatosTabla = (DefaultTableModel) tablaVehiculos.getModel();
        List<Vehiculo> lstVehiculos = DAOVehiculoImpl.getInstance().getVehiculos();

        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("Marca");

        modelo.addColumn("Modelo");

        modelo.addColumn("Matricula");

        Object[] registroLeido = new Object[3];

        for (Vehiculo vehiculo : lstVehiculos) {

            registroLeido[0] = vehiculo.getMarca();

            registroLeido[1] = vehiculo.getModelo();

            registroLeido[2] = vehiculo.getMatricula();

            modelo.addRow(registroLeido);

        }

        tablaVehiculos.setModel(modelo);
    }

    public static boolean insertarVehiculo(PanelCRUD frmVehiculo, JTable tablaVehiculos) {
        boolean insertado = false;
        Vehiculo vehiculo = new Vehiculo();

        vehiculo.setMarca(frmVehiculo.getTxtMarca().getText());

        vehiculo.setModelo(frmVehiculo.getTxtModelo().getText());

        vehiculo.setMatricula(frmVehiculo.getTxtMatricula().getText());

        if (DAOVehiculoImpl.getInstance().insertarVehiculo(vehiculo) != 0) {
            insertado = true;
            cargarTabla(tablaVehiculos);
        }
        return insertado;
    }
}
