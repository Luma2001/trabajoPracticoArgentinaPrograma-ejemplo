/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoarg;


import clase10.Cliente;
import utilidades.*;

/**
 *
 * @author philip
 */
public class Prueba
{
    public static void main(String args[])
    {
        ListaCliente lis = new ListaCliente();
        ListaArreglo listaArreglo = new ListaArreglo();

        System.out.println("Listado filtrado por: inversion");
        Cliente[] res = lis.Filtrar("inversion");
        int i = 0;
        while(i < res.length && res[i] != null)
        {
                res[i].getCuenta().retirar(80000);
                System.out.println(res[i]);
               
                i++;
            }
      
    }
}
