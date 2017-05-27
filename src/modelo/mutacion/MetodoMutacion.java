package modelo.mutacion;

import modelo.cromosomas.Cromosoma;
import modelo.cromosomas.Operacion;

public abstract class MetodoMutacion {
	
	protected Operacion terminales[] = {Operacion.A0, Operacion.A1, Operacion.A2, Operacion.D0, Operacion.D1, 
			Operacion.D2, Operacion.D3, Operacion.D4, Operacion.D5, Operacion.D6, Operacion.D7};
	
	public abstract void mutar(Cromosoma c);

	public abstract String toString();
}
