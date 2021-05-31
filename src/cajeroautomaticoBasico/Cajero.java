/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajeroautomaticoBasico;

import javax.swing.JOptionPane;

/**
 *
 * @author: CxrlosMX
 * @Git-Hub: https://github.com/CxrlosMX
 * @Phone: 953-212-97-27
 * @Email: LuisCRendon131@gmail.com
 * @Date: 30/05/2021
 *
 */
public class Cajero {

    private int saldo;
    private String password;

    public Cajero(String password) {
        this.saldo = 50;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //Metodo para mostrar Menu
    public void mostrarMenu() {
        int op = 0;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(null, "----BIENVENIDO---"
                    + "\n1.-Consultar Saldo"
                    + "\n2.-Depositar"
                    + "\n3.-Retirar"
                    + "\n4.-Cambiar contraseña"
                    + "\n5.-Salir", "MENU", 3));
            if (op >= 1 && op <= 5) { //Verificamos si la cadena es un numero 
                switch (op) {
                    case 1: {
                        JOptionPane.showMessageDialog(null, this.datos(), "Mostrando Datos", 3);
                        break;
                    }
                    case 2: {
                        setDeposito();
                        break;
                    }
                    case 3: {
                        setRetiro();
                        break;
                    }
                    case 4: {
                        cambiarPassword();
                        break;
                    }
                    case 5: {
                        JOptionPane.showMessageDialog(null, "Cerrando Programa", "Cerrando", 0);
                        break;
                    }

                }
            } else {
                JOptionPane.showMessageDialog(null, "Introduce valores correctos", "Error de valores", 0);
            }

        } while (op != 5);

    }

    //Metodo para depositar
    private void setDeposito() {
        String cadena;
        int cantidad;
        cadena = JOptionPane.showInputDialog(null, "Introdusca la cantidad que desea depositar", "Depositando", 3);
        if (cadena != null && !cadena.equals("") && ValidacionNumero.isNum(cadena)) {
            cantidad = Integer.parseInt(cadena);
            if (cantidad > 0) {
                this.saldo += cantidad;
                JOptionPane.showMessageDialog(null, "Deposito realizado con exito", "Deposito con exito", 3);
            } else {
                JOptionPane.showMessageDialog(null, "Introduce una cantidad valida por favor", "Cantidad no valida", 0);
            }
        }
    }

    /*  //Metodo para realizar un retiro
     private void setRetiro(){
     String cadena=JOptionPane.showInputDialog(null, "a.-", "Depositando", 3);
    
    
    
     }*/
    private void setRetiro() {
        String cadena;
        int cantidad;
        if (this.saldo > 0) {
            String c = JOptionPane.showInputDialog(null, "Introdusca su contraseña", "Introduciendo contraseña", 3);
            if (c != null && c.equals(this.password) && !c.equals("")) {

                cadena = JOptionPane.showInputDialog(null, "a)5000\nb)10 000"
                        + "\nc)20 000\nd)50 000\ne)1000 000\nf)Otra cantidad", "Menu", 3);

                if (cadena != null && !cadena.equals("")) {
                    switch (cadena) {
                        case "a": {
                            verificarCantidad(5000);
                            break;
                        }
                        case "b": {
                            verificarCantidad(10000);
                            break;
                        }
                        case "c": {
                            verificarCantidad(20000);
                            break;
                        }
                        case "d": {
                            verificarCantidad(50000);
                            break;
                        }
                        case "e": {
                            verificarCantidad(1000000);
                            break;
                        }
                        case "f": {
                            cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduzca la cantidad que desea realizar", "Introduciendo cantidad", 3));
                            verificarCantidad(cantidad);
                            break;
                        }
                        default: {
                            JOptionPane.showMessageDialog(null, "Introduce una opcion correcta", "Opcion incorrecta", 0);
                            break;
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "Contraseña Incorrecta", 0);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Cuenta sin saldo", "Saldo cero", 0);
        }

    }

    //Metodo para cambiar la contraseña de nuestro usuario
    public void cambiarPassword() {
        String a;
        a = JOptionPane.showInputDialog(null, "Introduce la contraseña actual por favor", "Introduciendo contraseña", 3);
        if (a != null && !a.equals("") && a.equals(this.password)) {
            a = JOptionPane.showInputDialog(null, "Introduce la nueva contraseña", "Introduciendo la nueva contraseña", 3);
            if (a != null && !a.equals("") && !a.equals(this.password) && a.length()>3) { //La ultima condicion es para que la contraseña tenga mas de 3 letras
                this.setPassword(a);
                JOptionPane.showMessageDialog(null, "Contraseña cambiada con exito", "Contraseña cambiada", 3);
            } else {
                JOptionPane.showMessageDialog(null, "Introduce una contraseña valida", "Error al cambiar la contraseña", 0);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Contraseña Incorrecta", "Contraseña incorrecta", 0);
        }
    }

    //Metodo para verificar valores
    public void verificarCantidad(int n) {
        if (this.saldo >= n && n > 0) {
            this.saldo -= n;
            JOptionPane.showMessageDialog(null, "Retiro realizado con exito", "Retiro realizado", 1);
        } else {
            JOptionPane.showMessageDialog(null, "Saldo insuficiente", "Saldo insuficienes", JOptionPane.WARNING_MESSAGE);
        }
    }

    private String datos() {
        return "Saldo : " + saldo + "$";
    }

}
