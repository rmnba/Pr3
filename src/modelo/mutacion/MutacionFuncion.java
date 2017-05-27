package modelo.mutacion;

import modelo.cromosomas.Cromosoma;
import modelo.cromosomas.Nodo;
import modelo.cromosomas.Operacion;

public class MutacionFuncion extends MetodoMutacion {

	@Override
	public void mutar(Cromosoma c) 
	{
		Nodo<Operacion> n = c.getNodoFuncionAleatorio();
		if(n == null)	
			return;
		switch(n.getElem())
		{
		case AND:
			n.setElem(Operacion.OR);
			break;
		case OR:
			n.setElem(Operacion.AND);
			break;
		default:
			break;
		
		}

	}
	
	@Override
	public String toString() {
		return "Funcion";
	}

}
