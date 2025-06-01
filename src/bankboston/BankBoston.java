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
    
    private static int contadorCuentas = 1; // Contador para números de cuenta
    private static final Scanner scanner = new Scanner(System.in);
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try (scanner) {
            boolean salir = false;
            
            while (!salir) {
                mostrarMenu();
                int opcion = obtenerOpcion();
                
                switch (opcion) {
                    case 1 -> registrarCliente();
                    case 2 -> verDatosCliente();
                    case 3 -> realizarDeposito();
                    case 4 -> realizarGiro();
                    case 5 -> consultarSaldo();
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
    
    private static int obtenerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
    
    private static void registrarCliente() {
        System.out.println("\n=== REGISTRO DE CLIENTE ===");
        System.out.println("Para cancelar el registro y volver al menú principal en cualquier momento, escriba 'cancelar'");
        String rut = "", nombre = "", apellidoPaterno = "", apellidoMaterno = "";
        String domicilio = "", comuna = "", telefono = "";
        int tipoCuenta = 0;
        boolean registroCompleto = false;
        while (!registroCompleto) {
            if (rut.isEmpty()) {
                System.out.print("Ingrese Rut: ");
                rut = scanner.nextLine();
                if (rut.equalsIgnoreCase("cancelar")) {
                    System.out.println("Registro cancelado. Volviendo al menú principal...");
                    return;
                }
                if (rut.length() < 11 || rut.length() > 12) {
                    System.out.println("Error: El Rut debe tener entre 11 y 12 caracteres (incluyendo puntos, guión y dígito verificador).");
                    rut = "";
                    continue;
                }
            }
            if (nombre.isEmpty()) {
                System.out.print("Ingrese nombre: ");
                nombre = scanner.nextLine();
                if (nombre.equalsIgnoreCase("cancelar")) {
                    System.out.println("Registro cancelado. Volviendo al menú principal...");
                    return;
                }
                if (nombre.isEmpty()) {
                    System.out.println("Error: El nombre no puede estar vacío.");
                    continue;
                }
            }
            if (apellidoPaterno.isEmpty()) {
                System.out.print("Ingrese apellido paterno: ");
                apellidoPaterno = scanner.nextLine();
                if (apellidoPaterno.equalsIgnoreCase("cancelar")) {
                    System.out.println("Registro cancelado. Volviendo al menú principal...");
                    return;
                }
                if (apellidoPaterno.isEmpty()) {
                    System.out.println("Error: El apellido paterno no puede estar vacío.");
                    continue;
                }
            }
            if (apellidoMaterno.isEmpty()) {
                System.out.print("Ingrese apellido materno: ");
                apellidoMaterno = scanner.nextLine();
                if (apellidoMaterno.equalsIgnoreCase("cancelar")) {
                    System.out.println("Registro cancelado. Volviendo al menú principal...");
                    return;
                }
                if (apellidoMaterno.isEmpty()) {
                    System.out.println("Error: El apellido materno no puede estar vacío.");
                    continue;
                }
            }
            if (domicilio.isEmpty()) {
                System.out.print("Ingrese domicilio (Calle y número): ");
                domicilio = scanner.nextLine();
                if (domicilio.equalsIgnoreCase("cancelar")) {
                    System.out.println("Registro cancelado. Volviendo al menú principal...");
                    return;
                }
                if (domicilio.isEmpty()) {
                    System.out.println("Error: El domicilio no puede estar vacío.");
                    continue;
                }
            }
            if (comuna.isEmpty()) {
                System.out.print("Ingrese comuna: ");
                comuna = scanner.nextLine();
                if (comuna.equalsIgnoreCase("cancelar")) {
                    System.out.println("Registro cancelado. Volviendo al menú principal...");
                    return;
                }
                if (comuna.isEmpty()) {
                    System.out.println("Error: La comuna no puede estar vacía.");
                    continue;
                }
            }
            if (telefono.isEmpty()) {
                System.out.print("Ingrese teléfono: ");
                telefono = scanner.nextLine();
                if (telefono.equalsIgnoreCase("cancelar")) {
                    System.out.println("Registro cancelado. Volviendo al menú principal...");
                    return;
                }
                if (telefono.isEmpty()) {
                    System.out.println("Error: El teléfono no puede estar vacío.");
                    continue;
                }
            }
            if (tipoCuenta == 0) {
                System.out.println("Seleccione tipo de cuenta a contratar:");
                System.out.println("1. Cuenta de Ahorro");
                System.out.println("2. Cuenta Corriente");
                System.out.println("3. Cuenta de Crédito");
                System.out.print("Ingrese opción (1-3): ");
                String tipoCuentaStr = scanner.nextLine();
                if (tipoCuentaStr.equalsIgnoreCase("cancelar")) {
                    System.out.println("Registro cancelado. Volviendo al menú principal...");
                    return;
                }
                try {
                    tipoCuenta = Integer.parseInt(tipoCuentaStr);
                    if (tipoCuenta < 1 || tipoCuenta > 3) {
                        System.out.println("Error: Debe elegir una opción válida (1-3).");
                        tipoCuenta = 0;
                        continue;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: Debe ingresar un número válido.");
                    continue;
                }
            }
            registroCompleto = true;
        }

        // Generar número de cuenta con 9 dígitos
        int numeroCuenta = contadorCuentas++;
        
        CuentaBase cuenta;
        switch (tipoCuenta) {
            case 1 -> cuenta = new CuentaAhorro(numeroCuenta, 0);
            case 2 -> cuenta = new CuentaCorriente(numeroCuenta, 0);
            case 3 -> cuenta = new CuentaCredito(numeroCuenta, 0);
            default -> throw new IllegalStateException("Tipo de cuenta inválido");
        }
        ClienteBase nuevoCliente = new ClienteBase(rut, nombre, apellidoPaterno, apellidoMaterno, domicilio, comuna, telefono, cuenta);
        clientes.add(nuevoCliente);
        System.out.println("¡Cliente registrado exitosamente! Número de cuenta: " + String.format("%09d", numeroCuenta));
    }

    // Método para seleccionar un cliente de la lista
    private static ClienteBase seleccionarCliente() {
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
                System.out.println("Selección inválida.");
                return null;
            }
            return clientes.get(seleccion - 1);
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida.");
            return null;
        }
    }

    private static void verDatosCliente() {
        ClienteBase cliente = seleccionarCliente();
        if (cliente == null) return;
        System.out.println("\n=== DATOS DEL CLIENTE ===");
        System.out.println(cliente.getDatosDetallados());
    }

    private static void realizarDeposito() {
        ClienteBase cliente = seleccionarCliente();
        if (cliente == null) return;
        System.out.println("\n=== REALIZAR DEPÓSITO ===");
        System.out.print("Ingrese un monto para depositar: ");
        try {
            int monto = Integer.parseInt(scanner.nextLine());
            if (cliente.getCuenta().depositar(monto)) {
                System.out.println("¡Depósito realizado de manera exitosa!");
                System.out.println("El cliente tiene un saldo actual de " + cliente.getCuenta().getSaldo() + " pesos.");
            } else {
                System.out.println("Error: El monto a depositar debe ser mayor a cero."); // TODO: llevar lógica adentro de clase de cuenta
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: El monto debe ser un valor numérico.");
        }
    }

    private static void realizarGiro() {
        ClienteBase cliente = seleccionarCliente();
        if (cliente == null) return;
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

    private static void consultarSaldo() {
        ClienteBase cliente = seleccionarCliente();
        if (cliente == null) return;
        System.out.println("\n=== CONSULTA DE SALDO ===");
        System.out.println("Saldo actual: " + cliente.getCuenta().getSaldo() + " pesos");
    }
}
