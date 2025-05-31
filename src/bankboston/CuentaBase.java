/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankboston;

/**
 *
 * @author aandr
 */
public abstract class CuentaBase implements Cuenta {
    // Atributos de la clase
    private int numero, saldo;
    
    // Constructor vacío
    public CuentaBase() {
    }
    
    // Constructor con atributos
    public CuentaBase(int numero, int saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }
    
    // Getters y Setters
    @Override
    public int getNumero() {
        return numero;
    }

    @Override
    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public int getSaldo() {
        return saldo;
    }

    @Override
    public int setSaldo(int saldo) {
        this.saldo = saldo;
        return this.saldo;
    }
    
    // Para dev - toString para verificar los datos
    @Override
    public String toString() {
        return "Cuenta{" + "numero=" + numero + ", saldo=" + saldo + '}';
    }
    
    // Métodos custom

    /**
     * Realiza un depósito en la cuenta
     * @param monto Cantidad a depositar
     * @return true si el depósito fue exitoso, false en caso contrario
     */
    @Override
    public boolean depositar(int monto) {
        if (monto <= 0) {
            return false;
        }
        this.saldo += monto;
        return true;
    }

    /**
     * Realiza un giro de la cuenta
     * @param monto Cantidad a girar
     * @return true si el giro fue exitoso, false en caso contrario
     */
    @Override
    public boolean girar(int monto) {
        if (monto <= 0) {
            return false;
        }
        if (monto > this.saldo) {
            return false;
        }
        this.saldo -= monto;
        return true;
    }

    /**
     * Verifica si hay saldo suficiente para realizar operaciones
     * @return true si hay saldo, false si no hay saldo
     */
    @Override
    public boolean tieneSaldo() {
        return this.saldo > 0;
    }
    
    /**
     * Verifica si hay saldo suficiente para un giro específico
     * @param monto Cantidad a verificar
     * @return true si hay saldo suficiente, false en caso contrario
     */
    @Override
    public boolean tieneSaldoSuficiente(int monto) {
        return this.saldo >= monto;
    }
    
}
