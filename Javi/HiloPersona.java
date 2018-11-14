package com.company;

import java.util.concurrent.Semaphore;

public class HiloPersona extends Thread {
    private final int TAM = 5;
    private Semaphore semaforoSala, semaforoAtraccion;
    private static int contadorId = 0;
    private int id;

    public HiloPersona(Semaphore semaforoSala, Semaphore semaforoAtraccion){
        this.semaforoSala = semaforoSala;
        this.semaforoAtraccion = semaforoAtraccion;

        contadorId++;
        id = contadorId;
    }

    @Override
    public void run() {
        try {
            // Coger el semaforo de la entrada
            semaforoSala.acquire();
            System.out.println("[" + id + "] Esperando para entrar");

            // Vaciar la sala
            if (semaforoSala.availablePermits() == 0) {
                semaforoAtraccion.release(TAM);
            }
            semaforoAtraccion.acquire();
            System.out.println("[" + id + "] Pasando");

            // Dejar pasar a la sala
            semaforoSala.release();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
