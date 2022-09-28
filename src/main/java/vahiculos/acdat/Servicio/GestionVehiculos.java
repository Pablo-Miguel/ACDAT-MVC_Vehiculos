/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vahiculos.acdat.Servicio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import vahiculos.acdat.DAOs.DAOVehiculoImpl;

/**
 *
 * @author Dam
 */
public class GestionVehiculos {

    private ArrayList<Vehiculo> listaVehiculos;
    private Random random;
    private String cadena;

    public GestionVehiculos() {
        listaVehiculos = (ArrayList<Vehiculo>) DAOVehiculoImpl.getInstance().getVehiculos();
        random = new Random();

    }

    public String getVehiculo() {
        StringBuilder cadena1, cadena2, cadenaTemp = new StringBuilder();
        Collections.shuffle(listaVehiculos);
        cadena = listaVehiculos.get(0).getMarca() + " " + listaVehiculos.get(0).getModelo();
        cadena1 = new StringBuilder(listaVehiculos.get(0).getMarca());
        cadena2 = new StringBuilder(listaVehiculos.get(0).getModelo());
        
        cadenaTemp = randomizarPalabra(cadena1);
        cadenaTemp.append("     " + randomizarPalabra(cadena2));
        
        System.out.println(cadena);
        
        return cadenaTemp.toString();
    }
    
    private StringBuilder randomizarPalabra(StringBuilder cadena) {
        StringBuilder cadenaTemp = new StringBuilder();
        
        for (int cont = 0; cont < cadena.length(); cont++) {
            
            if (random.nextBoolean()) {
                
                cadenaTemp.append(cadena.charAt(cont) + " ");
            
            } else {
                
                cadenaTemp.append(" _ ");
            
            }
        
        }
        
        return cadenaTemp;
    }

    public boolean compara(String cadenaJugador) {
        return cadena.equalsIgnoreCase(cadenaJugador);
    }

}
