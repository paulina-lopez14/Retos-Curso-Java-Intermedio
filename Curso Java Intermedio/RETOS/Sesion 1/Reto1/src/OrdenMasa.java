public class OrdenMasa extends OrdenProduccion{

    //Wildcard super para insertar datos
    public OrdenMasa(String codigo, int cantidad){
        super(codigo, cantidad);
    }

    //Uso de MostrarResumen con formato específico
    @Override
    public void mostrarResumen(){
        System.out.println("🔨 OrdenMasa - Código" + getCodigo() + " - Cantidad: "+ getCantidad());
    }
}
