package modelo.bloating;

import modelo.poblacion.Chromosome;

public class PenalizacionBienFundamentada extends Bloating{

	public PenalizacionBienFundamentada(int s) {
		super(s);
	}

	@Override
	//Se le a�ade al fitness k*n�de nodos a modo de bloating.
	// A su vez, si el cromosoma est� formado por una hoja, se le penaliza tambi�n.
	
	public void controlBloating(Chromosome chromosome, double averageSizeOrK) {
		chromosome.setFitness(chromosome.getFitness() + averageSizeOrK * chromosome.getNodes());
		if (chromosome.getDepth() <= 4)
			chromosome.setFitness(2049);
	}

}
