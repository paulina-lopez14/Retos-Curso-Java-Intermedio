import java.util.concurrent.*;
import java.util.Random;

public class AeropuertoControl {
    private static final Random random = new Random();

    public static void main(String[] args) {
        System.out.println("🛩️ Verificando condiciones para aterrizaje...\n");

        CompletableFuture<Boolean> pistaFuture = verificarPista();
        CompletableFuture<Boolean> climaFuture = verificarClima();
        CompletableFuture<Boolean> traficoFuture = verificarTraficoAereo();
        CompletableFuture<Boolean> personalFuture = verificarPersonalTierra();

        CompletableFuture<Void> controlAterrizaje = CompletableFuture.allOf(pistaFuture, climaFuture, traficoFuture, personalFuture)
                .thenAccept(v -> {
                    try {
                        boolean pista = pistaFuture.get();
                        boolean clima = climaFuture.get();
                        boolean trafico = traficoFuture.get();
                        boolean personal = personalFuture.get();

                        if (pista && clima && trafico && personal){
                            System.out.println("\n ✅ Aterrizaje autorizado: todas las condiciones son óptimas.");
                        } else {
                            System.out.println("\n 🚫 Aterrizaje denegado: condiciones no óptimas.");
                        }
        } catch (InterruptedException | ExecutionException e) {
                        System.out.println("\n ⚠️ Error en la evaluación de condiciones: " +e.getMessage());
        }
                });
        //Esperar a que todo termine
        controlAterrizaje.join();
    }

    //Verificad disponibilidad de la pista
    public static CompletableFuture<Boolean> verificarPista(){
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("🛣️ Verificando pista...");
            dormir(2);
            boolean disponible = random.nextInt(100) < 80; //80% prob de éxito
            System.out.println("\n🧑‍✈️ Pista disponible: "+ disponible);
            return disponible;
        });
    }

    //Verificar estado del clima
    public static CompletableFuture<Boolean> verificarClima(){
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("🌦️ Verificando clima...");
            dormir(4);
            boolean bueno = random.nextInt(100) < 85; //85% prob de éxito
            System.out.println("\n⛅ Clima favorable: "+ bueno);
            return bueno;
        });
    }

    //Verificar tráfico aéreo
    public static CompletableFuture<Boolean> verificarTraficoAereo(){
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("✈️ Verificando tráfico aéreo...");
            dormir(2);
            boolean libre = random.nextInt(100) < 90; //90% prob de éxito
            System.out.println("\n🛩️ Tráfico aéreo despejado: "+ libre);
            return libre;
        });
    }

    //Verificar personal en tierra
    public static CompletableFuture<Boolean> verificarPersonalTierra(){
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("👷 Verificando personal en tierra...");
            dormir(3);
            boolean disponible = random.nextInt(100) < 95; //95% prob de éxito
            System.out.println("\n👷 Personal disponible: "+ disponible);
            return disponible;
        });
    }

    // Simulador de latencia
    public static void dormir(int segundos) {
        try {
            TimeUnit.SECONDS.sleep(segundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}