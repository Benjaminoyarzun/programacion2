/* 🔹 Nivel 1 – Fundamentos de métodos (sin arrays)


1. Mostrar mensaje fijo


Crear un método llamado mostrarSaludo() que imprima “Hola, mundo”.


2. Saludo personalizado


Crear un método llamado saludar(String nombre) que reciba un nombre como
parámetro e imprima un saludo.


3. Área de un rectángulo


Crear un método que reciba dos argumentos (base, altura) y devuelva el área del
rectángulo.


4. Convertir a mayúsculas


Crear un método que reciba una cadena de texto y devuelva esa cadena en mayúsculas.


5. Mostrar menú


Crear un método sin argumentos ni retorno que imprima un menú con varias opciones.

*/







public class Funciones {
    public static void main(String[] args) {
        NivelUno.mostrarSaludo();

        NivelUno.saludar("Benjamin");

        double area = NivelUno.calcularArea(
                2.0,
                4.0);

        System.out.printf(
                "El area del rectangulo es %.2f%n",
                area);

        String mayusculas = NivelUno.devolverMayusculas(
                "hola mundo");

        System.out.println(
                mayusculas);

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
    int[] datos = {1,2,3,4};

    NivelCuatro.formatearArray(datos);
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

/* 🔹 Nivel 2 – Métodos con retorno y lógica


6. Número par o impar


Crear un método esPar(int numero) que devuelva true si el número es par, y
false si es impar.


7. Calcular el cuadrado de un número


Crear un método que reciba un entero y devuelva su cuadrado.


8. Factorial recursivo


Crear un método recursivo que calcule el factorial de un número.

 */


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
/* 🔹 Nivel 3 – Métodos con varargs y arrays


9. Sumar múltiples números (varargs)


Crear un método sumarNumeros(int... numeros) que reciba una cantidad
indefinida de enteros y devuelva la suma.


10. Promedio de un array


Crear un método que reciba un array de double y retorne el promedio.


11. Buscar valor en array


Crear un método que reciba un array de int y un número a buscar, y devuelva true si el número está presente.



12. Contar ocurrencias


Crear un método que reciba un array de String y un string clave, y devuelva cuántas veces aparece.
 */

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

/* 🔹 Nivel 4 – Métodos combinados y más complejos


13. Imprimir array de forma formateada


Crear un método que reciba un array de enteros y los imprima entre corchetes, separados por comas.


14. Invertir array


Crear un método que reciba un array de enteros y devuelva otro array con los valores en orden inverso.


15. Estudiante con mejor nota


Crear un método que reciba dos arrays: uno con nombres de estudiantes y otro con sus notas, y devuelva el nombre del estudiante con la mejor nota.
 */



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

}