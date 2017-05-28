package modelo.cruce;

import modelo.Rand;
import modelo.cromosomas.Arbol;
import modelo.cromosomas.Cromosoma;
import modelo.cromosomas.Nodo;
import modelo.cromosomas.Operacion;

public class CruceSimple extends MetodoCruce {
	
	@Override
	public void cruzar(Cromosoma a, Cromosoma b){
		Arbol<Operacion> arbA = a.getGenotipo();
		Arbol<Operacion> arbB = b.getGenotipo();
		int corteA;
		arbA.actualizaNumNodos();
		arbB.actualizaNumNodos();
		if(arbA.getNumNodos() == 1){
			corteA = 0;
		}
		else{
			corteA = 1 + Rand.nextInt(arbA.getNumNodos()-1); // Se +1 para evitar la raiz
		}
		
		int corteB;
		if(arbB.getNumNodos() == 1){
			corteB = 0;
		}
		else{
			corteB = 1 + Rand.nextInt(arbB.getNumNodos()-1); // Se +1 para evitar la raiz
		}
		Nodo<Operacion> nodoA = arbA.buscaNodo(corteA);
		Nodo<Operacion> nodoB = arbB.buscaNodo(corteB);
		try{
			arbA.insertaNodo(nodoA.getPadre(), nodoB, nodoA.getPos());
			arbB.insertaNodo(nodoB.getPadre(), nodoA, nodoB.getPos());
		}catch(Exception e){
			if(nodoA == null){
				System.out.println(arbA.toString());
				System.out.println("nodoA es nulo (corte: " + corteA + ")");
			}
			if(nodoB == null){
				System.out.println(arbB.toString());
				System.out.println("nodoB es nulo (corte: " + corteB + ")");
			}
			e.printStackTrace();
		}
		
		int aux = nodoA.getPos();
		nodoA.setPos(nodoB.getPos());
		nodoB.setPos(aux);
		
		arbA.actualizaNumNodos();
		arbB.actualizaNumNodos();
	}

	@Override
	public String toString() {
		return "Cruce Simple";
	}
}
