/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoarg;


import clase10.Cliente;
import clase10.CuentaCorriente;

/**
 *
 * @author philip
 */
public class ListaCliente
{

    private Cliente[] mClientes;

    public ListaCliente()
    {
        CrearClientes();

    }

    public void Mostrar(String pMessage)
    {
        System.out.println(pMessage);
        for (Cliente item : mClientes)
        {
            System.out.println(item);
        }
    }

    public Cliente[] Filtrar(String pFiltro)
    {
        Cliente[] res = new Cliente[5];
        int i = 0;

        for (int idx = 0; idx < res.length; idx++)
        {
            res[i] = null;
        }



        for (Cliente item : mClientes)
        {
            if (item.pertenece(pFiltro))
            {
                res[i] = item;
                i++;
            }
        }

        return res;

    }

    private void CrearClientes()
    {
        mClientes = new Cliente[5];
        Cuenta wCtaAux;

        String[] wNombres = {"Quito, Esteban", "Nano, Elba", "Fuertes de Panza, Dolores", "Pichimauida, Jacinta"};
        CuentaInversion.setTasa(0.12F);
        for (int i = 0; i < 5; i++)
        {
            if (Math.random() > 0.60)
            {
                wCtaAux = new CuentaCorriente(((int) (Math.random() * 99999)), ((double) (Math.random() * 99999)), ((Math.random() > 0.80 ? true : false)));
            } else
            {
                wCtaAux = new CuentaInversion(((int) (Math.random() * 99999)), ((double) (Math.random() * 99999)));
            }

            mClientes[i] = new Cliente(((int) (Math.random() * 999999)), wNombres[i], wCtaAux);

        }
//        Object vecnuevo[] = mClientes;
//        vecnuevo[5] = new CuentaCorriente(2, 2, false);
        
        
        Mostrar("Clientes Generados");
    }

    public Cliente getElement(int pInd)
    {
        return mClientes[pInd];
    }

    public void Actualizar()
    {
        for (Cliente item : mClientes)
        {
            if (item.getCuenta() instanceof CuentaInversion)
            {
                ((CuentaInversion) item.getCuenta()).actualizar();
            }
        }

    /*
    for (int i = 0; i < mClientes.length; i++)
    {
    if (mClientes[i].getCuenta() instanceof CuentaInversion)
    ((CuentaInversion)mClientes[i].getCuenta()).actualizar();
    }
     */
    }

    public static void Ordenar(Comparable[] vec)
    {
        Comparable aux;
        for (int i = 0; i < vec.length - 1; i++)
        {
            for (int j = i + 1; j < vec.length; j++)
            {
                if (vec[i].compareTo(vec[j]) > 0)
                {
                    aux = vec[i];
                    vec[i] = vec[j];
                    vec[j] = aux;

                }

            }
        }

    }

    public Cliente buscar(int pNro)
    {
        int izq = 0, der = mClientes.length - 1;
        int c = (der - izq) / 2;
        Cliente wClienteRes = null;
        while (izq < der)
        {
            if (mClientes[c].getNro() == pNro)
            {
                wClienteRes = mClientes[c];
                break;
            } else if (pNro > mClientes[c].getNro())
            {
                izq = c + 1;
            } else
            {
                der = c - 1;
            }
            c = (der - izq) / 2;
        }

        return wClienteRes;
    }
}
