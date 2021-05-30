/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajeroautomaticopooArrayList;

import java.util.ArrayList;

/**
 *
 * @author: CxrlosMX
 * @Git-Hub: https://github.com/CxrlosMX
 * @Phone: 953-212-97-27
 * @Email: LuisCRendon131@gmail.com
 * @Date: 28/05/2021
 *
 */
public class Registro {

    private ArrayList<Usuario> arreglo;
    private int c;

    public Registro() {
        arreglo = new ArrayList<Usuario>();
        c = -1;
    }

    //Metodo para registrar un nuevo usuario
    public void addUsuario(Usuario u) {
        arreglo.add(u);
        c++;
    }

    //Metodo para buscar el usuario
    public boolean verificar(String n) {

        for (int i = 0; i < arreglo.size(); i++) {
            if (arreglo.get(i).getNombre().equalsIgnoreCase(n)) {
                return true;
            }

        }
        return false;
    }

    //Metodo para buscar el usuario
    public Usuario accion(String n) {

        for (int i = 0; i < arreglo.size(); i++) {
            if (arreglo.get(i).getNombre().equalsIgnoreCase(n)) {
                return arreglo.get(i);
            }

        }
        return null;
    }

    //Metodo para verificar la contraseña del usuario
    public boolean verificarPassword(String n) {

        for (int i = 0; i < arreglo.size(); i++) {
            if (arreglo.get(i).getPassword().equals(n)) {
                return true;
            }

        }
        return false;
    }
}
