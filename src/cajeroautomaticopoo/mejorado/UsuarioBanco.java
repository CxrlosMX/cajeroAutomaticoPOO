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
public class UsuarioBanco {

    private double dinero;
    private String nombre, password;

    public UsuarioBanco(String nombre, String password, double dinero) {
        this.nombre = nombre;
        this.password = password;
        this.dinero = dinero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return password;
    }

    public void setContraseña(String password) {
        this.password = password;
    }

    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

    //Funciones de banco
    //Metodo para agregar depositar dinero
    public void setDeposito(double deposito) {
       
            this.dinero = this.dinero + deposito;
         
    }

    //Metodo para realizar un retiro 
    public void setRetiro(double retiro) {
        
            this.dinero = (this.dinero - retiro);
       
    }

    @Override
    public String toString() {
        return "Nombre de usuario: " + nombre + "\nSaldo disponible: " + dinero;
    }

}
