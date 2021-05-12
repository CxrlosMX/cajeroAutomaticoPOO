/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajeroautomaticopoo.mejorado;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author El Camaleon
 */
public class RegistroBanco {

    //Dentro de esta clase permitiremos ver la contraseña  etc
    private UsuarioBanco[] arreglo;

    public RegistroBanco(int size) {
        arreglo = new UsuarioBanco[size];
    }

    public RegistroBanco() {
        arreglo = new UsuarioBanco[2];
    }

    //Metodo para agregar usuarios del banco
    public void addUsuarios(UsuarioBanco e) {
        int c = 0;
        boolean encontrado = false;
        for (int i = 0; i < arreglo.length && !encontrado; i++) {
            if (arreglo[i] == null) {
                arreglo[i] = e;
                c = i;
                encontrado = true;
            }
        }

    }

    //Metodo para realizar un deposito
    public void setDeposito(String nombre, double deposito) {
        int c = 0;
        boolean encontrado = false;
        for (int i = 0; i < arreglo.length && !encontrado; i++) {
            if (arreglo[i] != null && arreglo[i].getNombre().equalsIgnoreCase(nombre)) {
                if (deposito > 0) {
                    arreglo[i].setDeposito(deposito);
                    c = i;
                    encontrado = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Introdusca valores validos por favor", "Valores NO validos", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        if (encontrado) {
            JOptionPane.showMessageDialog(null, "Cantidad depositada: " + deposito + "\n" + arreglo[c].toString(), "Deposito realizado", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //Metodo para mostrar datos 
    //Metodo para realizar un deposito
    public void mostrar(String nombre) {
        int c = 0;
        boolean encontrado = false;
        for (int i = 0; i < arreglo.length && !encontrado; i++) {
            if (arreglo[i] != null && arreglo[i].getNombre().equalsIgnoreCase(nombre)) {

                c = i;
                encontrado = true;
            }
        }
        if (encontrado) {
            JOptionPane.showMessageDialog(null, arreglo[c].toString(), "Deposito realizado", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //Metodo para realizar un retiro 
    public void setRetiro(String nombre, double retiro) {
        int c = 0;
        boolean encontrado = false;
        for (int i = 0; i < arreglo.length && !encontrado; i++) {
            if (arreglo[i] != null && arreglo[i].getNombre().equalsIgnoreCase(nombre)) {
                if (retiro >= 0 && retiro <= arreglo[i].getDinero()) {
                    arreglo[i].setRetiro(retiro);
                    c = i;
                    encontrado = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Introdusca valores validos por favor", "Valores NO validos", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        if (encontrado) {
            JOptionPane.showMessageDialog(null, "Cantidad retirada: " + retiro + "\n" + arreglo[c].toString(), "Retiro realizado", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //Metodo para verificar si el usuario existe
    public boolean verificarNombre(String nombre) {
        boolean encontrado = false;
        for (int i = 0; i < arreglo.length && !encontrado; i++) {
            if (arreglo[i] != null && arreglo[i].getNombre().equalsIgnoreCase(nombre)) {
                encontrado = true;
                return true;
            }

        }
        return false;
    }

    //Metodo para verificar si la contraseña es correcta
    public boolean verificarPassword(String password) {

        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null && arreglo[i].getContraseña().equals(password)) {

                return true;
            }

        }
        return false;
    }

    //Metodo para verificar que el saldo retirado sea menor o igual al saldo
}
