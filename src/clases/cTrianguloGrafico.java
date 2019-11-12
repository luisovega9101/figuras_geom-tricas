
package clases;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Luis Enrique
 */
public class cTrianguloGrafico extends cTriangulo implements iDibujable, Serializable{
    protected Color LineColor;
    protected Color BordeColor;

    public cTrianguloGrafico(int x1, int y1, int x2, int y2, int x3, int y3, Color LineColor, Color BordeColor) throws ENoFigura{
        super(x1, y1, x2, y2, x3, y3);
        this.LineColor=LineColor;
        this.BordeColor=BordeColor;
    }

    public void dibujar(Graphics g) {
        g.setColor(LineColor);
        Polygon triangulo = new Polygon();//dibuja un polígono cerrado
        triangulo.addPoint(punto1.x, punto1.y);
        triangulo.addPoint(punto2.x, punto2.y);
        triangulo.addPoint(punto3.x, punto3.y);
        g.fillPolygon(triangulo);
        g.setColor(BordeColor);
        g.drawPolygon(triangulo);        
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
        //Primero se escriben los 3 vértices
        oos.writeObject(punto1);
        oos.writeObject(punto2);
        oos.writeObject(punto3);
        //Finalmente el LineColor y el BordeColor
        oos.writeObject(LineColor);
        oos.writeObject(BordeColor);
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException{
        //Primero se leen los 3 vértices
        punto1 = (Point) (ois.readObject());
        punto2 = (Point) (ois.readObject());
        punto3 = (Point) (ois.readObject());
        //Finalmente el LineColor y el BordeColor
        LineColor = (Color)(ois.readObject());
        BordeColor = (Color)(ois.readObject());
    }

}
