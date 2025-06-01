/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankboston;

/**
 *
 * @author Agustín Andrews y Nicolás Rivera
 */
public class CuentaCredito extends CuentaBase {
    private final int lineaCredito = 500000; // Línea de crédito máxima permitida (saldo puede llegar a -500000)

    public CuentaCredito(int numero, int saldo) {
        super(numero, saldo);
    }

    @Override
    public boolean girar(int monto) {
        if (monto <= 0) {
            return false;
        }
        // Permite girar hasta el tope de la línea de crédito
        if (getSaldo() - monto < -lineaCredito) {
            System.out.println("Error: Excede el tope de la línea de crédito (" + lineaCredito + ").");
            return false;
        }
        setSaldo(getSaldo() - monto);
        return true;
    }

    @Override
    public boolean tieneSaldo() {
        // Siempre puede girar mientras no supere el tope de la línea de crédito
        return getSaldo() > -lineaCredito;
    }

    @Override
    public boolean tieneSaldoSuficiente(int monto) {
        // Puede girar si no supera el tope de la línea de crédito
        return (getSaldo() - monto) >= -lineaCredito;
    }

    // TODO: Lógica especifica de cuentas de crédito
}
