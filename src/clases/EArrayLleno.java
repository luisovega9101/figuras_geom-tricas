package clases;

/**
 *
 * @author Luis Enrique
 */
public class EArrayLleno extends Exception {

    /**
     * Creates a new instance of <code>EArrayLleno</code> without detail message.
     */
    public EArrayLleno() {
        super();
    }


    /**
     * Constructs an instance of <code>EArrayLleno</code> with the specified detail message.
     * @param msg the detail message.
     */
    public EArrayLleno(String msg) {
        super("El array de elementos esta lleno");
    }
}
