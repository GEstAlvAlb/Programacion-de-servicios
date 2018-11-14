package com.company;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) throws Exception{
        Semaphore semaforoSala, semaforoAtraccion;

        semaforoSala = new Semaphore(5);
        semaforoAtraccion = new Semaphore(5);

        for (int i = 0; i < 20; i++) {
            new HiloPersona(semaforoSala, semaforoAtraccion).start();
            Thread.sleep(500);
        }
    }
}
