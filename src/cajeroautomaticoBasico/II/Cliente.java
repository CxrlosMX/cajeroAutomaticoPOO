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
public class Cliente {

    private Cuenta[] arreglo;
    private String nombre;
    private String apellido;
    private int dni;

    public Cliente(String nombre, String apellido, int dni, int numCuentas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        arreglo = new Cuenta[numCuentas];
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    //Registro de cuentas
    public void registroCuentas() {
        int saldo;
        String n;
        for (int i = 0; i < arreglo.length; i++) {
            n = JOptionPane.showInputDialog(null, "Introduce el numero de cuenta " + (i + 1), "Introduciendo numero de cuenta", 3);
            saldo = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce el saldo de la cuenta" , "Introduciendo saldo", 3));
            arreglo[i] = new Cuenta(n, saldo);
        }
    }

    //Metodo para ingresar saldo a la cuenta
    public void realizarDeposito(String n, int dinero) {
        int s=0;
        if (dinero > 0 && n != null) {
            boolean encontrado = false;
            for (int i = 0; i < arreglo.length && !encontrado; i++) {
                if ((arreglo[i].getNumCuenta()).equals(n)) {
                    s = arreglo[i].getSaldo() + dinero;
                    arreglo[i].setSaldo(s);
                    encontrado = true;
                }
            }
            if (!encontrado) {
                JOptionPane.showMessageDialog(null, "No se encontro la cuenta", "Valores no validos", 0);

            }
        } else {
            JOptionPane.showMessageDialog(null, "Introduce valores validos", "Valores no validos", 0);

        }
    }

    //Metodo para realizar un retiro
    public void realizarRetiro(String n, int dinero) {
        if (n != null) {
            boolean encontrado = false;
            for (int i = 0; i < arreglo.length && !encontrado; i++) {
                if ((arreglo[i].getNumCuenta()).equals(n) && dinero > 0 && dinero < arreglo[i].getSaldo()) {
                    int s = arreglo[i].getSaldo() - dinero;
                    arreglo[i].setSaldo(s);
                    encontrado = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Introduce valores validos", "Valores no validos", 0);
                    return;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Introduce valores validos", "Valores no validos", 0);

        }
    }

    //Metodo para mostrar la Informacion del numero de la cuenta
    public void mostrar(String n) {
        if (n != null) {
            boolean encontrado = false;
            for (int i = 0; i < arreglo.length && !encontrado; i++) {
                if ((arreglo[i].getNumCuenta()).equals(n)) {
                    JOptionPane.showMessageDialog(null, "Saldo de la cuenta: " + arreglo[i].getSaldo(), "Mostrando informacion", 3);
                    encontrado = true;
                }
            }
            if (!encontrado) {
                JOptionPane.showMessageDialog(null, "No se encontro la cuenta", "Valores no validos", 0);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Introduce valores validos", "Valores no validos", 0);

        }
    }

    //Metodo para buscar cuenta
    public boolean encontrado(int n) {

        if (n >= 0 && n <= arreglo.length - 1) {
            return true;
        }
        return false;
    }

}
