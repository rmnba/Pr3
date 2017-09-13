package modelo.bloating;

import modelo.poblacion.Chromosome;

public class PenalizacionBienFundamentada extends Bloating{

	public PenalizacionBienFundamentada(int s) {
		super(s);
	}

	@Override
	//Se le añade al fitness k*nºde nodos a modo de bloating.
	// A su vez, si el cromosoma está formado por una hoja, se le penaliza también.
	
	public void controlBloating(Chromosome chromosome, double averageSizeOrK) {
		chromosome.setFitness(chromosome.getFitness() + averageSizeOrK * chromosome.getNodes());
		if (chromosome.getDepth() <= 4)
			chromosome.setFitness(2049);
	}

}
