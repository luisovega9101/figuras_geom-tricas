package clases;

/**
 *
 * @author Luis Enrique
 */
public abstract class Figura{
    protected int x;
    protected int y;
    public abstract double perimetro();
    public abstract double area();
    public abstract void Trasladar(int x, int y);
    public abstract void Rotar();
}
