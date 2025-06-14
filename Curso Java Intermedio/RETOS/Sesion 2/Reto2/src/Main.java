import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args){
        System.out.println("🏥 Iniciando simulación de acceso al recurso...");

        RecursoMedico salaCirugia = new RecursoMedico("Sala de cirugía");

        // Crear un ExecutorService con 4 hilos
        ExecutorService executor = Executors.newFixedThreadPool(4);

        executor.submit(new Profesional("Dra. Sánchez", salaCirugia));
        executor.submit(new Profesional("Dra. Gómez", salaCirugia));
        executor.submit(new Profesional("Enfermera Sánchez", salaCirugia));

        //Cerrar el executor
        executor.shutdown();
    }
}