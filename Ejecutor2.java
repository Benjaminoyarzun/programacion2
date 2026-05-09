import java.util.Scanner;

public class Ejecutor2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        menuSimple.ejecutar(sc); 
        pedirPositivo.ingresarNum(sc); 
        asegurarPrint.imprimir(); 
        multiplicador.multiplicar();
    }

}

class menuSimple {

    public static void ejecutar(Scanner sc) {

        int opcion;

        do {

            System.out.println("MENU");
            System.out.println("1 - Opcion 1");
            System.out.println("2 - Opcion 2");
            System.out.println("3 - Opcion 3");
            System.out.println("0 - ver de nuevo");

            System.out.print("Ingrese opcion: ");

            opcion = sc.nextInt();

        } while (opcion == 0);

        System.out.println("Programa finalizado.");
    }
}

class pedirPositivo  {
    public static void ingresarNum(Scanner sc) {
        int num;
        do {
            System.out.println("Ingrese un numero positivo: ");
            num= sc.nextInt();
            if (num<=0) {
                System.out.println("Numero incorrecto. Ingrese un numero positivo");
                
            } else {
                System.out.println("Programa finalizado");
            }
            
        } while (num<=0);


        
    }

    
}

class asegurarPrint{
    public static void imprimir() {
        int i=1;
        do {
            System.out.println(i);
            i++;
            
        } while (i<=3);
    }

}

class multiplicador{
    public static void multiplicar(){
        
        for (int i = 1; i < 6; i++) {
            System.out.printf("tabla del %d%n", i );
            for (int mult = 1; mult < 11; mult++) {
                int resultado=i*mult;
                System.out.printf("%d*%d= %d%n", i, mult, resultado );
                
            }

            
        }
    }
}