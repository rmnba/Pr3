package modelo.cromosomas;

import modelo.cromosomas.Arbol;
import modelo.cromosomas.Cromosoma;
import modelo.cromosomas.Operacion;

public class Cromosoma {
	
	private Arbol<Operacion> genotipo;
	private double punt;
	private double puntAcum;
	private double adaptacion;
	
	public Cromosoma (int profMin, int profMax){
		genotipo = new Arbol<Operacion>(Operacion.A0);
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
	
	public Nodo<Operacion> getNodoFuncionAleatorio()
	{
		return genotipo.getNodoFuncionAleatorio();
	}
	
	public Nodo<Operacion> getTerminalAleatorio()
	{
		return genotipo.getTerminalAleatorio();		
	}
	
	public Arbol<Operacion> getGenotipo()
	{
		return this.genotipo;
	}
	
	public void setPuntAcum(double puntAcum)
	{
		this.puntAcum = puntAcum;
	}
	
	public double getPuntAcum()
	{
		return this.puntAcum;
	}
	
	public double getAdaptacion()
	{
		return this.adaptacion;
	}
	
	public void setPunt(double punt)
	{
		this.punt = punt;
	}
	
	public double getPunt()
	{
		return this.punt;
	}
}
