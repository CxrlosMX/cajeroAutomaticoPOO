/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajeroautomaticopoo.mejorado;

import javax.swing.JOptionPane;

/**
 *
 * @author El Camaleon
 */
public class Uso_cajero {

    public static void main(String args[]) {
        int op = 0, i = 0;
        double dinero;
        String nombre, password;
        RegistroBanco banco = new RegistroBanco();
        UsuarioBanco a;
        a = new UsuarioBanco("Maria", "1234", 100);
        banco.addUsuarios(a);
        a = new UsuarioBanco("Carlos", "1234", 100);
        banco.addUsuarios(a);
        do {//do2
            try {
                i = Integer.parseInt(JOptionPane.showInputDialog(null, "-*-MENU INICIO-*-*-\n1.-Ingresar\n2.-Salir"));
                switch (i) {
                    case 1: {
                        nombre = JOptionPane.showInputDialog(null, "Introduce tu nombre de usuario", "Introduciendo nombre de usuario", JOptionPane.INFORMATION_MESSAGE);
                        if (banco.verificarNombre(nombre)) {
                            password = JOptionPane.showInputDialog(null, "Introduce tu contraseña", "Introduciendo contraseña", JOptionPane.INFORMATION_MESSAGE);

                            if (banco.verificarPassword(password)) {
                                JOptionPane.showMessageDialog(null,"BIENVENID@ "+nombre,"Bienvenido",JOptionPane.INFORMATION_MESSAGE);
                                do {//do1
                                    try {
                                        op = Integer.parseInt(JOptionPane.showInputDialog(null, "*-*-*-MENU-*-*-*\n1.-SALDO CUENTA\n2.-REALIZAR UN RETIRO\n3.-REALIZAR UN DEPOSITO\n4.-SALIR", "", 3));
                                        switch (op) {
                                            case 1: {
                                                banco.mostrar(nombre);
                                                break;
                                            }
                                            case 2: {
                                                dinero = Double.parseDouble(JOptionPane.showInputDialog(null, "Cuando desea retirar", "Retiro", JOptionPane.INFORMATION_MESSAGE));
                                                banco.setRetiro(nombre, dinero);
                                                break;
                                            }
                                            case 3: {
                                                dinero = Double.parseDouble(JOptionPane.showInputDialog(null, "Cuando desea depositar", "Deposito", JOptionPane.INFORMATION_MESSAGE));
                                                banco.setDeposito(nombre, dinero);
                                                break;
                                            }
                                            case 4: {
                                                JOptionPane.showMessageDialog(null, "Saliendo al Menu de inicio");
                                                break;
                                            }
                                            default: {
                                                JOptionPane.showMessageDialog(null, "Introduce valores correctos por favor", "Error al introducir valores", JOptionPane.INFORMATION_MESSAGE);
                                                break;
                                            }
                                        }

                                    } catch (NumberFormatException e) {
                                        JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                                    }

                                } while (op != 4);//cierre do1
                            } else {
                                JOptionPane.showMessageDialog(null, "Campos no validos\nVerifique que su contraseña sea correcta", "Campos no validos", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Campos no validos\nVerifique su nombre de usuario", "Campos no validos", JOptionPane.ERROR_MESSAGE);
                        }

                        break;
                    }
                    case 2: {
                        JOptionPane.showMessageDialog(null, "Vuelva pronto", "Saliendo del cajero", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }
                    default: {
                        JOptionPane.showMessageDialog(null, "Elige una opcion", "Elige una opcion correcta", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

            }
        } while (i != 2); //do2
    }
}
