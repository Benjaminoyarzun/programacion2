import java.util.ArrayList;
import java.util.Scanner;
// Ejercicio 1: Gestión de Pedidos Online 
// Descripción: Desarrolla un sistema básico para gestionar pedidos de una tienda online. Cada pedido puede contener múltiples productos. 
// Requisitos de POO: 

// ● Crea una clase Producto con atributos como nombre (String), precio (double) y cantidadDisponible (int). 
// ● Crea una clase ItemPedido con atributos como producto (objeto Producto) y cantidadSolicitada (int). 
// ● Crea una clase Pedido con un ArrayList de ItemPedido, un idPedido (String) y un estado (String, ej: "Pendiente", "Completado"). 
// ● Diseña el diagrama de clases con los sig. métodos: agregar items, calcular el total del pedido y cambiar el estado. 

// Aplicación de Bucles: 
// ● for: Utiliza un bucle for en la clase Pedido para iterar sobre la lista de ItemPedido y calcular el precio total del pedido. 
// ● while: En un método de la clase Pedido, simula la confirmación de disponibilidad de productos. Usa un bucle while para verificar si la cantidadSolicitada de cada ItemPedido es menor o igual a la cantidadDisponible del Producto asociado. Si no lo es, "solicita" al usuario que ajuste la cantidad hasta que sea válida (simulación de entrada de usuario). 
// ● do-while: Implementa un método en la clase Pedido para "procesar" el pedido. Dentro de este método, utiliza un do-while para simular un proceso iterativo de empaquetado de items, decrementando la cantidadDisponible de cada producto hasta que sea cero o se haya procesado la cantidadSolicitada. 

public class Trabajo1 {
    public static void main(String[] args) {
        Producto mouse = new Producto();
        mouse.nombre = "Mouse";
        mouse.precio = 1500;
        mouse.cantidadDisponible = 2;

        Producto teclado = new Producto();
        teclado.nombre = "Teclado";
        teclado.precio = 2000;
        teclado.cantidadDisponible = 3;

        ItemPedido item1 = new ItemPedido();
        ItemPedido item2 = new ItemPedido();
        item1.producto = mouse;
        item1.cantidadSolicitada = 2;
        item2.producto = teclado;
        item2.cantidadSolicitada = 5;

        Pedido pedido1 = new Pedido();
        pedido1.idPedido = "12345";
        pedido1.items.add(item1);
        pedido1.items.add(item2);

        double totalPedido = pedido1.calcularTotal();
        System.out.println("Total del pedido: " + totalPedido);

        pedido1.verificarDisponibilidad();
        pedido1.procesarPedido();
    }
}

class Producto {
    String nombre = "";
    double precio = 0.0;
    int cantidadDisponible = 0;
}

class ItemPedido {
    Producto producto = new Producto();
    int cantidadSolicitada = 0;
}

class Pedido {
    ArrayList<ItemPedido> items = new ArrayList<>();

    String idPedido = "";
    String estado = "Pendiente";

    double calcularTotal() {
        double total = 0.0;
        for (ItemPedido item : items) {
            total += item.producto.precio * item.cantidadSolicitada;
        }
        return total;

    }

    void verificarDisponibilidad() {
        Scanner sc = new Scanner(System.in);
        for (ItemPedido item : items) {
            while (item.cantidadSolicitada > item.producto.cantidadDisponible) {
                System.out.println("No hay suficiente stock de: " + item.producto.nombre);
                System.out.println("Tenemos disponible: " + item.producto.cantidadDisponible + " unidades de "
                        + item.producto.nombre);
                System.out.print("Ingrese una nueva cantidad: ");
                item.cantidadSolicitada = sc.nextInt();
            }
        }
        System.out.println("Pedido realizado con exito!");
        sc.close();

    }

    void procesarPedido() {
        for (ItemPedido item : items) {
            int procesados = 0;
            do {
                item.producto.cantidadDisponible -= 1;
                procesados++;

            } while (procesados < item.cantidadSolicitada && item.producto.cantidadDisponible > 0);
            System.out.println("Procesando pedido...");
            cambiarEstado("Completado");
            System.out.println("Pedido de " + item.producto.nombre + " " + estado);

        }
    }

    void agregarItem(ItemPedido item) {
        items.add(item);
    }

    void cambiarEstado(String nuevoEstado) {
        estado = nuevoEstado;
    }
}
