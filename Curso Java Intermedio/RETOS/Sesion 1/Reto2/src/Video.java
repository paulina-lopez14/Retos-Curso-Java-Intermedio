public class Video extends MaterialCurso {

    //Atributo extra de la subclase
    private final int duracion;

    //Constructor
    public Video(String titulo, String autor, int duracion){
        super(titulo, autor);
        this.duracion = duracion;
    }

    //Getter para el atributo extra
    public int getDuracion(){
        return duracion;
    }

    //Método mostrarDetalle
    @Override
    public void mostrarDetalle(){
        System.out.println("  📹 Video: " +getTitulo()+ " - Autor: " +getAutor()+ " - Duración: " +duracion);
    }
}
