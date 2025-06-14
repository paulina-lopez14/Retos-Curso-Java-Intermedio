import java.util.List;
public class Main {
    public static void main(String[] args) {
        //Crear dos encuestas por cada sucursal
        List<Sucursal> sucursales = List.of(
                new Sucursal("Cholula", List.of(
                        new Encuesta("Ana", "No encontré el medicamento que buscaba", 2),
                        new Encuesta("Luis", null, 7)
                )),
                new Sucursal("San Manuel", List.of(
                        new Encuesta("Marta", "La atención fue buena, pero la limpieza puede mejorar", 3),
                        new Encuesta("Pedro", null, 9)
                )),
                new Sucursal("La Paz", List.of(
                        new Encuesta("Carlos", null, 2),
                        new Encuesta("Sofía", "Tardaron mucho en atenderme y fueron groseros", 1)
                ))
        );

        System.out.println("💊 Seguimiento a pacientes insatisfechos:");
        sucursales.stream()
                .flatMap(sucursal ->
                        sucursal.getEncuestas().stream()
                                .filter(e -> e.getCalificacion() <= 3) // Filtrar encuestas insatisfechas
                                .map(encuesta -> new Seguimiento(encuesta, sucursal.getNombre())) // Combinar encuesta + sucursal
                )
                .filter(seg -> seg.encuesta().getComentario().isPresent()) //Filtrar encuestas con comentario
                .map(seg -> {
                    String comentario = seg.encuesta().getComentario().get();
                    return "Sucursal " + seg.sucursal() +
                            "\n ✅ Seguimiento a paciente con comentario: \"" + comentario + "\"";
                })
                .forEach(System.out::println); //Imprime mensajes
    }

    // Clase auxiliar tipo record para juntar encuesta y sucursal
    record Seguimiento(Encuesta encuesta, String sucursal) {

    }
}