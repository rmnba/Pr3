package modelo.mutacion;

import modelo.Rand;
import modelo.cromosomas.Cromosoma;
import modelo.cromosomas.Nodo;
import modelo.cromosomas.Operacion;

public class MutacionTerminal extends MetodoMutacion{

	@Override
	public void mutar(Cromosoma c) {
		Operacion op = this.terminales[Rand.nextInt(this.terminales.length)];
		Nodo<Operacion> n = c.getTerminalAleatorio();
		n.setElem(op);
	}
	
	@Override
	public String toString() {
		return "Terminal";
	}
}
