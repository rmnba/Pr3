package controlador;

import modelo.Cruce;
import modelo.Funcion;
import modelo.Mutacion;
import modelo.Rand;
import modelo.Select;
import modelo.ag.AGS;
import modelo.ag.Observador;
import modelo.ag.Parametros;
import modelo.cromosomas.Cromosoma;
import modelo.cromosomas.FactoriaCromosoma;
import modelo.cruce.CruceSimple;


public class Controlador 
{
	private Cromosoma cromosoma;
	private boolean maximizar; 
	private AGS alg;
	private long lastSeed;
	
	public Controlador ()
	{
	}
	
	public void addObserver(Observador o)
	{
		alg.addObserver(o);
	}
	
	public void setParameters(Parametros p, int tamano){
		FactoriaCromosoma f = new FactoriaCromosoma(p.profMin,p.profMax, tamano);
		alg = new AGS(f, p);
		this.cromosoma = f.creaCromosoma();
		Rand.setSeed(p.seed);
	}
	
	public void setParametersRun(Funcion funcion, int n,  double tol, int pob, int generaciones, double pCruce, double pMutacion, long seed, Cruce cruce, Select seleccion, Mutacion mutacion, boolean elitismo)
	{
		if(seed == 0)
			lastSeed = System.currentTimeMillis();
		
		else
			lastSeed = seed;
		
		this.generaFuncion(funcion, n, tol);
		//alg = new AGS(pob, this.cromosoma, generaciones, pCruce, pMutacion, seleccion, cruce, elitismo, maximizar, lastSeed, mutacion);
	}
	
	public void setParametersReRun(Funcion funcion, int n,  double tol, int pob, int generaciones, double pCruce, double pMutacion, long seed, Cruce cruce, Select seleccion, Mutacion mutacion, boolean elitismo)
	{
		if(seed != 0)
			lastSeed = seed;
		
		this.generaFuncion(funcion, n, tol);
		//alg = new AGS(pob, this.cromosoma, generaciones, pCruce, pMutacion, seleccion, cruce, elitismo, maximizar, lastSeed, mutacion);
	}
	
	public void lanzaAGS()
	{
		alg.ejecuta();
	}

	private void generaFuncion(Funcion f, int n, double tol)
	{
		
		switch(f)
		{
			case Parte1: break;
			case Parte2: break;
		}
		
	}
	
}
