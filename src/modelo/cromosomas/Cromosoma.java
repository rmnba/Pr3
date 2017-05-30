package modelo.cromosomas;

import modelo.cromosomas.Arbol;
import modelo.cromosomas.Cromosoma;
import modelo.cromosomas.Operacion;

public class Cromosoma {
	
	private Arbol<Operacion> genotipo;
	private double punt;
	private double puntAcum;
	private double adaptacion;
	private int tamanoProblema;
	public Cromosoma (int profMin, int profMax, int tamano){
		genotipo = new Arbol<Operacion>(Operacion.A0);
		genotipo.creaArbolAleatorio(profMin, profMax);
		tamanoProblema = tamano;
		punt = 0;
		puntAcum = 0;
		adaptacion = 0;
	}
	
	public Cromosoma copia(){
		Cromosoma ret = new Cromosoma(genotipo.getProfMin(),genotipo.getProfMax(), tamanoProblema);
		ret.punt = this.punt;
		ret.puntAcum = this.puntAcum;
		ret.adaptacion = this.adaptacion;
		ret.genotipo = genotipo.copia();
		return ret;
	}
	public void evalua() {
		this.adaptacion = 0;
		Mux mux = new Mux(tamanoProblema);
		boolean mask[] = null;
		
		if (tamanoProblema == 6) {
			
			for (int i = 0; i < 64; i++) {
				mask = intToMask(i);
				mux.setA0(mask[0]);
				mux.setA1(mask[1]);
				mux.setD0(mask[2]);
				mux.setD1(mask[3]);
				mux.setD2(mask[4]);
				mux.setD3(mask[5]);
				if (mux.resuelve() == genotipo.evalua(mux)) adaptacion++;
			}
		} else {
			for (int i = 0; i < 2048; i++) {
				mask = intToMask(i);
				mux.setA0(mask[0]);
				mux.setA1(mask[1]);
				mux.setA2(mask[2]);
				mux.setD0(mask[3]);
				mux.setD1(mask[4]);
				mux.setD2(mask[5]);
				mux.setD3(mask[6]);
				mux.setD4(mask[7]);
				mux.setD5(mask[8]);
				mux.setD6(mask[9]);
				mux.setD7(mask[10]);
				if (mux.resuelve() == genotipo.evalua(mux)) adaptacion++;
			}
		}
		
	}
	private boolean[] intToMask(int num) {
		int exp=0;
        boolean binario[] = new boolean[tamanoProblema];
        for (int i = 0; i < tamanoProblema; i++) {
        	binario[i] = false;
        }
        int digito = 0;
        while(num!=0){
        	digito = num % 2;            
            if (digito == 1) {
            	binario[exp] = true;
            } 
            exp++;
            num = num/2;
        }
        return binario;
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
	
	public void bloating(int prof){
		genotipo.bloating(prof);
	}
}
