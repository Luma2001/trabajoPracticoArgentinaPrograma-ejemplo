/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoarg;

/**
 *
 * @author philip
 */
public class CuentaInversion extends Cuenta
{

    private static float mTasa = 0.11F;

    public CuentaInversion(int pNro, double pSaldo)
    {
        super(pNro, pSaldo);

    }

    public float getTasa()
    {
        return mTasa;
    }

    public static void setTasa(float mTasa)
    {
        mTasa = mTasa;

    }

    public void actualizar() 
    {
        mSaldo += mSaldo * mTasa;

    }

    public String toString()
    {
        StringBuffer wRes = new StringBuffer();
        wRes.append(super.toString());
        wRes.append("\n\tTipo:\tInversión");
        wRes.append("\n\tTasa:\t" + mTasa);

        return wRes.toString();

    }

    public boolean retirar(double pMonto) 
    {
        boolean wRes = false;
        //Es Cuenta Inversion evaluar saldo directamente
        if (pMonto <= mSaldo)
        {
            mSaldo -= pMonto;
            wRes = true;
        }
        else
            throw new FondosInsuficientesExcept("No hay plata", mSaldo, pMonto);

        return wRes;
    }

    public boolean pertenece(String pToken)
    {
        boolean wRes = false;
        if (pToken.equalsIgnoreCase("inversion"))
        {
            wRes = true;
        }
        return wRes;
    }
}
