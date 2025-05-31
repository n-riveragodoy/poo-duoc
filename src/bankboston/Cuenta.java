/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bankboston;

/**
 *
 * @author Agustín Andrews y Nicolás Rivera
 */
public interface Cuenta {
    int getNumero();
    void setNumero(int numero);
    int getSaldo();
    int setSaldo(int numero);
    boolean depositar(int monto);
    boolean girar(int monto);
    boolean tieneSaldo();
    boolean tieneSaldoSuficiente(int monto);
}
