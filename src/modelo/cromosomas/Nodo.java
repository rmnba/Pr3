package modelo.cromosomas;

import java.util.HashMap;
import java.util.Map;

import modelo.cromosomas.Nodo;

public class Nodo<T>
{
	private Nodo<T> padre;
	
	private Nodo<T>[] hijos;
	
	private int numHijos;
	
	private int pos;
	
	private T elem;
	
	public static Map <Operacion, Integer> operaciones;
	private int numNodos;
	
	public Nodo(T elem, Nodo<T> padre, int nHijos, int pos)
	{
		this.elem = elem;
		this.numHijos = nHijos;
		operaciones = new HashMap<Operacion, Integer>();
		this.rellenarOperaciones();
		this.padre = padre;
		this.hijos = new Nodo[nHijos];
		this.pos = pos;
	}
	
	public int actualizaNumNodos()
	{
		int n = 1;
		for(int i=0; i < numHijos; ++i)
			n += hijos[i].actualizaNumNodos();
		
		this.numNodos = n;
		return n;
	}
	
	public boolean addHijo (Nodo<T> h, int pos)
	{
		if (pos >= this.numHijos)
			return false;		
		this.hijos[pos] = h;
		h.pos = pos;
		
		return true;
	}
	
	public boolean esTerminal()
	{
		return (this.numHijos == 0);
	}

	public T getElem() 
	{
		return this.elem;
	}

	public void setElem(T elem) 
	{
		this.elem = elem;
	}

	public Nodo<T> getPadre() {
		return this.padre;
	}

	public void setPadre(Nodo<T> padre) 
	{
		this.padre = padre;
	}

	public Nodo<T>[] getHijos() 
	{
		return this.hijos;
	}

	public void setHijos(Nodo<T>[] hijos) 
	{
		this.hijos = hijos;
	}

	public int getNumHijos() 
	{
		return this.numHijos;
	}

	public void setNumHijos(int numHijos) 
	{
		this.numHijos = numHijos;
	}

	public int getPos() 
	{
		return this.pos;
	}

	public void setPos(int pos) 
	{
		this.pos = pos;
	}
	
	public int evalua(Mux mux)
	{
		if (this.elem == Operacion.A0)
			mux.setA0(true);
		else if(this.elem == Operacion.A1)
			mux.setA1(true);
		else if(this.elem == Operacion.A2)
			mux.setA2(true);
		else if (this.elem == Operacion.AND)
			return (this.hijos[0].evalua(mux) && this.hijos[1].evalua(mux));
		else if (this.elem == Operacion.OR)
			return (this.hijos[0].evalua(mux) || this.hijos[1].evalua(mux));
		else if (this.elem == Operacion.NOT)
			return (!this.hijos[0].evalua(mux));
		else if (this.elem == Operacion.IF)
			if (this.hijos[0].evalua(mux))
				return this.hijos[1].evalua(mux);
			else
				return this.hijos[2].evalua(mux);
		
		else
			return mux.evalua();
	}
	
	private void rellenarOperaciones()
	{
		operaciones.put(Operacion.A0, 0);
		operaciones.put(Operacion.A1, 0);
		operaciones.put(Operacion.A2, 0);
		operaciones.put(Operacion.D0, 0);
		operaciones.put(Operacion.D1, 0);
		operaciones.put(Operacion.D2, 0);
		operaciones.put(Operacion.D3, 0);
		operaciones.put(Operacion.D4, 0);
		operaciones.put(Operacion.D5, 0);
		operaciones.put(Operacion.D6, 0);
		operaciones.put(Operacion.D7, 0);
		operaciones.put(Operacion.AND, 2);
		operaciones.put(Operacion.NOT, 1);
		operaciones.put(Operacion.IF, 3);
		operaciones.put(Operacion.OR, 2);
	}
	
	public void setNumNodos(int nodos) {
		numNodos = nodos;
	}
	
	public Nodo<T> copia(Nodo<T> padre) {
		Nodo<T> ret = new Nodo<T>(this.elem, padre, this.numHijos, this.pos);
		Nodo<T>[] hijos = new Nodo[this.numHijos];
		for(int i=0; i < this.numHijos; ++i){
			hijos[i] = this.hijos[i].copia(ret);
		}
		ret.setHijos(hijos);
		ret.setElem(this.elem);
		ret.setNumNodos(this.numHijos);
		return ret;
	}
}
