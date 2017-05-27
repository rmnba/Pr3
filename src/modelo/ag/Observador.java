package modelo.ag;

import modelo.cromosomas.Cromosoma;

public interface Observador {

	void onGeneracionTerminada(Poblacion pob, Cromosoma mejorGen, Cromosoma elMejor, double media);
	
	void onAGSTerminado(Cromosoma elMejor);
}
