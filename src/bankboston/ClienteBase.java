/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankboston;

import java.util.Scanner;

/**
 *
 * @author Agustín Andrews y Nicolás Rivera
 */
public class ClienteBase {
    // Atributos de la clase
    private String rut, nombre, apellidoPaterno, apellidoMaterno, domicilio, comuna, telefono;
    private CuentaBase cuenta;
    
    // Constructor vacío
    public ClienteBase() {
    }
    
    // Constructor con atributos
    public ClienteBase(String rut, String nombre, String apellidoPaterno, String apellidoMaterno, String domicilio, String comuna, String telefono, CuentaBase cuenta) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.domicilio = domicilio;
        this.comuna = comuna;
        this.telefono = telefono;
        this.cuenta = cuenta;
    }
    
    // Getters y Setters
    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public CuentaBase getCuenta() {
        return cuenta;
    }

    public void setCuenta(CuentaBase cuenta) {
        this.cuenta = cuenta;
    }
    
    // Para dev - toString para verificar los datos
    @Override
    public String toString() {
        return "Cliente{" + "rut=" + rut + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", domicilio=" + domicilio + ", comuna=" + comuna + ", telefono=" + telefono + ", cuenta=" + cuenta + '}';
    }

    // Métodos custom
    /**
     * Realiza un depósito en la cuenta del cliente
     * @param montoDeposito Cantidad a depositar
     * @return true si el depósito fue exitoso, false en caso contrario
     */
    public boolean depositar(int montoDeposito) {
        return this.cuenta.depositar(montoDeposito);
    }
    
    /**
     * Realiza un giro de la cuenta del cliente
     * @param montoGiro Cantidad a girar
     * @return true si el giro fue exitoso, false en caso contrario
     */
    public boolean girar(int montoGiro) {
        return this.cuenta.girar(montoGiro);
    }
    
    /**
     * Consulta el saldo de la cuenta del cliente
     * @return Saldo actual
     */
    public int consultarSaldo() {
        return this.cuenta.getSaldo();
    }

    /**
     * Verifica si el cliente tiene saldo en su cuenta
     * @return true si tiene saldo, false en caso contrario
     */
    public boolean tieneSaldo() {
        return this.cuenta.tieneSaldo();
    }

    /**
     * Verifica si el cliente tiene saldo suficiente para un giro específico
     * @param monto Cantidad a verificar
     * @return true si hay saldo suficiente, false en caso contrario
     */
    public boolean tieneSaldoSuficiente(int monto) {
        return this.cuenta.tieneSaldoSuficiente(monto);
    }

    /**
     * Devuelve un resumen del cliente para mostrar en listados
     */
    public String getDatosResumidos() {
        return nombre + " " + apellidoPaterno + " (Cuenta: " + String.format("%09d", cuenta.getNumero()) + ")";
    }

    /**
     * Devuelve los datos completos del cliente en formato detallado para mostrar
     */
    public String getDatosDetallados() {
        String tipoCuenta = cuenta.getClass().getSimpleName().replace("Cuenta", "Cuenta ");
        return "Rut: " + rut + "\n" +
               "Nombre: " + nombre + "\n" +
               "Apellido paterno: " + apellidoPaterno + "\n" +
               "Apellido materno: " + apellidoMaterno + "\n" +
               "Domicilio: " + domicilio + "\n" +
               "Comuna: " + comuna + "\n" +
               "Teléfono: " + telefono + "\n" +
               "Tipo de cuenta: " + tipoCuenta.trim() + "\n" +
               "Número de cuenta: " + String.format("%09d", cuenta.getNumero()) + "\n" +
               "Saldo: " + cuenta.getSaldo() + " pesos";
    }

   public static ClienteBase registrarCliente(Scanner scanner) {
    System.out.println("\n=== REGISTRO DE CLIENTE ===");
    System.out.println("Para cancelar el registro y volver al menú principal en cualquier momento, escriba 'cancelar'");
    String rut = "", nombre = "", apellidoPaterno = "", apellidoMaterno = "";
    String domicilio = "", comuna = "", telefono = "";
    int tipoCuenta = 0;
    boolean registroCompleto = false;

    while (!registroCompleto) {
        System.out.print("Ingrese Rut: ");
        rut = scanner.nextLine();
        if (rut.equalsIgnoreCase("cancelar")) return null;
        if (rut.length() < 11 || rut.length() > 12) {
            System.out.println("Error: El Rut debe tener entre 11 y 12 caracteres.");
            continue;
        }

        System.out.print("Ingrese nombre: ");
        nombre = scanner.nextLine();
        if (nombre.equalsIgnoreCase("cancelar")) return null;
        if (nombre.isEmpty()) {
            System.out.println("Error: El nombre no puede estar vacío.");
            continue;
        }

        System.out.print("Ingrese apellido paterno: ");
        apellidoPaterno = scanner.nextLine();
        if (apellidoPaterno.equalsIgnoreCase("cancelar")) return null;
        if (apellidoPaterno.isEmpty()) {
            System.out.println("Error: El apellido paterno no puede estar vacío.");
            continue;
        }

        System.out.print("Ingrese apellido materno: ");
        apellidoMaterno = scanner.nextLine();
        if (apellidoMaterno.equalsIgnoreCase("cancelar")) return null;
        if (apellidoMaterno.isEmpty()) {
            System.out.println("Error: El apellido materno no puede estar vacío.");
            continue;
        }

        System.out.print("Ingrese domicilio: ");
        domicilio = scanner.nextLine();
        if (domicilio.equalsIgnoreCase("cancelar")) return null;
        if (domicilio.isEmpty()) {
            System.out.println("Error: El domicilio no puede estar vacío.");
            continue;
        }

        System.out.print("Ingrese comuna: ");
        comuna = scanner.nextLine();
        if (comuna.equalsIgnoreCase("cancelar")) return null;
        if (comuna.isEmpty()) {
            System.out.println("Error: La comuna no puede estar vacía.");
            continue;
        }

        System.out.print("Ingrese teléfono: ");
        telefono = scanner.nextLine();
        if (telefono.equalsIgnoreCase("cancelar")) return null;
        if (telefono.isEmpty()) {
            System.out.println("Error: El teléfono no puede estar vacío.");
            continue;
        }

        System.out.println("Seleccione tipo de cuenta:");
        System.out.println("1. Ahorro\n2. Corriente\n3. Crédito");
        System.out.print("Ingrese opción (1-3): ");
        String tipoCuentaStr = scanner.nextLine();
        if (tipoCuentaStr.equalsIgnoreCase("cancelar")) return null;
        try {
            tipoCuenta = Integer.parseInt(tipoCuentaStr);
            if (tipoCuenta < 1 || tipoCuenta > 3) {
                System.out.println("Opción inválida.");
                continue;
            }
        } catch (NumberFormatException e) {
            System.out.println("Debe ingresar un número.");
            continue;
        }

        registroCompleto = true;
    }

    CuentaBase cuenta;
    switch (tipoCuenta) {
        case 1 -> cuenta = new CuentaAhorro(0);
        case 2 -> cuenta = new CuentaCorriente(0);
        case 3 -> cuenta = new CuentaCredito(0);
        default -> throw new IllegalStateException("Tipo de cuenta inválido");
    }

    ClienteBase nuevoCliente = new ClienteBase(rut, nombre, apellidoPaterno, apellidoMaterno, domicilio, comuna, telefono, cuenta);
    System.out.println("¡Cliente registrado exitosamente! Número de cuenta: " + cuenta.getNumero());
    return nuevoCliente;
}

}
