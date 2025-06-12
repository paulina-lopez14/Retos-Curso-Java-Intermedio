public abstract class OrdenProduccion {
    //Atributos
    private final String codigo;
    private final int cantidad;

    //Constructor para el método mostrar resumen
    public OrdenProduccion(String codigo, int cantidad) {
        this.codigo = codigo;
        this.cantidad = cantidad;
    }

    //Getters
    public String getCodigo(){
        return codigo;
    }
    public int getCantidad(){
        return cantidad;
    }

    //Método mostrar resumen, sin implementacion para que cada orden se escriba con su respectivo formato
    public abstract void mostrarResumen();

}
