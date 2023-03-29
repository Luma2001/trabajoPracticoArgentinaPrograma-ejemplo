/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoarg;

/**
 *
 * @author philip
 */
public class FondosInsuficientesExcept extends RuntimeException
{
    private double mSaldo;
    private double mMonto;

    public double getSaldo()
    {
        return mSaldo;
    }

    public double getMMonto()
    {
        return mMonto;
    }
    
    public FondosInsuficientesExcept(String pMsg, double pSal, double pMonto)
    {
        super(pMsg);
        mSaldo = pSal;
        mMonto = pMonto;
        
    }
    
    public FondosInsuficientesExcept(double pSal, double pMonto)
    {
        this("NO tiene fondos para realizar el retiro!!!", pSal, pMonto);
    }
    
    
}
