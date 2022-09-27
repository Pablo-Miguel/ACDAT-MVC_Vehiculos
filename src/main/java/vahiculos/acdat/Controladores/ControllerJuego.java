/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vahiculos.acdat.Controladores;

import javax.swing.JOptionPane;
import vahiculos.acdat.Servicio.GestionVehiculos;
import vahiculos.acdat.Vista.PanelJuego;

/**
 *
 * @author Nitro
 */
public class ControllerJuego {

    private GestionVehiculos gestionVehiculos;

    private PanelJuego panelJuego;

    public ControllerJuego(PanelJuego panelJuego) {

        gestionVehiculos = new GestionVehiculos();
        this.panelJuego = panelJuego;
    }

    public void nuevoCoche() {
        panelJuego.etiSecreta.setText(gestionVehiculos.getVehiculo());

    }

    public void comprobarCoche() {
        String palabra = panelJuego.txtRespuesta.getText().toString();
        if (gestionVehiculos.compara(palabra)) {
            JOptionPane.showMessageDialog(panelJuego, "Correcto");
        } else {
            JOptionPane.showMessageDialog(panelJuego, "Incorrecto");
        }

    }
}
