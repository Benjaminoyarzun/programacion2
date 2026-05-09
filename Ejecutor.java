import java.util.Scanner;

public class Ejecutor {
    public static void main(String[] args) {
        System.out.println("Contador del 1 al 10:");
        Contador.contar();

        System.out.println("\nNúmeros pares del 0 al 50:");
        Pares.mostrarPares();
        System.out.println("Acumulador del 0 al 100:");
        Acumulador.mostrarAcumulador();
        System.out.println("Regresiva del 5 al 1:");
        Regresiva.mostrarRegresiva();
        System.out.println("Validacion: ");
        Validacion.mostrarValidacion();
        System.out.println("Adivina: ");
        Adivina.mostrarAdivina();

    }
}

class Contador {
    public static void contar() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }
    }
}

class Pares {
    public static void mostrarPares() {
        for (int i = 0; i <= 50; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}

class Acumulador {
    public static void mostrarAcumulador() {
        int total = 0;
        for (int i = 0; i <= 100; i++){
            total += i;

        }
        System.out.println(total);

    }
}

class Regresiva {
    public static void mostrarRegresiva() {
        int numero = 6;
        while (numero > 1) {
            numero = numero-1;
            System.out.println(numero);
        }
        System.out.println("Despegue!");
    }
}

class Validacion {
    public static void mostrarValidacion() {
        Scanner sc = new Scanner(System.in);
        int contraseña = 0;

        while (contraseña != 123) {
            System.out.print("Ingrese la contraseña: ");
            contraseña = sc.nextInt();

            if (contraseña == 123) {
                System.out.println("Contraseña correcta, acceso permitido");
            } else {
                System.out.println("Contraseña incorrecta, acceso denegado");
            }
        }

        sc.close();
    }
}

class Adivina {
    public static void mostrarAdivina() {
        int numero = 5;
        int guess = 0;
        Scanner sc = new Scanner(System.in);
        while (guess != numero){
            System.out.print("Adivina el numero: ");
            guess = sc.nextInt();
            if (guess == numero) {
                System.out.println("Adivinaste");
            } else {
                System.out.println("La pifiaste");
            }
        }
        sc.close();
    }
}