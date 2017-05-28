package modelo.cromosomas;

public class FactoriaCromosoma {
	
	private int profMin;
	private int profMax;
	private int tamañoProblema;
	public FactoriaCromosoma(int pMin, int pMax, int tamaño){
		this.profMin = pMin;
		this.profMax = pMax;
		tamañoProblema = tamaño;
	}
	
	public Cromosoma creaCromosoma(){
		return new Cromosoma(profMin, profMax, tamañoProblema);
	}

	public int getProfMin(){
		return profMin;
	}
	
	public int getProfMax(){
		return profMax;
	}
}
