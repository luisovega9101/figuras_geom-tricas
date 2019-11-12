/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clases;

/**
 *
 * @author Luis Enrique
 */
public class EPosFueraRango extends Exception {

    /**
     * Creates a new instance of <code>EPosFueraRango</code> without detail message.
     */
    public EPosFueraRango() {
    }


    /**
     * Constructs an instance of <code>EPosFueraRango</code> with the specified detail message.
     * @param msg the detail message.
     */
    public EPosFueraRango(String msg) {
        super("Posición no válida, fuera de rango");
    }
}
