package bankboston;

import java.util.ArrayList;
import java.util.Scanner;

public class ClienteManager {

    public static ClienteBase seleccionarCliente(ArrayList<ClienteBase> clientes, Scanner scanner) {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return null;
        }
        System.out.println("\n=== LISTADO DE CLIENTES ===");
        for (int i = 0; i < clientes.size(); i++) {
            ClienteBase cliente = clientes.get(i);
            System.out.println((i + 1) + ". " + cliente.getDatosResumidos());
        }
        System.out.print("Seleccione un cliente por número: ");
        try {
            int seleccion = Integer.parseInt(scanner.nextLine());
            if (seleccion < 1 || seleccion > clientes.size()) {
                System.out.println("Selección inválida. Cliente inexistente.");
                return null;
            }
            return clientes.get(seleccion - 1);
        } catch (NumberFormatException e) {
            System.out.println("Selección inválida. Cliente inexistente.");
            return null;
        }
    }

    public static void consultarSaldo(ClienteBase cliente) {

        System.out.println("\n=== CONSULTA DE SALDO ===");
        System.out.println("Saldo actual: " + cliente.getCuenta().getSaldo() + " pesos");
    }

        public static void verDatosCliente(ClienteBase cliente) {
        
        System.out.println("\n=== DATOS DEL CLIENTE ===");
        System.out.println(cliente.getDatosDetallados());
    }

        public static void realizarDeposito(ClienteBase cliente, Scanner scanner) {

        System.out.println("\n=== REALIZAR DEPÓSITO ===");
        System.out.print("Ingrese un monto para depositar: ");
        try {
            int monto = Integer.parseInt(scanner.nextLine());
            if (cliente.getCuenta().depositar(monto)) {
                System.out.println("¡Depósito realizado de manera exitosa!");
                System.out.println("El cliente tiene un saldo actual de " + cliente.getCuenta().getSaldo() + " pesos.");
            } else {
                System.out.println("Error: El monto a depositar debe ser mayor a cero."); 
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: El monto debe ser un valor numérico.");
        }
    }

    public static void realizarGiro(ClienteBase cliente, Scanner scanner) {
        
        System.out.println("\n=== REALIZAR GIRO ===");
        if (!cliente.getCuenta().tieneSaldo()) {
            System.out.println("Error: No tiene saldo suficiente para realizar giros.");
            return;
        }
        System.out.print("Ingrese un monto para girar: ");
        try {
            int monto = Integer.parseInt(scanner.nextLine());
            if (monto <= 0) {
                System.out.println("Error: El monto a girar debe ser mayor a cero.");
                return;
            }
            if (!cliente.getCuenta().tieneSaldoSuficiente(monto)) {
                System.out.println("Error: El monto a girar excede su saldo actual de " + cliente.getCuenta().getSaldo() + " pesos.");
                return;
            }
            if (cliente.getCuenta().girar(monto)) {
                System.out.println("¡Giro realizado de manera exitosa!");
                System.out.println("El cliente tiene un saldo actual de " + cliente.getCuenta().getSaldo() + " pesos.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: El monto debe ser un valor numérico.");
        }
    }

}
