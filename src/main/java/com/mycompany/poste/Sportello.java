/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poste;

/**
 *
 * @author frida
 */
public class Sportello implements Runnable {

    private ListaClienti listaClienti;
    private final int minTempoServizio = 2000;
    private final int maxTempoServizio = 8000;
    private int numSportello=0;

    public Sportello(ListaClienti listaClienti) {
        this.listaClienti = listaClienti;
    }
    public Sportello(ListaClienti listaClienti, int numSportello) {
        this.listaClienti = listaClienti;
        this.numSportello=numSportello;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                Integer clienteServito = listaClienti.rimuoviCliente();
                System.out.println("Chiamato Cliente Numero \t " + clienteServito);
                int tempoServizio = (int) (Math.random() * (maxTempoServizio
                        - minTempoServizio + 1) + minTempoServizio);
                Thread.sleep(tempoServizio);
                System.out.println("Servito Cliente Numero \t " + clienteServito+
                        " dallo sportello n: "+ numSportello);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrotto durante lo sleep");
        } finally {
            System.out.println("Sportello Chiuso");
        }
    } 
}