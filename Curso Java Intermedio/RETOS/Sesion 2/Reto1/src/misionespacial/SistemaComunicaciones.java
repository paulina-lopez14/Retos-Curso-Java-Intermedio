package misionespacial;
import java.util.concurrent.Callable;

public class SistemaComunicaciones implements Callable{
    public String call() throws Exception {
        Thread.sleep(4000);
        return " 📡 Comunicaciones: enlace con estación terrestre establecido.";
    }
}
