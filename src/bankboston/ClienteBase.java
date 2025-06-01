/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankboston;

/**
 *
 * @author Agustín Andrews y Nicolás Rivera
 */
public class ClienteBase implements Cliente {
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
}
