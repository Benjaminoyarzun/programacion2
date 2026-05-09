import java.util.ArrayList;

public class Gestor {
    public static void main(String[] args) {
        
    }
    
}
 class Tarea {
    String nombre;
    String descripcion;
    String estado;
    String fechaLimite;
    


    
}
 class miembroEquipo {
    String nombre;
    String rol;
    ArrayList <Tarea> tareasAsignadas = new ArrayList<>();
 
    
}
 class Proyecto{
    String nombre;
    String fechaInicio;
    String fechaFinEstimada;
    ArrayList<Tarea> tareasProyecto = new ArrayList<>();
    ArrayList<miembroEquipo> miembrosProyecto = new ArrayList<>();


}