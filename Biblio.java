/* Descripción: Desarrolla un sistema para gestionar libros en una biblioteca digital, permitiendo agregar, buscar y "prestar" libros. 



Requisitos de POO: 


● Crea una clase Libro con atributos como titulo (String), autor (String), isbn (String), anioPublicacion (int) y disponible (boolean, inicializado en true). 
● Crea una clase Usuario con nombre (String), idUsuario (String) y una lista de Libro prestados. 
● Crea una clase Biblioteca que contenga un ArrayList de Libro.  
● Diseña el diagrama de clases con los sig. métodos: agregar libros, buscar libros por título/autor, prestar libro a un usuario y devolver libro. 


Aplicación de Bucles: 


●DONE// while: En la clase Biblioteca, implementa un método buscarLibro(String criterio, String valor) que permita buscar libros. Usa un bucle while para 
recorrer la lista de libros y agregar aquellos que coincidan con el criterio (título o autor) a una nueva lista que será devuelta. 
● DONE//do-while: En un método prestarLibro(String isbn, Usuario usuario), usa un do-while para simular el intento de préstamo. El bucle podría repetirse si el libro no está disponible o si el ISBN no existe, permitiendo al usuario intentar con otro ISBN (simulación de entrada de usuario). 
● for: En la clase Usuario, utiliza un bucle for para mostrar los libros que el usuario tiene actualmente prestados. 


 */


//NOTA PERSONAL: faltaria 
// separar los inputs(hacerlos derecho en el main) y 
// funcionalizar un menu de seleccion
// checkear tipos
//package isaui;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class Biblio {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

    Biblioteca biblio = new Biblioteca();

    Usuario usuario1 = new Usuario();
    usuario1.idUsuario = "1";
    usuario1.nombre = "Pablo";

    int opcion;

    do {

        Menu.mostrarMenu();
        System.out.print("Ingrese su opcion: ");

        opcion = Integer.parseInt(sc.nextLine());


        switch (opcion) {

            case 1:

                biblio.registrarLibro(sc);

                break;

            case 2:

                ArrayList<Libro> encontrados =
                    biblio.buscarLibro(
                        "autor",
                        "Stephen King"
                    );

                for (Libro libro : encontrados) {

                    System.out.println(libro.titulo);
                }

                break;

            case 3:

                biblio.prestarLibro(usuario1, sc);

                break;

            case 4:

                biblio.devolverLibro("1234", usuario1);

                break;
            case 5:
                usuario1.verPrestados();
                break;    

            case 0:

                System.out.println("Saliendo...");
                break;

            default:

                System.out.println("Opcion invalida");
        }

    } while (opcion != 0);
        }
    }

class Libro {
    String titulo;
    String autor;
    String isbn;
    String anioPublicacion;
    boolean disponible = true;
}

class Usuario {
    String idUsuario;
    String nombre;
    ArrayList<Libro> librosPrestados = new ArrayList<>();

    void verPrestados() {
        System.out.println("LISTA DE LIBROS PRESTADOS");
        for (Libro libro : librosPrestados) {
            System.out.print(libro.titulo + "-" + libro.autor);
        }
        if (librosPrestados.size()==0){
            System.out.println("No tiene libros en su posesion");
        }

    }
}

class Biblioteca {
    ArrayList<Libro> libros = new ArrayList<>();

    void registrarLibro(Scanner sc) {
        Libro libro = new Libro();
        System.out.println("INGRESAR NUEVO LIBRO");
        System.out.print("Titulo: ");
        libro.titulo = sc.nextLine();

        System.out.print("Autor: ");
        libro.autor = sc.nextLine();

        System.out.print("ISBN: ");
        libro.isbn = sc.nextLine();

        System.out.print("Anio de publicacion: ");
        libro.anioPublicacion = sc.nextLine();

        libros.add(libro);

        System.out.println("Libro agregado correctamente.");
        // sc.close();

    }

    void agregarLibro(Libro libro) {
        libros.add(libro);

    }

    ArrayList<Libro> buscarLibro(String criterio, String valor) {
        System.out.println("BUSCADOR");

        ArrayList<Libro> resultados = new ArrayList<>();

        int i = 0;

        while (i < libros.size()) {

            Libro libro = libros.get(i);

            boolean coincide = false;


            if (criterio.equalsIgnoreCase("titulo")) {

                coincide = libro.titulo.equalsIgnoreCase(valor);

            } else if (criterio.equalsIgnoreCase("autor")) {

                coincide = libro.autor.equalsIgnoreCase(valor);
            }

            if (coincide) {

                resultados.add(libro);
            }

            i++;
        }

        return resultados;
    }

void prestarLibro(Usuario usuario, Scanner sc) {

    boolean prestado = false;

    do {

        System.out.print("Ingrese ISBN: ");

        String isbn = sc.nextLine();

        boolean encontrado = false;

        for (Libro libro : libros) {

            if (libro.isbn.equals(isbn) && libro.disponible) {

                usuario.librosPrestados.add(libro);

                libro.disponible = false;

                System.out.println(
                    "Libro prestado correctamente"
                );

                encontrado = true;
                prestado = true;

                break;
            }
        }

        if (!encontrado) {

            System.out.println(
                "ISBN inexistente o libro no disponible."
            );
        }

    } while (!prestado);
}


void devolverLibro(String isbn, Usuario usuario) {

    boolean encontrado = false;

    for (int i = 0; i < usuario.librosPrestados.size(); i++) {

        Libro libro = usuario.librosPrestados.get(i);

        if (libro.isbn.equals(isbn)) {

            libro.disponible = true;

            usuario.librosPrestados.remove(i);

            System.out.println(
                "Libro devuelto correctamente: "
                + libro.titulo
            );

            encontrado = true;

            break;
        }
    }

    if (!encontrado) {

        System.out.println(
            "El usuario no tiene un libro con ese ISBN o no tiene libros a devolver."
        );
    }
}

}

class Menu {

    

    static void mostrarMenu(){
        System.out.println("\n--- Biblioteca Digital ---");
        System.out.println("1 - Registrar libro");
        System.out.println("2 - Buscar libro");
        System.out.println("3 - Prestar libro");
        System.out.println("4 - Devolver libro");
        System.out.println("5 - Ver prestados");
        System.out.println("0 - Salir");
    }
}