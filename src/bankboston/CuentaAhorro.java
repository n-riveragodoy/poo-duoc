/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankboston;

/**
 *
 * @author Agustín Andrews y Nicolás Rivera
 */
public class CuentaAhorro extends CuentaBase {
    private final int topeMensualGiro = 3;
    private int girosRealizados = 0;
    
    public CuentaAhorro(int numero, int saldo) {
        super(numero, saldo);
    }
    
    @Override
    public boolean girar(int monto) {
        if (girosRealizados >= topeMensualGiro) {
            System.out.println("Límite de giros mensuales alcanzado.");
            return false;
        }
        
        if(super.girar(monto)) {
            girosRealizados++;
            return true;
        }
        return false;
    }
    
    public void reiniciarGirosMensuales() {
        girosRealizados = 0;
    }
}
