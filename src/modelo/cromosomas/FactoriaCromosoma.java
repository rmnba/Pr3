package modelo.cromosomas;

public class FactoriaCromosoma {
	
	private int profMin;
	private int profMax;
	private int tamanoProblema;
	public FactoriaCromosoma(int pMin, int pMax, int tamano){
		this.profMin = pMin;
		this.profMax = pMax;
		tamanoProblema = tamano;
	}
	
	public Cromosoma creaCromosoma(){
		return new Cromosoma(profMin, profMax, tamanoProblema);
	}

	public int getProfMin(){
		return profMin;
	}
	
	public int getProfMax(){
		return profMax;
	}
}
