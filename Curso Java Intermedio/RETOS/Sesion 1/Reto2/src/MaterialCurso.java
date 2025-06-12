public abstract class MaterialCurso {
    //Atributos que comparten las subclases
    private final String titulo;
    private final String autor;

    //Constructor
    public MaterialCurso(String titulo, String autor){
        this.titulo = titulo;
        this.autor = autor;
    }

    //Getters
    public String getTitulo(){
        return titulo;
    }
    public String getAutor(){
        return autor;
    }

    //Método abstracto mostrarDetalle
    public abstract void mostrarDetalle();
}
