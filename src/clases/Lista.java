package clases;

/**
 *
 * @author Luis Enrique
 */
public class Lista<T>{
    protected T[] elementos;
    protected int cantElementos;

    public Lista(){
        elementos= (T[]) new Object[100];
        cantElementos=0;
    }

    public void Adicionar(T x) throws EArrayLleno{
        if(cantElementos==elementos.length)
            throw new EArrayLleno();
        elementos[cantElementos++]=x;
    }

    public T Obtener(int pos) throws EPosFueraRango{
        if(pos<0 || pos>cantElementos)
            throw new EPosFueraRango();
        return elementos[pos];
    }

    public int Longitud() {
        return cantElementos;
    }

    public boolean EstaVacia(){
        return (cantElementos==0);
    }

    public void Insertar(T x, int pos) throws EPosFueraRango, EArrayLleno{
        if(pos<0 || pos>cantElementos)
            throw new EPosFueraRango();
        if (cantElementos == elementos.length)
            throw new EArrayLleno();
        cantElementos++;
        for (int i = cantElementos-1; i < pos; i--)
            elementos[i]= elementos[i-1];
        elementos[pos]=x;
    }

    public void Eliminar(int pos) throws EPosFueraRango, EListaVacia{
        if(pos<0 || pos>cantElementos)
            throw new EPosFueraRango();
        if (cantElementos == 0)
            throw new EListaVacia();
        for (int i = pos; i < cantElementos-1; i++) 
            elementos[i]=elementos[i+1];
        cantElementos--;
    }
}
