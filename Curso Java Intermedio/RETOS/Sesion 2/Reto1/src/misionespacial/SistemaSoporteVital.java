package misionespacial;

import java.util.concurrent.Callable;

public class SistemaSoporteVital implements Callable<String> {
    public String call() throws Exception {
        Thread.sleep(2000);
        return " 🩺 Soporte vital: presión y oxígenodentro de parámetros normales.";
    }
}
