package modelo;

import modelo.Arbol;
import modelo.Operacion;
import modelo.Cromosoma;

public class Cromosoma {
	
	private Arbol<Operacion> genotipo;
	private double punt;
	private double puntAcum;
	private double adaptacion;
	public Cromosoma (int profMin, int profMax){
		genotipo = new Arbol<Operacion>(Operacion.A0);	// La Op no influye, se sobreescribe
		genotipo.creaArbolAleatorio(profMin, profMax);
	}
	
	public Cromosoma copia(){
		Cromosoma ret = new Cromosoma(genotipo.getProfMin(),genotipo.getProfMax());
		ret.punt = this.punt;
		ret.puntAcum = this.puntAcum;
		ret.adaptacion = this.adaptacion;
		ret.genotipo = genotipo.copia();
		return ret;
	}
	
	
}
