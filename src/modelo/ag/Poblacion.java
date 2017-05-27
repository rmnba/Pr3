package modelo.ag;

import modelo.cromosomas.Cromosoma;

public class Poblacion {
	
	public int tam;
	public Cromosoma[] individuos;
	
	public void generaPoblacionAleatoria(int tam, int profMin, int profMax){
		this.tam = tam;
		this.individuos = new Cromosoma[tam];
		for(int i=0; i < tam; ++i){
			this.individuos[i] = new Cromosoma(profMin, profMax);
		}
	}
	
	public void evalua(){
		for(int i=0; i < tam; ++i){
			//TODO
			//this.individuos[i].evalua(m);
		}
	}

}
