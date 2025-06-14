import java.util.concurrent.locks.ReentrantLock;

public class RecursoMedico {
    //Atributo nombre que representa el recurso "Sala de cirugía"
    private final String nombre;

    //Mecanismo de sincronización ReentrantLock
    private final ReentrantLock lock = new ReentrantLock();

    //constructor
    public RecursoMedico(String nombre){
        this.nombre = nombre;
    }

    //Entrada y salida de Doctores a la Sala
    public void usar(String profesional){
        lock.lock(); // seguridad activada
        try{
            System.out.println("-👩‍⚕️ "+ profesional + " ha ingresado a "+nombre);
            Thread.sleep(1500);
            System.out.println("✅ " + profesional +" ha salido de "+ nombre);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock(); //seguridad desactivada
        }
    }
}
