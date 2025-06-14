import java.util.Optional;
public class Encuesta {
    // Atributos
    private final String paciente;
    private final String comentario; // Puede ser null
    private final int calificacion;

    //Constructor
    public Encuesta(String paciente, String comentario, int calificacion){
        this.paciente = paciente;
        this.comentario = comentario;
        this.calificacion = calificacion;
    }

    //Getter
    public int getCalificacion(){
        return calificacion;
    }

    //Método Optional por si no hay comentario
    public Optional<String> getComentario() {
        return Optional.ofNullable(comentario);
    }
}
