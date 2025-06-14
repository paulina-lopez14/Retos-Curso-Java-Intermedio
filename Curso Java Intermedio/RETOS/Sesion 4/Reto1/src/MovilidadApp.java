import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class MovilidadApp {

    public static void main(String[] args) {

        CompletableFuture<String> rutaFuture = calcularRuta();
        CompletableFuture<Double> tarifaFuture = estimarTarifa();

        //Método para combinar ambas operaciones
        CompletableFuture<Void>  finDelViaje = rutaFuture.thenCombine(tarifaFuture, (ruta, tarifa) -> {
            return "\n🚕 Ruta calculada: " + ruta + " \n💲 Tarifa: " +tarifa;
        })
        .thenAccept(System.out::println)
                .exceptionally(ex -> {
                    System.out.println("🚫 Error al generar el reporte: " + ex.getMessage());
                    return null;
                });

        //Esperar que todo termine
        finDelViaje.join();
    }

    //Simular el cálculo de una ruta
    public static CompletableFuture<String> calcularRuta(){
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("🛣️ Calculando ruta...");
            dormir(2);
            return"Centro -> Norte";
                });
    }

    //Simular estimación de tarifa
    public static CompletableFuture<Double> estimarTarifa(){
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("💵 Estimando tarifa...");
            dormir(1);
            return 75.5;
        });
    }

    //Simular latencia
    public static void dormir(int segundos) {
        try {
            TimeUnit.SECONDS.sleep(segundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}