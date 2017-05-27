package modelo.seleccion;

import modelo.ag.Poblacion;

public abstract class MetodoSeleccion {
	
	public abstract void seleccionar(Poblacion pob, boolean maximizar);
	
	public abstract String toString();

}
