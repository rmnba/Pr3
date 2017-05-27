package modelo.cromosomas;

import modelo.Rand;
import modelo.cromosomas.Arbol;
import modelo.cromosomas.Nodo;
import modelo.cromosomas.Operacion;

public class Arbol<T> 
{
	private Nodo<T> raiz;
	
	private int min;
	private int max;
	private int numNodos;
	
	public Arbol (T raiz)
	{
		this.raiz = new Nodo<T>(raiz, null, 0, Nodo.operaciones.get(raiz));
		this.numNodos = 0;
	}
	
	public Nodo<T> creaArbol(Nodo<T> padre, Nodo<T> a, int pMin, int pMax, int pos)
	{
		if (pMin > 0)
		{
			int r = Rand.nextInt(6) + 4;
			T op = (T) Operacion.values()[r];
			a = new Nodo<T>(op, padre, Nodo.operaciones.get(op), pos);
			this.numNodos = 1;
			for (int i = 0; i < Nodo.operaciones.get(op); ++i)
			{
				Nodo<T> aux = creaArbol(a, a.getHijos()[i], pMin - 1, pMax - 1, i);
				a.addHijo(aux, i);
				this.numNodos++;
			}
		}
		else if (pMax <= 0)
		{
			int r = Rand.nextInt(6);
			T op = (T) Operacion.values()[r];
			a = new Nodo<T>(op, padre, Nodo.operaciones.get(op), pos);
			this.numNodos = 1;
		}
		else
		{
			int r = Rand.nextInt(10);
			T op = (T) Operacion.values()[r];
			a = new Nodo<T>(op, padre, Nodo.operaciones.get(op), pos);
			this.numNodos = 1;
			for (int i = 0; i < Nodo.operaciones.get(op); ++i)
			{
				Nodo<T> aux = creaArbol(a, a.getHijos()[i], pMin - 1, pMax - 1, i);
				a.addHijo(aux, i);
				this.numNodos++;
			}
		}
		return a;
	}
	
	public void actualizaNumNodos()
	{
		this.raiz.actualizaNumNodos();
	}

	public Nodo<T> getTerminalAleatorio() 
	{
		Nodo<T> actual = raiz;
		int numHijos = raiz.getNumHijos();
		while(!actual.esTerminal())
		{
			int h = Rand.nextInt(numHijos);
			actual = actual.getHijos()[h];
			numHijos = actual.getNumHijos();
		}
		return actual;
	}
	
	public void insertaNodo(Nodo<T> padre, Nodo<T> hijo, int pos)
	{
		if(padre != null) 
			padre.addHijo(hijo, pos);
	}
	
	public Nodo<T> buscaNodo(int numeroABuscar)
	{
		Nodo<T> buscado = buscaNodoAux(this.raiz, numeroABuscar);
		return buscado;
	}
	
	public int evalua(Mux mux)
	{
		return raiz.evalua(mux);
	}
	
	private Nodo<T> buscaNodoAux(Nodo<T> raiz, int numeroABuscar)
	{
		java.util.concurrent.LinkedBlockingQueue<Nodo<T>> cola = new java.util.concurrent.LinkedBlockingQueue<Nodo<T>>();
		java.util.concurrent.LinkedBlockingQueue<Nodo<T>> colaC = new java.util.concurrent.LinkedBlockingQueue<Nodo<T>>();
		try 
		{
			cola.put(raiz);
			colaC.put(raiz);
			while(!cola.isEmpty())
			{
				Nodo<T> head = cola.poll();
				for(int i=0; i < head.getNumHijos(); ++i)
				{
					cola.put(head.getHijos()[i]);
					colaC.put(head.getHijos()[i]);
				}
			}
			for(int i=0; i < numeroABuscar; ++i)
				colaC.poll();
			return colaC.poll();
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
			return null;
		}
		
	}

	public Nodo<T> getNodoFuncionAleatorio() 
	{
		if(raiz.getNumHijos() <= 1)
			return null;
		Nodo<T> n = null;
		do
		{
			n = buscaNodo(Rand.nextInt(raiz.getNumHijos()));
		} while(n.esTerminal());
		return n;
	}
	public int getProfMin() {
		return min;
	}

	public void setProfMin(int profMin) {
		this.min = profMin;
	}

	public int getProfMax() {
		return max;
	}

	public void setProfMax(int profMax) {
		this.max = profMax;
	}

	public Arbol<T> copia() {
		Arbol<T> ret = new Arbol<T>(this.raiz.getElem());
		ret.max = this.max;
		ret.min = this.min;
		ret.raiz = this.raiz.copia(ret.raiz);
		return ret;
	}
	public void creaArbolAleatorio(int profMin, int profMax){
		this.min = profMin;
		this.max = profMax;
		this.raiz = creaArbol(null, raiz, profMin, profMax, 0);
	}
	
	public int getNumNodos()
	{
		return this.numNodos;
	}
	
}
