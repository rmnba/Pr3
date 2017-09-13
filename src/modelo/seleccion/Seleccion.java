package modelo.seleccion;

import modelo.poblacion.Chromosome;
import modelo.poblacion.Individuals;

public abstract class Seleccion {
		

	// Devuelve las posiciones seleccionadas del array del fitness de cada individuo
	public abstract int[] selected(double fitnessNODESPLAZADO[]);
	
	//Devuelve la poblacion seleccionada.
	public void getnewpopulation(int[]selected, Individuals popu){
		Chromosome [] newpopu = new Chromosome[selected.length];
		for (int i = 0; i < selected.length; i++) {
			newpopu[i] = new Chromosome(popu.getIndividuals()[selected[i]]);
		}
		popu.setIndividuals(newpopu);
	}
	
}
