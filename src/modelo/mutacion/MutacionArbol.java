package modelo.mutacion;

import modelo.cromosomas.Arbol;
import modelo.cromosomas.Cromosoma;
import modelo.cromosomas.Nodo;
import modelo.cromosomas.Operacion;

public class MutacionArbol extends MetodoMutacion {
	
	@Override
	public void mutar(Cromosoma c) {
		Arbol<Operacion> arb = c.getGenotipo();	
		arb.actualizaNumNodos();
		Nodo<Operacion> n = null;
		n = arb.getNodoFuncionAleatorio();
		if(n != null){
			Nodo<Operacion> nuevo = arb.creaArbol(n.getPadre(), n, arb.getProfMin(), arb.getProfMax(), n.getPos());
			n.setElem(nuevo.getElem());
			n.setHijos(nuevo.getHijos());
			n.setNumHijos(nuevo.getNumHijos());
			arb.actualizaNumNodos();
		}
	}
	
	@Override
	public String toString() {
		return "Arbol";
	}

}
