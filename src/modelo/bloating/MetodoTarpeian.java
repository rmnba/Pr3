
package modelo.bloating;

import java.util.Random;

import modelo.poblacion.Chromosome;

public class MetodoTarpeian extends Bloating{
	
	private int n = 5;
	private Random rnd;

	public MetodoTarpeian(int size) {
		super(size);
		rnd = new Random(System.currentTimeMillis());
	}

	@Override
	// Si la profundidad del arbol o su tama�o son mayor que la media, con p=1/5 se le asigna el peor fitness.
	// A su vez, si el cromosoma est� formado por una hoja, se le penaliza tambi�n.
	public void controlBloating(Chromosome chromosome, double averageSizeOrK) {
		if (getSize() == 0 && (chromosome.getDepth() > averageSizeOrK) && (rnd.nextInt() % n == 0))
			chromosome.setFitness(2049);
		else if (getSize() != 0 && (chromosome.getNodes() > averageSizeOrK) && (rnd.nextInt() % n == 0))
			chromosome.setFitness(2049);
		if (chromosome.getDepth() <= 4)
			chromosome.setFitness(2049);
	}

}
