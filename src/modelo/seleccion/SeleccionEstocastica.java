package modelo.seleccion;

import modelo.Rand;
import modelo.ag.Poblacion;
import modelo.cromosomas.Cromosoma;

public class SeleccionEstocastica extends MetodoSeleccion 
{

	@Override
	public void seleccionar(Poblacion pob, boolean maximizar) {
		int[] seleccionados = new int[pob.tam];
		double prob;
		int posSuper;
		double seg = 1 / pob.tam;	// Tamano del segmento (1/N)
		prob = Rand.nextDouble() * seg;		// Primera marca (entre 0 y seg)
		for(int i=0; i < pob.tam; ++i){
			posSuper = 0;
			while((posSuper < pob.tam) && (prob > pob.individuos[posSuper].getPuntAcum())) 
				posSuper++;
			seleccionados[i] = posSuper;
			prob += seg;
		}
		Cromosoma[] nuevaPob = new Cromosoma[pob.tam];
		for(int i=0; i < pob.tam; ++i){
			nuevaPob[i] = pob.individuos[seleccionados[i]].copia();
		}
		
		pob.individuos = nuevaPob;
	}

	@Override
	public String toString() {
		return "Estocastico";
	}

}
