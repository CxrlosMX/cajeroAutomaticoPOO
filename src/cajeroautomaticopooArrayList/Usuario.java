/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajeroautomaticopooArrayList;

/**
 *
 * @author: CxrlosMX
 * @Git-Hub: https://github.com/CxrlosMX
 * @Phone: 953-212-97-27
 * @Email: LuisCRendon131@gmail.com
 * @Date: 28/05/2021
 *
 */
public class Usuario extends Cajero {

    private String nombre;
    private String password;

    public Usuario(String nombre, String password, int cantidad) {
        super(cantidad);
        this.nombre = nombre;
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   
    //Metodo para cambiar la contraseña
    public void cambiarPassword(String pass) {
        this.password=pass;
    }

    @Override
    public String toString() {
        return "Nombre de Usuario:" + nombre + "\nSaldo:" + super.getSaldo();
    }

}
