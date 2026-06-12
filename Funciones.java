import java.util.Arrays;

public class Funciones {
    public static void main(String[] args) {
        NivelUno.mostrarSaludo();

        NivelUno.saludar("Benjamin");

        double area = NivelUno.calcularArea(2.0, 4.0);

        System.out.printf(
                "El area del rectangulo es %.2f%n",
                area);

        String mayusculas = NivelUno.devolverMayusculas(
                "hola mundo");

        System.out.println(mayusculas);

        NivelUno.mostrarMenu(); 
        boolean resultadoParidad= NivelDos.esPar(9);
         if (resultadoParidad) {

        System.out.println("Es par");

        } else {

        System.out.println("Es impar");
    }
    int numCuadrado= NivelDos.calcularCuadrado(4);
    System.out.println(numCuadrado);
    int factorial = NivelDos.calcularFactorial(3);
    System.out.println(factorial);
    int suma=(NivelTres.sumarNumero(1,3,3));
    System.out.println(suma);
    double [] lista={1.0, 2.0, 3.0};
    double promedio= NivelTres.calcularPromedio(lista);
    System.out.println(promedio);
    int[] datos = {5,8,3,10};
    
    boolean encontrado = NivelTres.buscarValor(datos,1);
    
    System.out.println(encontrado);
    String[] listaStrings= {"Hola", "Chau", "Jijo", "Hola", "Hola"};
    int numeroOcurrencias=NivelTres.contarOcurrencias(listaStrings, "Hola");
    System.out.println(numeroOcurrencias); 
    int[] datosB = {1,2,3,4};

    NivelCuatro.formatearArray(datosB);

    int[] numeros= {5,6,7,8};
    int[] arrayInvertido= NivelCuatro.invertirArray(numeros);
    System.out.println(Arrays.toString(arrayInvertido));

    int[] notas = {1,10,4,8};
    String[] nombres= {"Juan","Ana","Pedro","Benjamin"};
    System.out.println(NivelCuatro.sacarMejor(notas, nombres));
}

}


class NivelUno {

    static void mostrarSaludo() {

        System.out.println("Hola mundo");
    }

    static void saludar(String nombre) {

        System.out.printf(
            "Hola %s%n",
            nombre
        );
    }

    static double calcularArea(
        double base,
        double altura
    ) {

        return base * altura;
    }

    static String devolverMayusculas(
        String cadena
    ) {

        return cadena.toUpperCase();
    }

    static void mostrarMenu() {

        System.out.println("MENU");
        System.out.println("Opcion A");
        System.out.println("Opcion B");
        System.out.println("Opcion C");
    }
}


class NivelDos {


    static boolean esPar(int numero){
        return numero%2==0;
    }
    
    static int calcularCuadrado(int numero){
        return numero*numero;

    }
    
    static int calcularFactorial(int numero){
         if(numero == 0){
        return 1;
     }

    return numero * calcularFactorial(numero - 1);
    }
}

class NivelTres{
    static int sumarNumero(int...numeros){
        int suma=0;
       
        for (int numero:numeros){
            suma=suma+numero;

        }
        return suma;
    }

    static double calcularPromedio(double[] numeros){
        double suma=0;
        for (double numero:numeros){
            suma+=numero;
        }
        double promedio= suma/numeros.length;
        return promedio;

    }
    static boolean buscarValor (int[] numeros, int valorClave){
        for (int numero:numeros){
            if (numero == valorClave) {
                return true;

            }

        }
        return false;
    }

    static int contarOcurrencias (String[] datos, String stringClave){
        int contador=0;
        for (String dato:datos){
            if (dato.equals(stringClave)){
                contador++; 
            }
        }
        return contador;

    }

}


class NivelCuatro{
    static void formatearArray(int[] numeros){

        String resultado = "[";

        for(int i = 0; i < numeros.length; i++){

            resultado += numeros[i];

            if(i < numeros.length - 1){

                resultado += ", ";
            }
        }

        resultado += "]";

        System.out.println(resultado);
    }

    static int[] invertirArray(int[] numeros) {

        int[] invertido = new int[numeros.length];

        for (int i = 0; i < numeros.length; i++) {

            invertido[i] = numeros[numeros.length - 1 - i];
        }

        return invertido;
    }

    static String sacarMejor (int[] notas, String[] nombres){
        int indexMejor=0;
        for (int i = 0; i < notas.length; i++) {  
            if (notas[i]>notas[indexMejor]){
                indexMejor=i;

            }
            
        }
        return nombres[indexMejor];
    }
}
