//NOTA: faltaria ponerle menu, y revisar que la tarea asignada a un miembro formara parte previamente del proyecto (con agregarTarea())

import java.util.ArrayList;
import java.util.Scanner;

public class Gestor {
    public static void main(String[] args) {
        System.out.println("GESTOR DE TAREAS");
        Proyecto proyecto=new Proyecto();
        miembroEquipo miembro1=new miembroEquipo();
        miembroEquipo miembro2=new miembroEquipo();
        proyecto.miembrosProyecto.add(miembro1);
        miembro1.nombre="Juan";
        miembro1.rol= "Frontend Dev";
        
        proyecto.miembrosProyecto.add(miembro2);
        miembro2.nombre="Ana";
        miembro2.rol="Backend Dev";
        proyecto.asignarTarea(null);

    }

}

class Tarea {
    String nombre;
    String descripcion;
    String estado="pendiente";
    String fechaLimite;

    void actualizarEstado(Scanner sc) {

    String nuevoEstado;

    do {

        System.out.println("""
        Estados validos:
        - Pendiente
        - En Progreso
        - Completada
        """);

        System.out.print(
            "Ingrese nuevo estado: "
        );

        nuevoEstado = sc.nextLine();

    } while (
        !nuevoEstado.equalsIgnoreCase("Pendiente")
        &&
        !nuevoEstado.equalsIgnoreCase("En Progreso")
        &&
        !nuevoEstado.equalsIgnoreCase("Completada")
    );

    estado = nuevoEstado;

    System.out.println(
        "Estado actualizado."
    );
}
}

class miembroEquipo {
    String nombre;
    String rol;
    ArrayList<Tarea> tareasAsignadas = new ArrayList<>();

}

class Proyecto {
    String nombre;
    String fechaInicio;
    String fechaFinEstimada;
    ArrayList<Tarea> tareasProyecto = new ArrayList<>();
    ArrayList<miembroEquipo> miembrosProyecto = new ArrayList<>();

    void checkearTareas() {
        for (Tarea tarea : tareasProyecto) {
            System.out.printf("%s - %s", tarea.nombre, tarea.estado);

        }
    }

    void agregarTarea(Tarea tarea) {
        tareasProyecto.add(tarea);
    }


    void asignarTarea(Tarea tarea) {
        int i = 0;

        while (i < miembrosProyecto.size()) {

            miembroEquipo miembro = miembrosProyecto.get(i);

            if (miembro.tareasAsignadas.size() < 3) {

                miembro.tareasAsignadas.add(tarea);

                System.out.printf( "Tarea asignada a %s",miembro.nombre);

                return;
            }

            i++;
        }

        System.out.println(
                "No hay miembros disponibles.");

    }
}