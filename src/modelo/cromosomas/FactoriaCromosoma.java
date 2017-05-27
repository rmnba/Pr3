package modelo.cromosomas;

public class FactoriaCromosoma {
	
	private int profMin;
	private int profMax;
	
	public FactoriaCromosoma(int pMin, int pMax){
		this.profMin = pMin;
		this.profMax = pMax;
	}
	
	public Cromosoma creaCromosoma(){
		return new Cromosoma(profMin, profMax);
	}

	public int getProfMin(){
		return profMin;
	}
	
	public int getProfMax(){
		return profMax;
	}
}
