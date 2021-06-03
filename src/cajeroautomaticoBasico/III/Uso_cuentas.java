/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajeroautomaticoBasico.III;

import javax.swing.JOptionPane;

/**
 *
 * @author: CxrlosMX
 * @Git-Hub: https://github.com/CxrlosMX
 * @Phone: 953-212-97-27
 * @Email: LuisCRendon131@gmail.com
 * @Date: 2/06/2021
 *
 */
public class Uso_cuentas {
    
    public static void main(String args[]) {
        
        Cliente c;
        Cuenta[] cuentas;
        int n = 0, numeroCuenta, op = 0, a = 0;
        double saldo;
        String nombre, apellido, dni;
        //Pidiendo los datos del clientes
        nombre = JOptionPane.showInputDialog(null, "Introduzca su nombre de Cliente", "Introduciendo Nombre de clientes", 3);
        apellido = JOptionPane.showInputDialog(null, "Introduzca su apellido por favor", "Introduciendo apellido", 3);
        dni = JOptionPane.showInputDialog(null, "Introduzca su DNI por favor", "Introduciendo DNI", 3);
        n = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduzca la cantidad de cuentas", "Introduciendo las cuentas", 3));
        cuentas = new Cuenta[n];
        //Rellenamos las cuentas
        for (int i = 0; i < cuentas.length; i++) {
            numeroCuenta = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce el numero de cuenta por favor", "Rellenando la cuenta " + (i + 1), 3));
            saldo = Double.parseDouble(JOptionPane.showInputDialog(null, "Introduce el saldo de la cuenta", "Rellenando la cuenta " + (i + 1), 3));
            cuentas[i] = new Cuenta(numeroCuenta, saldo);
        }
        
        c = new Cliente(nombre, apellido, dni, cuentas);

        //Menu
        do {
            try {
                op = Integer.parseInt(JOptionPane.showInputDialog(null, "*-*-*MENU-*-*-"
                        + "\n1.-Consultar Saldo de la cuenta"
                        + "\n2.-Ingresar Saldo en la cuenta"
                        + "\n3.-Retirar saldo de la cuenta"
                        + "\n4.-Salir\n¿Que desea realizar?", "Menu", 3));
                switch (op) {
                    case 1: {
                        numeroCuenta = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce el numero de cuenta por favor", "Introduciendo Numero de cuenta", 3));
                        a = buscarNumeroCuenta(cuentas, numeroCuenta);
                        if (a >= 0) {
                            JOptionPane.showMessageDialog(null, c.consultarSaldo(a), "Mostrando cuenta " + a, 3);
                        } else {
                            JOptionPane.showMessageDialog(null, "Cuenta no encontrada", "Error al buscar la cuenta", 0);
                        }
                        break;
                    }
                    case 2: {
                        numeroCuenta = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce el numero de cuenta por favor", "Introduciendo Numero de cuenta", 3));
                        a = buscarNumeroCuenta(cuentas, numeroCuenta);
                        if (a >= 0) {
                            saldo = Double.parseDouble(JOptionPane.showInputDialog(null, "Introduce la cantidad a depositar", "Depositando", 3));
                            c.ingresarDinero(a, saldo);
                        } else {
                            JOptionPane.showMessageDialog(null, "Cuenta no encontrada", "Error al buscar la cuenta", 0);
                        }
                        break;
                    }
                    case 3: {
                        numeroCuenta = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce el numero de cuenta por favor", "Introduciendo Numero de cuenta", 3));
                        a = buscarNumeroCuenta(cuentas, numeroCuenta);
                        if (a >= 0) {
                            saldo = Double.parseDouble(JOptionPane.showInputDialog(null, "Introduce la cantidad a retirar", "Retirando", 3));
                            c.retirarDinero(a, saldo);
                        } else {
                            JOptionPane.showMessageDialog(null, "Cuenta no encontrada", "Error al buscar la cuenta", 0);
                        }
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
                JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Error", 0);
            }
            
        } while (op != 4);
    }

    //Metodo para buscar la cuenta
    public static int buscarNumeroCuenta(Cuenta[] cuentas, int numeroDeCuenta) {
        boolean encontrado = false;
        int n = 0;
        
        for (int i = 0; i < cuentas.length && !encontrado; i++) {
            if (cuentas[i].getNumeroCuenta() == numeroDeCuenta) {
                n = i;
                encontrado = true;
            }
        }
        if (encontrado) {
            return n;
        }
        return -1;
    }
    
}
