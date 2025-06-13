import misionespacial.SistemaComunicaciones;
import misionespacial.SistemaControlTermico;
import misionespacial.SistemaNavegacion;
import misionespacial.SistemaSoporteVital;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws Exception{
        System.out.println("🚀 Simulación de misión espacial iniciada...");

        //ExecutorService gestiona un conjunto de hilos reutilizables
        ExecutorService executor = Executors.newFixedThreadPool(4);

        //Enviar las tareas con submit() y recuperar datos con Future.get()
        Future<String> nav = executor.submit(new SistemaNavegacion());
        Future<String> com = executor.submit(new SistemaComunicaciones());
        Future<String> termico = executor.submit(new SistemaControlTermico());
        Future<String> vital = executor.submit(new SistemaSoporteVital());

        // Imprimir
        System.out.println(nav.get());
        System.out.println(com.get());
        System.out.println(termico.get());
        System.out.println(vital.get());


        //Cerrar el executor
        executor.shutdown();

        //Imprimir mensaje
        System.out.println("✅ Todos los sistemas fueron procesados");

    }
}