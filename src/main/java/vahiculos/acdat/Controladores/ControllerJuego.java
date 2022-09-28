/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vahiculos.acdat.Controladores;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import vahiculos.acdat.Servicio.GestionVehiculos;
import vahiculos.acdat.Vista.PanelJuego;

/**
 *
 * @author Nitro
 */
public class ControllerJuego {

    private GestionVehiculos gestionVehiculos;

    private PanelJuego panelJuego;

    public ControllerJuego() {
        
        gestionVehiculos = new GestionVehiculos();
    
    }

    public void nuevoCoche(JLabel etiSecreta) {
        etiSecreta.setText(gestionVehiculos.getVehiculo());

    }

    public void comprobarCoche(JTextField txtRespuesta) {
        String palabra = txtRespuesta.getText().toString();
        if (gestionVehiculos.compara(palabra)) {
            JOptionPane.showMessageDialog(panelJuego, "Correcto");
        } else {
            JOptionPane.showMessageDialog(panelJuego, "Incorrecto");
        }

    }
}
