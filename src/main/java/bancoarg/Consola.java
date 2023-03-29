package bancoarg;

/**
 * Clase para facilitar operaciones de carga por teclado en consola est�dar
 * @author Valerio Fritelli - Modificado por Felipe Steffolani
 * @version Mayo de 2007
 */

public class Consola
{
    /*
     * 1) Todos los m�todos de esta clase son est�ticos, y por lo tanto pueden ser invocados sin tener que crear objetos de la clase. Es 
     * suficiente con nombrar la clase al invocar el m�todo:   int x = Consola.readInt();
     */

    /**
     * Lee un string desde teclado. El string termina con un salto de linea
     * @return el string leido (sin el salto de linea)
     */
    public static String readLine()
    { 
        int ch;
        String r = "";
        boolean done = false;
        while (!done)
        {
            try
            {
                ch = System.in.read();
                if (ch < 0 || (char)ch == '\n') { done = true; }
                else 
                {
                    if ((char)ch != '\r') { r = r + (char) ch; }
                }
            }
            catch(java.io.IOException ex)
            {
                done = true;
            }
        }
        return r;
    }

    /**
     * Lee un integer desde teclado. La entrada termina con un salto de linea
     * @return el valor cargado, como un int
     */
    public static int readInt()    
    {
        boolean wFlag = true;
        int wRes = 0;
        do
        {
            try
            {
                wRes = Integer.parseInt(readLine().trim());
                wFlag = false;
            }
            catch(NumberFormatException e)
            {
                System.out.println("No es un integer. Por favor, pruebe otra vez!");
                wFlag = true;
            }

        }while(wFlag);

        return wRes;
    }

    /**
     * Lee un double desde teclado. La entrada termina con un salto de linea
     * @return el valor cargado, como un double
     */
    public static double readDouble()
    {
        boolean wFlag = true;
        double wRes = 0;
        do
        { 
            try
            {
                wRes = Double.parseDouble(readLine().trim());
                wFlag = false;
            }
            catch(NumberFormatException e)
            {
                System.out.println("No es un flotante. " + "Por favor, pruebe otra vez!");
                wFlag = true;
            }
        }while(wFlag);

        return wRes;
    }
}
