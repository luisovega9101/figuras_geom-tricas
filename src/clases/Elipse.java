package clases;

import java.awt.Point;
import java.io.Serializable;

/**
 *
 * @author Luis Enrique
 */
public class Elipse extends Figura implements Serializable{

    protected Point coordenadas;
    protected int a;//semieje X
    protected int b;//semieje Y

    public Elipse(int x, int y, int a, int b) throws ENoFigura{
        coordenadas= new Point(x, y);
        this.a = a;
        this.b = b;
        if(!IsElipse())
            throw new ENoFigura(null);
    }
    
    public boolean IsElipse(){
        return (a!=0 && b!=0 && a>0 && b>0);
    }

    @Override
    public double perimetro() {
        return Math.abs(Math.PI*(3*(a+b)- Math.sqrt((3*a+b)*(a+3*b))));
    }

    @Override
    public double area() {
        return Math.abs(Math.PI*a*b);
    }

    public void ModificarValoresRadios(int a, int b){
        this.a = a;
        this.b = b;
    }

    public void Trasladar(int x, int y){
        coordenadas.x=x;
        coordenadas.y=y;
    }

    public void Rotar() {
        int c=a;
        a=b;
        b=c;
    }
}
