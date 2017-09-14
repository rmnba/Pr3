package modelo.mutacion;

import java.util.Random;

import modelo.poblacion.Chromosome;
import modelo.poblacion.Individuals;

public abstract class Mutacion {
	
	private double pMutation;
	

	public Mutacion(double p) {
		pMutation = p;
	}
	
	public void mutatePopulation(Individuals ind) {
		Chromosome individuals[] = ind.getIndividuals();
		Random rnd = new Random(System.currentTimeMillis());
		for (int i = 0; i < individuals.length; i++) {//para cada individuo
			if (Math.abs(rnd.nextDouble()) % 1 <= pMutation){//si hay que mutarlo
				this.mutate(individuals[i]);
			}
		}
	}

	protected abstract void mutate(Chromosome chromosome);
}
