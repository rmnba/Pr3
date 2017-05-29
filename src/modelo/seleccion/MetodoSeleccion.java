package modelo.seleccion;

import modelo.ag.Poblacion;
import modelo.cromosomas.FactoriaCromosoma;

public abstract class MetodoSeleccion {
	
	public abstract void seleccionar(Poblacion pob, boolean maximizar);
	
	public abstract String toString();

}
