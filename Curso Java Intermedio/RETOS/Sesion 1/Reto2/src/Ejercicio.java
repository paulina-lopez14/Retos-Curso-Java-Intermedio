public class Ejercicio extends MaterialCurso{

    //Atributo extra de la subclase
    private boolean revisado;

    //Constructor
    public Ejercicio(String titulo, String autor){
        super(titulo, autor);
        this.revisado = false;
    }

    // Getter, es isRevisado() en lugar de getRevisado() porque es un booleano y Setter
    public boolean isRevisado(){
        return revisado;
    }
    public void setRevisado(boolean revisado){
        this.revisado = revisado;
    }

    //Método mostrarDetalle
    @Override
    public void mostrarDetalle(){
        System.out.println("  🖋️ Ejercicio: " +getTitulo()+ " - Autor: "+getAutor()+ " - Revisado: "+revisado);
    }
}
