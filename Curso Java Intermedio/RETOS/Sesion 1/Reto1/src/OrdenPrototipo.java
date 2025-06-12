public class OrdenPrototipo extends OrdenProduccion{

    //Atributo extra del tipo de orden
    private final String faseDesarrollo;

    //Constructor
    public OrdenPrototipo(String codigo, int cantidad, String faseDesarrollo){
        super(codigo, cantidad);
        this.faseDesarrollo = faseDesarrollo;
    }

    //Getter del atributo extra
    public String getFaseDesarrollo(){
        return faseDesarrollo;
    }

    //Mostrar resumen con formato personalizado
    @Override
    public void mostrarResumen(){
        System.out.println("⚙️ Orden prototipo - Código: " + getCodigo() + " - Cantidad: "+ getCantidad() + " - Fase de Desarrollo: "+ faseDesarrollo);
    }
}
