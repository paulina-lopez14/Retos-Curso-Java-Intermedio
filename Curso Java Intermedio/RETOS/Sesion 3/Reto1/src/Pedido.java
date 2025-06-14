import java.util.Optional;

public class Pedido {
    //Atributos
    private final String cliente;
    private final String tipoEntrega;
    private final String telefono;

    //Constructor
    public Pedido(String cliente, String tipoEntrega, String telefono){
        this.cliente = cliente;
        this.tipoEntrega = tipoEntrega;
        this.telefono = telefono;
    }

    //Getters
    public String getCliente(){
        return cliente;
    }
    public String getTipoEntrega(){
        return tipoEntrega;
    }

    //Uso de Optional por si el cliente no agrega su telefono
    public Optional<String> getTelefono(){
        return Optional.ofNullable(telefono);
    }
}
