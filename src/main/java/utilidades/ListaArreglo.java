/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

//import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Iterator;

/**
 *
 * @author philip
 * @date Expression getdate is undefined on line 13, column 12 in
 * Templates/Classes/Class.java.
 */
public class ListaArreglo implements Iterable
{
    private Object[] items;
    private int cantidad;

    public ListaArreglo(int pTam)
    {
        cantidad = 0;
        items = new Object[pTam];
    }

    public ListaArreglo()
    {
        this(10);
    }

    public Object getItem(int idx)
    {
        Object resp = null;
        if (idx >= 0 && idx < cantidad)
        {
            resp = items[idx];
        }
        else
            throw new IndexOutOfBoundsException();
       

        return resp;
    }

    public void setItem(Object pDato, int idx)
    {
        if (idx >= 0 && idx < cantidad)
        {
            items[idx] = pDato;
        }
        else
            throw new IndexOutOfBoundsException();

    }

    public int getCantidad()
    {
        return cantidad;
    }

    public void agregar(Object pDato)
    {
        if (cantidad == items.length)
        {
            //assert true: "Agrandando el vector a: " + (int) (items.length * 1.5) + " elementos";
            Object[] aux = new Object[(int) (items.length * 1.5)];
            System.err.println("Se agrando el vector a: " + aux.length);
            for (int i = 0; i < items.length; i++)
            {
                aux[i] = items[i];
            }
            //System.arraycopy(items,0, aux, 0, items.length);
            items = aux;
        }

        items[cantidad] = pDato;
        cantidad++;
    }

    public void quitar(int idx)
    {
        System.out.print("Haganlo uds.");

    }

    public void limpiar()
    {
        System.out.print("Háganlo uds.");

    }

    public String toString()
    {
        StringBuilder buff = new StringBuilder();

        buff.append("ListaArreglo ").append('{');
        for (int i = 0; i < items.length; i++)
        {
            buff.append(items[i]);
            if (i < items.length - 1)
            {
                buff.append(", ");
            }
        }
        buff.append('}');

        return buff.toString();

    }

    //<editor-fold defaultstate="collapsed" desc="Implementacion del iterador criollo">
    private int idxActual;

    public void iniciar()
    {
        idxActual = 0;
    }

    public boolean hayMas()
    {
        return (idxActual < cantidad);
    }

    public Object actual()
    {
        Object resp = null;
        if (idxActual < cantidad)
        {
            resp = items[idxActual];
        }
        return resp;

    }

    public void siguiente()
    {
        if (idxActual < cantidad)
        {
            idxActual ++;
        }

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Implementacion de la interfaz Iterable">


    public Iterator iterator()
    {
        return new IteradorLineal();
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Implementacion de la interfaz Iterator con el iterador natural">
    private class IteradorLineal implements Iterator
    {
        private int actual;

        public IteradorLineal()
        {
            actual = 0;
        }

        public boolean hasNext()
        {
            return actual < cantidad; // ListaArreglo.this.cantidad;
        }

        public Object next()
        {
            Object resp = null;
            if (hasNext())
            {
                resp = getItem(actual);
                actual++;
            }
            return resp;
        }

        public void remove()
        {
            //"Haganlo ustedes...."
            throw new RuntimeException();
        }

    }
    //</editor-fold>
}
