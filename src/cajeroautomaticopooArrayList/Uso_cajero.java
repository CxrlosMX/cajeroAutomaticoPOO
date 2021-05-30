/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajeroautomaticopooArrayList;

import javax.swing.JOptionPane;

/**
 *
 * @author: CxrlosMX
 * @Git-Hub: https://github.com/CxrlosMX
 * @Phone: 953-212-97-27
 * @Email: LuisCRendon131@gmail.com
 * @Date: 28/05/2021
 *
 */
public class Uso_cajero {

    public static void main(String args[]) {
        int op = 0, saldo, o = 0;
        String nombre, password;
        Registro lista = new Registro();
        Usuario u, a;

        do {
            try {
                op = Integer.parseInt(JOptionPane.showInputDialog(null, "-*-*BANCK WONK-*-*-\n1.-Iniciar Sesión\n2.-Registrarse\n3.-Salir", "INICIO", 3));
                switch (op) {
                    case 1: {
                        nombre = JOptionPane.showInputDialog(null, "Introduce tu nombre de usuario", "Introduciendo Nombre", 3);
                        if (lista.verificar(nombre)) {
                            a = lista.accion(nombre);
                            do {
                                try {
                                    o = Integer.parseInt(JOptionPane.showInputDialog(null, "-*-*BIENVENIDO DE NUEVO " + nombre.toUpperCase() + "-*-*-\n1.-REALIZAR RETIRO\n2.-REALIZAR ABONO"
                                            + "\n3.-VERIFICAR SALDO\n4.-CAMBIAR CONTRASEÑA\n5.-SALIR\n¿Que desea realizar?", "INICIO", 3));
                                    switch (o) {
                                        case 1: {
                                            saldo = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce la cantidad a retirar", "Retiro", 1));
                                            a.retirar(saldo);
                                            break;
                                        }
                                        case 2: {
                                            saldo = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce la cantida que deseas abonar", "Ingresando abono", 1));
                                            a.deposito(saldo);
                                            break;
                                        }
                                        case 3: {
                                            JOptionPane.showMessageDialog(null, a.toString(), "Informacion", 1);
                                            break;
                                        }
                                        case 4: {
                                            //do {
                                                for (int j = 3; j > 0; j--) {
                                                    password = JOptionPane.showInputDialog(null, "Introdusca su actual contraseña", "Introduciendo contraseña", 1);
                                                    if (a.getPassword().equals(password)) {
                                                        password = JOptionPane.showInputDialog(null, "Introdusca su nueva contraseña", "Introduciendo nueva contraseña", 1);
                                                        a.cambiarPassword(password);
                                                        j = 0;
                                                    }
                                                    else {
                                                          JOptionPane.showMessageDialog(null, "Contraseña incorrecta\nIntentos Restantes: " + --j, "PassWord incorrecta", 1);
                                              
                                                    }
                                                }
                           
                                            break;
                                        }
                                        case 5: {
                                            JOptionPane.showMessageDialog(null, "GRACIAS POR SU PREFERENCIA", "SALIENDO AL MENU PRINCIPAL", 1);
                                            break;
                                        }
                                        default: {
                                            JOptionPane.showMessageDialog(null, "Introdusca valores validos por favor", "Error de valores", JOptionPane.WARNING_MESSAGE);
                                            break;
                                        }
                                    }
                                } catch (NumberFormatException e) {
                                    JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            } while (o != 5);
                        } else {
                            JOptionPane.showMessageDialog(null, "Usuario no encontrado", "Error de busqueda", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    }
                    case 2: {
                        nombre = JOptionPane.showInputDialog(null, "Introduce tu nombre de Usuario", "Introduciendo Usuario", 1);
                        password = JOptionPane.showInputDialog(null, "Introduce tu contraseña", "Introduciendo contraseña", 1);
                        u = new Usuario(nombre, password, 50);
                        lista.addUsuario(u);
                        break;
                    }
                    case 3: {
                        JOptionPane.showMessageDialog(null, "CERRANDO PROGRAMA", "SALIENDO", 1);
                        break;
                    }
                    default: {
                        JOptionPane.showMessageDialog(null, "Introdusca valores validos por favor", "Error de valores", JOptionPane.WARNING_MESSAGE);
                        break;
                    }

                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

        } while (op != 3);

        /*u = new Usuario("Luis", "123", 459);
         lista.addUsuario(u);
         if (lista.verificar("Luis")) {
         a = lista.accion("Luis");
         System.out.println(a.toString());
         }
         */
    }

}
