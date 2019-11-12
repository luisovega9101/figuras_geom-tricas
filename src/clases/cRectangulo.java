package clases;

import java.awt.Point;
import java.io.Serializable;

public class cRectangulo extends Figura implements Serializable{
    protected Point PtoInfIzq;//esquina inferior izquierda
    protected Point PtoSupDerecho;//esquina superior derecha
    
    public cRectangulo(int x1, int y1, int x2, int y2) throws ENoFigura{
        PtoInfIzq = new Point(x1, y1);
        PtoSupDerecho = new Point(x2, y2);
        if(!IsRectangulo())
            throw new ENoFigura(null);
    }
    
    public boolean IsRectangulo(){
        return (PtoInfIzq.x!=PtoSupDerecho.x && PtoInfIzq.y!=PtoSupDerecho.y);
    }

    @Override
    public double perimetro() {
        return 2*(ancho() + altura());
    }

    protected int ancho(){
        return Math.abs(PtoSupDerecho.x - PtoInfIzq.x);
    }

    protected int altura(){
        return Math.abs(PtoSupDerecho.y - PtoInfIzq.y);
    }
    @Override
    public double area() {
        return ancho()*altura();
    }

    public void ModificarValoresLados(int x1, int y1, int x2, int y2){
        PtoInfIzq = new Point(x1, y1);
        PtoSupDerecho = new Point(x2, y2);
    }

    public void Trasladar(int x, int y){
        int v12x=PtoSupDerecho.x-PtoInfIzq.x;
        int v12y=PtoSupDerecho.y-PtoInfIzq.y;
        PtoInfIzq.x=x;
        PtoInfIzq.y=y;
        PtoSupDerecho.x=PtoInfIzq.x+v12x;
        PtoSupDerecho.y=PtoInfIzq.y+v12y;
    }

    public void Rotar(){
        int ancho=altura()/2;
        int altura=ancho()/2;
        int mx=(PtoInfIzq.x+PtoSupDerecho.x)/2;
        int my=(PtoInfIzq.y+PtoSupDerecho.y)/2;
        PtoInfIzq.x=mx-ancho;
        PtoInfIzq.y=my+altura;
        PtoSupDerecho.x=mx+ancho;
        PtoSupDerecho.y=my-altura;
    }
}