package modelo.ag;

import modelo.cromosomas.Cromosoma;
import modelo.cromosomas.FactoriaCromosoma;

public class Poblacion {
	
	public int tam;
	public Cromosoma[] individuos;
	public int bits;
	private FactoriaCromosoma f;
	public Poblacion(FactoriaCromosoma f) {
		this.f = f;
	}
	public void generaPoblacionAleatoria(int tam, int profMin, int profMax){
		this.tam = tam;
		this.individuos = new Cromosoma[tam];
		for(int i=0; i < tam; ++i){
			this.individuos[i] = f.creaCromosoma();
		}
	}
	
	public void evalua(){
		for(int i=0; i < tam; ++i){
			//TODO
			this.individuos[i].evalua();
		}
	}

}
