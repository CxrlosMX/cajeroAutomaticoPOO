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
public class Cliente {
    /*Crear un programa para realizar gestin de un banco para lo cual tendremos 2 clases (Clientes y Cuenta). Considere que un cliente se caracteriza por Nombre, apellido y DNI. 
     El cliente puede consultar saldo, asi como ingresar y retirar dinero de sus cuenta. Ademas cada cuenta se caracteriza por un numero de cuenta y saldo;
     */

    private String nombre;
    private String apellido;
    private String dni;
    private Cuenta[] arreglo;

    public Cliente(String nombre, String apellido, String dni, Cuenta[] arreglo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.arreglo = arreglo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Cuenta[] getCuenta() {
        return arreglo;
    }

    public void setCuenta(Cuenta[] cuenta) {
        this.arreglo = cuenta;
    }
    //Metodo para rellenar las cuentas 
   

    //Metodo para consultar saldo
    public double consultarSaldo(int indice) { //Le pasamos como parametro la posicion de la cuenta que deseamos ver la informacion
        return arreglo[indice].getSaldo();
    }

    //Metodo para realizar un deposito a la cuenta 
    public void ingresarDinero(int indice, double cantidad) { //Le pasamos el indice de la cuenta a la que le queremos realizar en depesito
        if (cantidad > 0) {
            arreglo[indice].depositarDinero(cantidad);
            JOptionPane.showMessageDialog(null, "Depisito realizado con Exito", "Depisito realizado", 3);
        } else {
            JOptionPane.showMessageDialog(null, "Introduce un valor correcto", "Valor incorrecto", 0);
        }
    }

    //Creamos el metodo para retirar dinero
    public void retirarDinero(int indice, double cantidad) { //Le pasamos como parametro el indice de la cuenta a la que le queremos realizar el retiro
        if (cantidad > 0 && cantidad <= arreglo[indice].getSaldo()) {
            arreglo[indice].retirarDinero(cantidad);
            JOptionPane.showMessageDialog(null, "Retiro realizado con exito", "Retiro realizado", 3);
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese valores validos por favor", "Error de valores", 0);
        }
    }
}
