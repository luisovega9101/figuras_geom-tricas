/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clases;

/**
 *
 * @author Luis Enrique
 */
public class EListaVacia extends Exception {

    /**
     * Creates a new instance of <code>EListaVacia</code> without detail message.
     */
    public EListaVacia() {
    }


    /**
     * Constructs an instance of <code>EListaVacia</code> with the specified detail message.
     * @param msg the detail message.
     */
    public EListaVacia(String msg) {
        super("La lista esta vacia");
    }
}
