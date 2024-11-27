/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.poste;

import java.util.ArrayList;

/**
 *
 * @author frida
 */
public class SimulatorePoste {

    public static void main(String[] args) {
        ListaClienti listaClienti = new ListaClienti();
        Thread arriviThread = new Thread(new GestoreArrivi(listaClienti));
        Thread sportelloThread = new Thread(new Sportello(listaClienti));
        arriviThread.start();
        sportelloThread.start();
    }
}
