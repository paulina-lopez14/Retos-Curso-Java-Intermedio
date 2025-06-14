import java.util.List;

public class Sucursal {
    //Atributos
    private final String nombre;
    private final List<Encuesta> encuestas;

    //Constructor
    public Sucursal(String nombre, List<Encuesta> encuestas){
        this.nombre = nombre;
        this.encuestas = encuestas;
    }

    //Getters
    public String getNombre(){
        return nombre;
    }
    public List<Encuesta> getEncuestas(){
        return encuestas;
    }

}
