import java.util.*;
import java.util.function.Predicate;

public class PlataformaEducativa{
    //Método genérico para mostrar el detalle de todos los materiales
    public static void mostrarMateriales(List<? extends MaterialCurso> lista){
        System.out.println("\n 👩‍🏫 Materiales del curso: ");
        for (MaterialCurso material : lista){
            material.mostrarDetalle();
        }
    }
    //Método genérico para mostrar la duración de todos los videos
    public static void contarDuracionVideos(List<? extends Video> lista){
        int total = 0;
        for (Video v : lista){
            total += v.getDuracion();
        }
        System.out.println(" \n Duración total de los videos: " + total + " minutos");
    }

    //Método genérico para actualizar el estado de revisado a true
    public static void marcarEjerciciosRevisados(List<? super Ejercicio> lista){
        System.out.println();
        for(Object obj : lista){
            if (obj instanceof Ejercicio){
                Ejercicio e = (Ejercicio) obj;
                e.setRevisado(true);
                System.out.println(" ✅ Ejercicio " +e.getTitulo()+ " marcado como revisado");
            }
        }
    }

    //Main
    public static void main(String[] args){
        //crear dos materiales por subclase
        List<MaterialCurso> materiales = Arrays.asList(
                new Video("Gestión de bases de datos", "Jorge", 20),
                new Video("Multihilos", "Ana", 30),
                new Articulo("Programación Funcional", "Mario", 2000),
                new Articulo("Asincronía vs Concurrencia", "Manu", 2500),
                new Ejercicio("Tipos de Wildcards", "Lili"),
                new Ejercicio("Constructors, Getters y Setters", "Luis")
        );

        //Filtrar videos y ejercicios
        List<Video> videos = new ArrayList<>();
        List<Ejercicio> ejercicios = new ArrayList<>();
        for (MaterialCurso m : materiales) {
            if (m instanceof Video) {
                videos.add((Video) m);
            } else if (m instanceof Ejercicio) {
                ejercicios.add((Ejercicio) m);
            }
        }

        //Uso de métodos genéricos
        mostrarMateriales(materiales);
        contarDuracionVideos(videos);
        marcarEjerciciosRevisados(ejercicios);
    }
}

