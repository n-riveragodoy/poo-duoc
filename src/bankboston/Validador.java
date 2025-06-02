/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankboston;

import java.util.Scanner;

/**
 *
 * @author nrivera
 */
public class Validador {
    public static int validarEntradaInt(int entradaInt, int limiteMin, int limiteMax, Scanner scanner) {
        while (entradaInt < limiteMin || entradaInt > limiteMax) {
            System.out.println("Entrada no válida");
            System.out.println("Ingrese un número entre " + limiteMin + " y " + limiteMax + ":");
            entradaInt = scanner.nextInt();
        }
        return entradaInt;
    }

    public static String validarEntradaString(String entradaString, Scanner scanner) {

        while (!entradaString.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
            System.out.print("Ingrese texto válido (solo letras y espacios):\n");
            entradaString = scanner.nextLine();
        }

        entradaString = entradaString.trim();
        return entradaString.substring(0, 1).toUpperCase() + entradaString.substring(1).toLowerCase();
    }
    
    public static String validarSiONo(String entradaSiNo, Scanner scanner) {
        entradaSiNo = Validador.validarEntradaString(entradaSiNo, scanner);

        while (!(entradaSiNo.equalsIgnoreCase("sí") || 
                 entradaSiNo.equalsIgnoreCase("si") || 
                 entradaSiNo.equalsIgnoreCase("no"))) {
            System.out.println("Respuesta no válida. Escriba 'sí' o 'no': ");
            entradaSiNo = Validador.validarEntradaString(scanner.next(), scanner);
        }

        return entradaSiNo;
    }
    
    public static String validarRut(String rut, Scanner scanner) {
        rut = rut.trim();
        while (!rut.matches("[-0-9kK.]+") || !(rut.length()<=12 && rut.length() >= 11)) {
            System.out.print("Ingrese rut válido (números, punto y guion / ej. 12.345.678-9):\n");
            rut = scanner.nextLine();
            rut = rut.trim();
        }

        return rut;
    }
    
    public static int obtenerOpcion(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
    
}
