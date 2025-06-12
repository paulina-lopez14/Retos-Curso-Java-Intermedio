import java.util.*;

public class GestionOrdenes{

    //método genérico para mostrar una orden con cualquier tipo de dato
    public static void mostrarOrdenes(List<? extends OrdenProduccion> lista){
        System.out.println("\n 📃Órdenes registradas:");
        for(OrdenProduccion orden : lista){
            orden.mostrarResumen();
        }
    }

    //Método genérico para la orden personalizada
    public static void procesarPersonalizadas(List<? super OrdenPersonalizada> lista, int costoAdicional){
        System.out.println("\n ⚠️ Procesando órdenes personalizadas...");
        for(Object obj : lista){
            if(obj instanceof OrdenPersonalizada){
                OrdenPersonalizada op = (OrdenPersonalizada) obj;
                System.out.println("‼️ Orden "+ op.getCodigo()+" ajustada con costo adicional de $"+costoAdicional);
            }
        }
    }

    public static void main(String[] args){
        List<OrdenProduccion> todasLasOrdenes = new ArrayList<>();

        List<OrdenMasa> masas = Arrays.asList(
                new OrdenMasa("D2ERTF", 500),
                new OrdenMasa("DRT3S", 700)
        );

        List<OrdenPersonalizada> personalizadas = Arrays.asList(
                new OrdenPersonalizada("LJK25CX", 200, "José Pérez"),
                new OrdenPersonalizada("SLFKC", 300, "Fátima Rodríguez")
        );

        List<OrdenPrototipo> prototipos = Arrays.asList(
                new OrdenPrototipo("SK4CM", 300, "Pruebas"),
                new OrdenPrototipo("LM6CJS", 100, "Implementación")
        );

        todasLasOrdenes.addAll(masas);
        todasLasOrdenes.addAll(personalizadas);
        todasLasOrdenes.addAll(prototipos);

        mostrarOrdenes(masas);
        mostrarOrdenes(personalizadas);
        mostrarOrdenes(prototipos);

        procesarPersonalizadas(personalizadas, 200);
    }
}