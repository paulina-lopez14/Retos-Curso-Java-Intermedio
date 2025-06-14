import java.util.*;
import java.util.stream.*;

public class ConfirmacionPedidos {

    public static void main(String[] args) {
        // Crear pedidos
        List<Pedido> pedidos = List.of(
                new Pedido("Laura", "domicilio", "2212020304"),
                new Pedido("Arturo", "domicilio", "2212456304"),
                new Pedido("Paulina", "local", null),
                new Pedido("Carlos", "domicilio", null)
        );

        List<String> mensajes = pedidos.stream()
                .filter(p -> p.getTipoEntrega().equalsIgnoreCase("domicilio")) // 🔍 Filtrar por entrega a domicilio
                .map(Pedido::getTelefono) // 🔄 Transformar Pedido → Optional<String>
                .filter(Optional::isPresent) // 🔍 Filtrar los Optional con valor
                .map(Optional::get) // 📥 Extraer el número del Optional
                .map(tel -> "📞 Confirmación enviada al número: " + tel) // 📨 Crear mensaje
                .toList(); //Recolectar en una lista

        // Mostrar los mensajes
        System.out.println("📲 Confirmaciones de pedidos a domicilio: ");
        mensajes.forEach(System.out::println);
    }
}