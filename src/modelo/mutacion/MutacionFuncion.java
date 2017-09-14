package modelo.mutacion;

import java.util.Random;

import modelo.poblacion.Chromosome;
import modelo.poblacion.Function;
import modelo.poblacion.FunctionAnd;
import modelo.poblacion.FunctionIf;
import modelo.poblacion.FunctionNot;
import modelo.poblacion.FunctionOr;
import modelo.poblacion.Gene;
import modelo.poblacion.TreeNode;

public class MutacionFuncion extends Mutacion{

	private int election;
	
	public MutacionFuncion(double p) {
		super(p);
	}

	@Override
	/*
	 *  Al azar se selecciona la nueva funci�n por la que vamos a sustituir a la antigua y llamamos a changeFunction.
	 */
	protected void mutate(Chromosome chromosome) {
		int functionsSize = getFunctionsSize(chromosome.getGenes());
		if (functionsSize != 0) {
			Random rnd = new Random(System.currentTimeMillis());
			election = Math.abs(rnd.nextInt()) % functionsSize;
			int function = Math.abs(rnd.nextInt())% (chromosome.getTypesOfGenes()-1);
			Function newFunction = null;
			switch (function) {
			case 0:
				newFunction = FunctionAnd.getInstance();
				break;
			case 1:
				newFunction = FunctionOr.getInstance();
				break;
			case 2:
				newFunction = FunctionNot.getInstance();
				break;
			case 3:
				newFunction = FunctionIf.getInstance();
			}
			changeFunction(chromosome, chromosome.getGenes(), newFunction,function);
		}
		
	}
	
	/*
	 *  A�ade al cromosoma un nodo terminal.
	 */
	 private void addRandomTerminal(Chromosome chromosome, TreeNode<Gene> gene) {
		  Random rnd = new Random(System.currentTimeMillis());
		  int election1 = Math.abs(rnd.nextInt())% 11;
		  switch (election1) {
		  case 0:
		   gene.addChild(chromosome.getA0());
		   break;
		  case 1:
		   gene.addChild(chromosome.getA1());
		   break;
		  case 2:
		   gene.addChild(chromosome.getA2());
		   break;
		  case 3:
		   gene.addChild(chromosome.getD0());
		   break;
		  case 4:
		   gene.addChild(chromosome.getD1());
		   break;
		  case 5:
		   gene.addChild(chromosome.getD2());
		   break;
		  case 6:
		   gene.addChild(chromosome.getD3());
		   break;
		  case 7:
		   gene.addChild(chromosome.getD4());
		   break;
		  case 8:
		   gene.addChild(chromosome.getD5());
		   break;
		  case 9:
		   gene.addChild(chromosome.getD6());
		   break;
		  case 10:
		   gene.addChild(chromosome.getD7());
		   break;
		  }
		 }
	
	/* 
	 * Recorremos el arbol de raiz a hojas y elegimos la funci�n que vamos a cambiar basandonos en el paramentro election.
	 * Se cambia la funci�n y se ajusta el numero de hijos.
	 */
	private void changeFunction(Chromosome chromosome,TreeNode<Gene> genes, Function newFunction,int idfunction) {
		if (Function.class.isInstance(genes.getData())) {
			if (election == 0){
				int remove;
				Random rnd = new Random(System.currentTimeMillis());
				
				if(genes.getChildren().size() != 3 && idfunction == 3){
					while(genes.getChildren().size() < 3) {
						addRandomTerminal(chromosome, genes);
					}
				}
				else if(genes.getChildren().size()  != 2 && (idfunction == 0 || idfunction == 1)){
					while(genes.getChildren().size() < 2) {
						addRandomTerminal(chromosome, genes);
					}
					while(genes.getChildren().size() > 2) {
						remove = Math.abs(rnd.nextInt()) % genes.getChildren().size();
						genes.removeChild(remove);
					}
				}
				else if(genes.getChildren().size()  != 1 && idfunction == 2){
					while(genes.getChildren().size() > 1) {
						remove = Math.abs(rnd.nextInt()) % genes.getChildren().size();
						genes.removeChild(remove);
					}
				}				
				genes.updateFunction(newFunction);
				election--;
			}
			else {
				election--;
				for (TreeNode<Gene> gene : genes.getChildren()) {
					changeFunction(chromosome, gene, newFunction, idfunction);
				}
			}
		}
		else {
			for (TreeNode<Gene> gene : genes.getChildren()) {
				changeFunction(chromosome, gene, newFunction, idfunction);
			}
		}
	}
	
	/* 
	 * Devuelve el n�mero total de nodos funci�n que hay en el cromosoma. 
	 */
	private int getFunctionsSize(TreeNode<Gene> genes) {
			int size = 0;
			if (Function.class.isInstance(genes.getData()))
				size++;
			for (TreeNode<Gene> gene : genes.getChildren()) {
					size += getFunctionsSize(gene);
			}
			return size;
	}

}
