package modelo.seleccion;

import modelo.Rand;
import modelo.ag.Poblacion;
import modelo.cromosomas.Cromosoma;

public class SeleccionTorneo extends MetodoSeleccion {

	@Override
	public void seleccionar(Poblacion pob, boolean maximizar) {
		int[] seleccionados = new int[pob.tam];
		int posMejor;
		int indexA, indexB, indexC;
		for(int i=0; i < pob.tam; ++i){
			// Torneo con muestreo diferenciado (cada elemento solo una vez)
			indexA = (int) (Rand.nextDouble() * pob.tam);
			do{
				indexB =  (int) (Rand.nextDouble() * pob.tam);
			}while(indexB == indexA);
			do{
				indexC = (int) (Rand.nextDouble() * pob.tam);
			}while(indexB == indexC || indexA == indexC);
			
			if(maximizar){
				if(pob.individuos[indexA].getAdaptacion() > pob.individuos[indexB].getAdaptacion()){
					if(pob.individuos[indexA].getAdaptacion() > pob.individuos[indexC].getAdaptacion()){
						posMejor = indexA;
					}
					else{
						posMejor = indexC;
					}
				}
				else{
					if(pob.individuos[indexC].getAdaptacion() > pob.individuos[indexB].getAdaptacion()){
						posMejor = indexC;
					}
					else{
						posMejor = indexB;
					}	
				}
			}
			else{
				if(pob.individuos[indexA].getAdaptacion() < pob.individuos[indexB].getAdaptacion()){
					if(pob.individuos[indexA].getAdaptacion() < pob.individuos[indexC].getAdaptacion()){
						posMejor = indexA;
					}
					else{
						posMejor = indexC;
					}
				}
				else{
					if(pob.individuos[indexC].getAdaptacion() < pob.individuos[indexB].getAdaptacion()){
						posMejor = indexC;
					}
					else{
						posMejor = indexB;
					}	
				}
			}
			
			seleccionados[i] = posMejor;
		}
		Cromosoma[] nuevaPob = new Cromosoma[pob.tam];
		for(int i=0; i < pob.tam; ++i){
			nuevaPob[i] = pob.individuos[seleccionados[i]].copia();
		}
		
		pob.individuos = nuevaPob;

	}
	
	@Override
	public String toString() {
		return "Torneo";
	}

}
