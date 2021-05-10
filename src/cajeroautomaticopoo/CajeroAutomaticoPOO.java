/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajeroautomaticopoo;

import javax.swing.JOptionPane;

/**
 *
 * @author El Camaleon
 */
public class CajeroAutomaticoPOO {

    public static void main(String[] args) {
        Cajero p1 = new Cajero();
        int op = 0;
        double r;
        do {
            try {
                op = Integer.parseInt(JOptionPane.showInputDialog(null, "*-*-*BIENVENIDO LCBank-*-*-*\n1.-Consultar Saldo"
                        + "\n2.-Retiro de efectivo\n3.-Deposito de efectivo\n4.-Salir", "MENU", 3));
                switch (op) {
                    case 1: {
                        JOptionPane.showMessageDialog(null, p1.toString());
                        break;
                    }
                    case 2: {
                        if (p1.isCorrect()) {
                            r = Double.parseDouble(JOptionPane.showInputDialog(null, "Cuanto desea retirar", "Retirando", JOptionPane.INFORMATION_MESSAGE));
                            if (r <= p1.getDinero()) {
                                JOptionPane.showMessageDialog(null, "Usted ha retirado: " + p1.setRetiro(r) + "\nSaldo Actual: " + p1.toString(), "Informacion retiro", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "Saldo insuficiente", "Saldo insuficiente", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Tu saldo es insuficiente", "Saldo insuficiente", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    }
                    case 3: {
                        r = Double.parseDouble(JOptionPane.showInputDialog(null, "Cuanto desea depositar", "Depositando", JOptionPane.INFORMATION_MESSAGE));
                        JOptionPane.showConfirmDialog(null, "Usted ha depositado: " + p1.setDeposito(r) + "\nSaldo actual: " + p1.toString(), "Saldo actual", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }
                    case 4: {
                        JOptionPane.showMessageDialog(null, "¡GRACIAS!, vuelva pronto", "Saliendo", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }
                    default: {
                        JOptionPane.showMessageDialog(null, "Elige una opción correcta", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }

                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

        } while (op != 4);

    }

}
