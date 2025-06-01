/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bankboston;

/**
 *
 * @author aandr
 */
public interface Cliente {
    String getRut();
    void setRut(String rut);
    String getNombre();
    void setNombre(String nombre);
    String getApellidoPaterno();
    void setApellidoPaterno(String apellidoPaterno);
    String getApellidoMaterno();
    void setApellidoMaterno(String apellidoMaterno);
    String getDomicilio();
    void setDomicilio(String domicilio);
    String getComuna();
    void setComuna(String comuna);
    String getTelefono();
    void setTelefono(String telefono);
    CuentaBase getCuenta();
    void setCuenta(CuentaBase cuenta);
    String toString();
    String getDatosResumidos();
    String getDatosDetallados();
}
