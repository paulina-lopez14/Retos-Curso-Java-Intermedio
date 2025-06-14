public class Profesional implements Runnable{

    //Atributos
    private final String nombre;
    private final RecursoMedico recurso;

    //Constructor
    public Profesional(String nombre, RecursoMedico recurso){
        this.nombre = nombre;
        this.recurso = recurso;
    }

    @Override
    public void run(){
        recurso.usar(nombre);
    }
}
