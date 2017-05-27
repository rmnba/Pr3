package modelo.seleccion;

import modelo.Rand;
import modelo.ag.Poblacion;
import modelo.cromosomas.Cromosoma;

public class SeleccionRuleta extends MetodoSeleccion {

	@Override
	public void seleccionar(Poblacion pob, boolean maximizar) {
		int[] seleccionados = new int[pob.tam];
		double prob;
		int posSuper;
		for(int i=0; i < pob.tam; ++i){
			prob = Rand.nextDouble();
			posSuper=0;
			while((posSuper < pob.tam) && (prob > pob.individuos[posSuper].getPuntAcum())) 
				posSuper++;
			seleccionados[i] = posSuper;
		}
		Cromosoma[] nuevaPob = new Cromosoma[pob.tam];
		for(int i=0; i < pob.tam; ++i){
			nuevaPob[i] = pob.individuos[seleccionados[i]].copia();
		}
		
		pob.individuos = nuevaPob;
	}

	@Override
	public String toString() {
		return "Ruleta";
	}
}
