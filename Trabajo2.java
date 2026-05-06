import java.util.ArrayList;
import java.util.Scanner;
// ● Define una clase Candidato con atributos como nombre (String), partido (String) y votos (int, inicializado en 0). 
// ● Crea una clase Votante con un idVotante (String) y un booleano yaVoto (inicializado en false). 
// ● Crea una clase Eleccion que contenga un ArrayList de Candidato y un ArrayList de Votante.  
// ● Diseña el diagrama de clases con los sig. métodos: registrar candidatos, registrar votantes, emitir voto y mostrar resultados. 
// Aplicación de Bucles: 
// ● do-while: En la clase Eleccion, implementa un método emitirVoto(Votante votante) que simule el proceso de votación. Usa un do-while para presentar las opciones de candidatos al votante y solicitarle su elección, repitiendo la pregunta si la entrada es inválida o si el votante ya ha votado. 
// ● for: Utiliza un bucle for en la clase Eleccion para recorrer la lista de Candidato y mostrar sus nombres y partidos antes de la votación. 
// ● while: Después de la votación, usa un bucle while para iterar sobre la lista de Candidato y encontrar al ganador (el que tenga más votos). 

public class Trabajo2 {
    public static void main(String[] args) {
        Candidato candidato1 = new Candidato();
        candidato1.nombre = "Jemba";
        candidato1.partido = "Mainusaurios";

        Candidato candidato2 = new Candidato();
        candidato2.nombre = "Santox";
        candidato2.partido = "Santoxoidex";

        Votante votante1 = new Votante();
        votante1.idVotante = "1";

        Eleccion eleccion = new Eleccion();

        eleccion.candidatos.add(candidato1);
        eleccion.candidatos.add(candidato2);
        // eleccion.mostrarCandidato();
        eleccion.emitirVoto(votante1);
        eleccion.mostrarGanador();

    }
}

class Candidato {
    String nombre = "";
    String partido = "";
    int votos = 0;
}

class Votante {
    String idVotante = "";
    Boolean yaVoto = false;

}

class Eleccion {
    ArrayList<Candidato> candidatos = new ArrayList<>();
    ArrayList<Votante> votantes = new ArrayList<>();

    // void mostrarCandidato() {
    // for (Candidato candidato : candidatos) {
    // System.out.println(candidato.nombre + " ----- " + candidato.partido);
    // }
    // }

    void emitirVoto(Votante votante) {

        Scanner sc = new Scanner(System.in);

        int opcion = 0;

        do {

            System.out.println("Candidatos:");

            for (int i = 0; i < candidatos.size(); i++) {

                System.out.println((i + 1) + " - " + candidatos.get(i).nombre + " (" + candidatos.get(i).partido + ")");
            }

            System.out.print("Ingrese su voto: ");
            opcion = sc.nextInt();

            if (opcion < 1 || opcion > candidatos.size() || votante.yaVoto) {
                System.out.println("El candidato no existe o usted ya votó.");
            }

        } while (opcion < 1 || opcion > candidatos.size() || votante.yaVoto);

        candidatos.get(opcion - 1).votos++;

        votante.yaVoto = true;

        System.out.println("Voto registrado con éxito.");

    }

    void mostrarGanador() {
        Candidato ganador = candidatos.get(0); 

        for (int i = 0; i < candidatos.size(); i++ ) {
            if (candidatos.get(i).votos > ganador.votos  ) {
                ganador = candidatos.get(i);
            }
            i++;
        }
        System.out.println("El ganador de la votacion es " + ganador.nombre + " con " +  ganador.votos + " votos");
    }

}
