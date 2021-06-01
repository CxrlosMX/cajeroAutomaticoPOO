/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajeroautomaticoBasico.II;

import javax.swing.JOptionPane;

/**
 *
 * @author: CxrlosMX
 * @Git-Hub: https://github.com/CxrlosMX
 * @Phone: 953-212-97-27
 * @Email: LuisCRendon131@gmail.com
 * @Date: 1/06/2021
 *
 */
public class Uso_banco {

    public static void main(String args[]) {
        int op = 0, saldo, dni, nCuentas;
        String numeroCuenta, nombre, apellido;
        nombre = JOptionPane.showInputDialog(null, "Introdusca el nombre", "Introduciendo Nombre", 3);
        apellido = JOptionPane.showInputDialog(null, "Introdusca el apellido", "Introduciendo Apellido", 3);
        dni = Integer.parseInt(JOptionPane.showInputDialog(null, "Introdusca el DNI", "Introduciendo DNI", 3));
        nCuentas = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce el numero de cuentas que tiene", "Introduciendo Numero de cuentas", 3));
        Cliente c = new Cliente(nombre, apellido, dni, nCuentas);
        c.registroCuentas();
        do {
            try {
                op = Integer.parseInt(JOptionPane.showInputDialog(null, "*-*-*MENU-*-*-"
                        + "\n1.-Ingresar Dinero en la cuenta"
                        + "\n2.-Retirar Dinero en la cuenta"
                        + "\n3.-Consultar Dinero de la cuenta"
                        + "\n4.-Salir\n¿Que desea realizar?", "Menu", 3));
                switch (op) {
                    case 1: {
                        numeroCuenta = JOptionPane.showInputDialog(null, "Introdusca el numero de la cuenta", "Introduciendo Numero de la cuenta", 3);
                        saldo = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce la cantidad que desea depositar", "Introduciendo Deposito", 3));
                        c.realizarDeposito(numeroCuenta, saldo);
                        break;
                    }
                    case 2: {
                        numeroCuenta = JOptionPane.showInputDialog(null, "Introdusca el numero de la cuenta", "Introduciendo Numero de la cuenta", 3);
                        saldo = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce la cantidad que desea retirar", "Introduciendo retiro", 3));
                        c.realizarRetiro(numeroCuenta, saldo);

                        break;
                    }
                    case 3: {
                        numeroCuenta = JOptionPane.showInputDialog(null, "Introdusca el numero de la cuenta", "Introduciendo Numero de la cuenta", 3);
                        c.mostrar(numeroCuenta);

                        break;
                    }
                    case 4: {
                        JOptionPane.showMessageDialog(null, "Cerrando programa", "Cerrando programa", JOptionPane.WARNING_MESSAGE);
                        break;
                    }
                    default: {
                        JOptionPane.showMessageDialog(null, "Introduce valores validos por favor", "Valores no validos", JOptionPane.WARNING_MESSAGE);

                        break;
                    }
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Error de copilacion", 0);
            }

        } while (op != 4);

    }

}
