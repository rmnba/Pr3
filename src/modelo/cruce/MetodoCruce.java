package modelo.cruce;

import modelo.cromosomas.Cromosoma;

public abstract class MetodoCruce {

	
	public abstract void cruzar(Cromosoma a, Cromosoma b);
	
	public abstract String toString();
}
