package utilidades;

import java.util.Iterator;

/**
 * Created by philip on 1/9/2017.
 */
public class PruebaIteraciones
{
    private static final int CANTIDAD = 25;

    public static void main(String args[])
    {
        ListaArreglo l = new ListaArreglo(CANTIDAD);

        System.out.println("Agrego 25:");
        for (int i = 0; i < CANTIDAD; i++)
        {
            int numero = (int)(Math.random() * 100000);
            l.agregar(numero);
            System.out.println(numero);
        }

        System.out.println("Recorro para suamar...\n");
        int acumulador = 0;
        for (int i = 0; i < CANTIDAD; i++)
        {
            System.out.println("\nConsulto el elemento [" + i + "]: ");
            acumulador += (Integer) l.getItem(i);
        }
        System.out.println("Suma = " + acumulador);


        // Ahora con iterador crioio
        acumulador = 0;
        int i = 0;
        l.iniciar();
        while(l.hayMas()) // while (l.hayMas())
        {
            acumulador += (Integer) l.actual();
            l.siguiente();
        }
        System.out.println("\n\nSuma = " + acumulador);


        // Ahora con el iterador java.
        acumulador = 0;
        Iterator iter = l.iterator();
        while(iter.hasNext())
            acumulador += (Integer) iter.next();

        System.out.println("Suma = " + acumulador);
        acumulador = 0;
        for (Object o : l)
            acumulador += (Integer) o;
        System.out.println("Suma = " + acumulador);

    }

}
