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
public class Cajero {

    private int saldo;
    
    public Cajero(int cantidad) {
        this.saldo = cantidad;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setCantidad(int cantidad) {
        this.saldo = cantidad;
    }

    //Metodo para verificar parametros
    public boolean verificarSaldo(int c) {
        return c >0 && c <= this.getSaldo();
    }
    //Metodo para realizar un retiro 

    public void retirar(int c) {
        if (verificarSaldo(c)) {
            this.saldo = this.saldo - c;
        } else {
            JOptionPane.showMessageDialog(null, "Introduce valores validos", "Valores no validos", JOptionPane.ERROR_MESSAGE);
        }
    }

    //Metodo para realizar un deposito
    public void deposito(int c) {
        if (c > 0) {
            this.saldo = this.saldo + c;
        } else {
            JOptionPane.showMessageDialog(null, "Introduce valores validos", "Valores no validos", JOptionPane.ERROR_MESSAGE);
        }
    }
}
