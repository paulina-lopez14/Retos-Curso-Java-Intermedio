public class OrdenPersonalizada extends OrdenProduccion{

    //Atributo extra
    private final String cliente;

    //Constructor
    public OrdenPersonalizada(String codigo, int cantidad, String cliente){
        super(codigo, cantidad);
        this.cliente = cliente;
    }

    //Getter del atributo extra
    public String getCliente(){
        return cliente;
    }

    //Mostrar resumen con formato específico
    @Override
    public void mostrarResumen(){
        System.out.println(" 🔧 Orden personalizada - Código: " + getCodigo() + " - Cantidad: " + getCantidad() + " - Cliente: "+ cliente);
    }
}
