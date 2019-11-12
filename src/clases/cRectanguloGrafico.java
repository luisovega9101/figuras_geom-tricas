package clases;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Luis Enrique
 */
public class cRectanguloGrafico extends cRectangulo implements iDibujable, Serializable{
    protected Color LineColor;
    protected Color BordeColor;

    public cRectanguloGrafico(int x1, int y1, int x2, int y2, Color LineColor, Color BordeColor) throws ENoFigura{
        super(x1, y1, x2, y2);
        this.LineColor = LineColor;
        this.BordeColor = BordeColor;
    }

    public void dibujar(Graphics g) {
        g.setColor(LineColor);
        int ancho = Math.abs(PtoSupDerecho.x - PtoInfIzq.x);
        int altura = Math.abs(PtoSupDerecho.y - PtoInfIzq.y);        
        g.fillRect(PtoInfIzq.x, PtoInfIzq.y, ancho, altura);
        g.setColor(BordeColor);
        g.drawRect(PtoInfIzq.x, PtoInfIzq.y, ancho, altura);
        
   }

    public Color getLineColor(){
        return LineColor;
    }

    public Color getBordeColor(){
        return BordeColor;
    }    

    public void CambiarColorBorde(Color borde){
        BordeColor=borde;
    }
    public void CambiarColorRelleno(Color relleno){
        LineColor=relleno;
    }
    private void writeObject(ObjectOutputStream oos) throws IOException{
        //Primero se escriben los dos vértices
        oos.writeObject(PtoInfIzq);
        oos.writeObject(PtoSupDerecho);
        //Finalmente el LineColor y el BordeColor
        oos.writeObject(LineColor);
        oos.writeObject(BordeColor);
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException{
        //Primero se leen los dos vértices
        PtoInfIzq = (Point)(ois.readObject());
        PtoSupDerecho = (Point)(ois.readObject());
        //Finalmente el LineColor y el BordeColor
        LineColor = (Color)(ois.readObject());
        BordeColor = (Color)(ois.readObject());
    }
}
