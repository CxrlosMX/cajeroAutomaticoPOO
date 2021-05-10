/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajeroautomaticopoo;

/**
 *
 * @author El Camaleon
 */
public class Cajero {

   
    private double dinero;

    public Cajero() {
        this.dinero = 500;
    }

    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }
    //Metodo para verificar saldo mayor a 0
    public boolean isCorrect(){
    return this.dinero>0 ;
    }
    

    //Metodo para retirar efectivo 
    public double setRetiro(double retiro) {
        this.dinero=this.dinero-retiro;
        return retiro;
    }

    //Metodo para realizar un deposito

    public double setDeposito(double deposito) {
        this.dinero=this.dinero+deposito;
        return deposito;
    }

    //Metodo para consultar tu dinero 
    @Override
    public String toString() {
        return "Tu saldo efectivo es: " + dinero;
    }

}
