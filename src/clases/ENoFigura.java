package clases;

/**
 *
 * @author Luis Enrique
 */
public class ENoFigura extends Exception {

    /**
     * Creates a new instance of <code>ENoFigura</code> without detail message.
     */
    public ENoFigura() {
        super();
    }


    /**
     * Constructs an instance of <code>ENoFigura</code> with the specified detail message.
     * @param msg the detail message.
     */
    public ENoFigura(String msg) {
        super("No se puede formar la figura con esos valores");
    }
}
