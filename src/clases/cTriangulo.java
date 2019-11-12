package clases;

import java.awt.Point;
import java.io.Serializable;

/**
 *
 * @author Luis Enrique
 */
public class cTriangulo extends Figura implements Serializable{
    protected Point punto1;
    protected Point punto2;
    protected Point punto3;
    protected Point medio;

    public cTriangulo(int x1, int y1, int x2, int y2, int x3, int y3) throws ENoFigura{
        punto1 = new Point(x1, y1);
        punto2 = new Point(x2, y2);
        punto3 = new Point(x3, y3);
        medio= new Point(mx(), my());        
        if(!IsTriangulo())
            throw new ENoFigura(null);
    }

    private int mx(){
       int mayorx=Math.max(punto1.x, Math.max(punto2.x, punto3.x));
       int menorx=Math.min(punto1.x, Math.min(punto2.x, punto3.x));
       return (mayorx+menorx)/2;
    }

    private int my(){
       int mayory=Math.max(punto1.y, Math.max(punto2.y, punto3.y));
       int menory=Math.min(punto1.y, Math.min(punto2.y, punto3.y));
       return (mayory+menory)/2;
    }

    private boolean IsTriangulo(){
        double a= Distancia(punto1.x, punto1.y, punto2.x, punto2.y);
        double b= Distancia(punto2.x, punto2.y, punto3.x, punto3.y);
        double c= Distancia(punto1.x, punto1.y, punto3.x, punto3.y);
        return (a<b+c && b<a+c && c<a+b);
    }

    public double Distancia(int x1, int y1, int x2, int y2){
        return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
    }    

    @Override
    public double perimetro() {
        if(IsTriangulo()){
            double a= Distancia(punto1.x, punto1.y, punto2.x, punto2.y);
            double b= Distancia(punto2.x, punto2.y, punto3.x, punto3.y);
            double c= Distancia(punto1.x, punto1.y, punto3.x, punto3.y);
            return Math.abs(a+b+c);
        }
        return 0;
    }

    @Override
    public double area() {
        if(IsTriangulo()){
            double semip= perimetro()/2;
            double a= Distancia(punto1.x, punto1.y, punto2.x, punto2.y);
            double b= Distancia(punto2.x, punto2.y, punto3.x, punto3.y);
            double c= Distancia(punto1.x, punto1.y, punto3.x, punto3.y);
            return Math.abs(Math.sqrt(semip*(semip-a)*(semip-b)*(semip-c)));
        }
        return 0;
    }

    public void Trasladar(int x, int y){
        int v12x=punto2.x-punto1.x;
        int v12y=punto2.y-punto1.y;    
        int v13x=punto3.x-punto1.x;    
        int v13y=punto3.y-punto1.y;
        punto1.x=x;
        punto1.y=y;
        punto2.x=punto1.x+v12x;
        punto2.y=punto1.y+v12y;
        punto3.x=punto1.x+v13x;
        punto3.y=punto1.y+v13y;
        medio= new Point(mx(), my()); 
    }
      
     public void Rotar(){
         punto1.x-=medio.x;
         punto1.y-=medio.y;
         punto2.x-=medio.x;
         punto2.y-=medio.y;
         punto3.x-=medio.x;
         punto3.y-=medio.y;
         int tmp=punto1.x;
         punto1.x=(-1)*punto1.y;
         punto1.y=tmp;
         tmp=punto2.x;
         punto2.x=(-1)*punto2.y;
         punto2.y=tmp;
         tmp=punto3.x;
         punto3.x=(-1)*punto3.y;
         punto3.y=tmp;
         punto1.x+=medio.x;
         punto1.y+=medio.y;
         punto2.x+=medio.x;
         punto2.y+=medio.y;
         punto3.x+=medio.x;
         punto3.y+=medio.y;
     }
}
