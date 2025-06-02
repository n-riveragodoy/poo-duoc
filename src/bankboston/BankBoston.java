/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bankboston;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Agustín Andrews y Nicolás Rivera
 */
public class BankBoston {
    // Lista de clientes
    private static ArrayList<ClienteBase> clientes = new ArrayList<>();
    private static ClienteBase clienteActual;
    private static final Scanner scanner = new Scanner(System.in);
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try (scanner) {
            boolean salir = false;
            
            while (!salir) {
                mostrarMenu();
                int opcion = Validador.obtenerOpcion(scanner);
                
                switch (opcion) {
                    case 1 -> {
                        ClienteBase cliente = ClienteBase.registrarCliente(scanner);
                        if (cliente != null) {
                            clientes.add(cliente);
                            clienteActual = cliente;
                        } else {
                            System.out.println("No se registró ningún cliente.");
                        }               
                    }
                    case 2 -> {
                        ClienteBase cliente = ClienteManager.seleccionarCliente(clientes, scanner);
                        if (cliente != null) ClienteManager.verDatosCliente(cliente);
                    }
                    case 3 -> {
                        ClienteBase cliente = ClienteManager.seleccionarCliente(clientes, scanner);
                        if (cliente != null) ClienteManager.realizarDeposito(cliente, scanner);
                    }
                    case 4 -> {
                        ClienteBase cliente = ClienteManager.seleccionarCliente(clientes, scanner);
                        if (cliente != null) ClienteManager.realizarGiro(cliente, scanner);
                    }
                    case 5 -> {
                        ClienteBase cliente = ClienteManager.seleccionarCliente(clientes, scanner);
                        if (cliente != null) ClienteManager.consultarSaldo(cliente);
                    }
                    case 6 -> {
                        System.out.println("Gracias por utilizar Bank Boston. ¡Hasta pronto!");
                        salir = true;
                    }
                    default -> System.out.println("Opción no válida. Por favor intente nuevamente.");
                }
            }
        }
    }
    
    private static void mostrarMenu() {
        System.out.println("\n===== BANK BOSTON =====");
        System.out.println("1. Registrar cliente");
        System.out.println("2. Ver datos de cliente");
        System.out.println("3. Depositar");
        System.out.println("4. Girar");
        System.out.println("5. Consultar saldo");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
    }

}
