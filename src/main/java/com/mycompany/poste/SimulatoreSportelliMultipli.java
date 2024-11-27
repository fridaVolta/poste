/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poste;

import java.util.ArrayList;

/**
 *
 * @author frida
 */
public class SimulatoreSportelliMultipli {

    public static final int NumeroSportelli = 3;

    public static void main(String[] args) {
        ListaClienti listaClienti = new ListaClienti();
        Thread arriviThread = new Thread(new GestoreArrivi(listaClienti));
        ArrayList<Thread> sportelloThreadList = new ArrayList<Thread>();
        arriviThread.start();
        for (int i = 0; i < NumeroSportelli; i++) {
            Thread sportelloThread = new Thread(new Sportello(listaClienti, i + 1));
            sportelloThreadList.add(sportelloThread);
            sportelloThread.start();
        }
    }
}
