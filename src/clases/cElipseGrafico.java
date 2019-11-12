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
public class cElipseGrafico extends cElipse implements iDibujable, Serializable{
    protected Color LineColor;
    protected Color BordeColor;

    public cElipseGrafico(int x, int y, int a, int b, Color LineColor, Color BordeColor) throws ENoFigura{
        super(x, y, a, b);
        this.LineColor = LineColor;
        this.BordeColor= BordeColor;
    } 
        
    public void dibujar(Graphics g) {
        g.setColor(LineColor);
        g.fillOval(coordenadas.x, coordenadas.y, a, b);//rellenar
        g.setColor(BordeColor);
        g.drawOval(coordenadas.x, coordenadas.y, a, b);        
    }

    public Color getLineColor() {
        return LineColor;
    }

    public Color getBordeColor() {
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
        oos.writeObject(coordenadas);
        oos.writeObject(a);
        oos.writeObject(b);
        //Finalmente el LineColor y el BordeColor
        oos.writeObject(LineColor);
        oos.writeObject(BordeColor);
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException{
        //Primero se leen los dos vértices
        coordenadas = (Point)(ois.readObject());
        a = (Integer) (ois.readObject());
        b = (Integer) (ois.readObject());
        //Finalmente el LineColor y el BordeColor
        LineColor = (Color)(ois.readObject());
        BordeColor = (Color)(ois.readObject());
    }
}
