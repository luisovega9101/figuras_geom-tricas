package clases;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;//clase que almacena un fichero

/**
 *
 * @author Luis Enrique
 */
public class cLienzo implements iDibujable, Serializable{
    private Lista<iDibujable> dibujable;

    public cLienzo() {
        dibujable= new Lista<iDibujable>();
    }

    public void adicionar(iDibujable d) throws EArrayLleno {
        dibujable.Adicionar(d);
    }

    public void clear(Graphics g){
        g.setColor(Color.WHITE);
        g.drawRect(0, 0, 1000, 1000);
        g.fillRect(0, 0, 1000, 1000);
    }
    
    public int getCantObjetos(){
        return dibujable.Longitud();
    }

    public iDibujable getObjeto(int pos) throws EPosFueraRango{
        return dibujable.Obtener(pos);
    }

    public void eliminar(int pos) throws EPosFueraRango, EListaVacia {
        dibujable.Eliminar(pos);
    }

    public void eliminarTodos() throws EPosFueraRango, EListaVacia{
        int n= dibujable.Longitud();
        for (int i = 0; i < n; i++)
            eliminar(0);
    }

    public void dibujar(Graphics g) {
        dibujar(g);
    } 
        
    public void Trasladar(int pos, int x, int y) throws EPosFueraRango{
        ((Figura)dibujable.Obtener(pos)).Trasladar(x, y);
    }

    public void Rotar(int pos) throws EPosFueraRango{
        ((Figura)dibujable.Obtener(pos)).Rotar();
    }

    private void writeObject(ObjectOutputStream oos) throws IOException, EPosFueraRango, EPosFueraRango, EPosFueraRango{
        //Primero se escribe la cantidad de Dibujable
        oos.writeInt(dibujable.Longitud());
        //Luego cada uno de los Dibujable
        for(int i = 0; i < dibujable.Longitud(); i++)
            oos.writeObject(dibujable.Obtener(i));
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException, EArrayLleno
    {
        //Primero se lee la cantidad de objetos
        int n = ois.readInt();
        //Luego se construye el array
        dibujable= new Lista<iDibujable>();
        //Luego se lee cada uno de los objetos
        for (int i = 0; i < n; i++)
            dibujable.Adicionar((iDibujable) ois.readObject());
    }
}