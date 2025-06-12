public class Articulo extends MaterialCurso{
    //Atributo extra de la subclase
    private final int palabras;

    //Constructor
    public Articulo(String titulo, String autor, int palabras){
        super(titulo, autor);
        this.palabras = palabras;
    }

    //Getter del atributo extra
    public int getPalabras(){
        return palabras;
    }

    //Método mostrarDetalle
    @Override
    public void mostrarDetalle(){
        System.out.println("  📃 Artículo:" +getTitulo()+ " - Autor: " +getAutor()+ " - Palabras: "+palabras);
    }

}
