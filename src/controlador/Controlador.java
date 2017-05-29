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
import modelo.cruce.MetodoCruce;
import modelo.mutacion.MetodoMutacion;
import modelo.mutacion.MutacionArbol;
import modelo.mutacion.MutacionFuncion;
import modelo.mutacion.MutacionTerminal;
import modelo.seleccion.MetodoSeleccion;
import modelo.seleccion.SeleccionEstocastica;
import modelo.seleccion.SeleccionRuleta;
import modelo.seleccion.SeleccionTorneo;


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
		
		
		MetodoMutacion mut = null;
		switch(mutacion){
			case ARBOL: mut = new MutacionArbol(); break;
			case FUNCION: mut = new MutacionFuncion(); break;
			case TERMINAL: mut = new MutacionTerminal(); break;
		}
		MetodoSeleccion mec = null;
		switch(seleccion) {
			case ESTOCASTICO: mec = new SeleccionEstocastica(); break;
			case TORNEO: mec = new SeleccionTorneo(); break;
			case RULETA: mec = new SeleccionRuleta(); break;
		}
		MetodoCruce mc = new CruceSimple();
		Parametros aux = new Parametros(pob, generaciones, 5, 100, true, elitismo, true, true, mc, mut, mec, pCruce, pMutacion, seed);
		FactoriaCromosoma factoria = null;
		if (funcion == Funcion.Parte1) factoria = new FactoriaCromosoma(5,100,6);
		else factoria = new FactoriaCromosoma(5,100,11);
		alg = new AGS(factoria, aux);
	}
	
	public void setParametersReRun(Funcion funcion, int n,  double tol, int pob, int generaciones, double pCruce, double pMutacion, long seed, Cruce cruce, Select seleccion, Mutacion mutacion, boolean elitismo)
	{
		if(seed != 0)
			lastSeed = seed;
		
		//this.generaFuncion(funcion, n, tol);
		//alg = new AGS(pob, this.cromosoma, generaciones, pCruce, pMutacion, seleccion, cruce, elitismo, maximizar, lastSeed, mutacion);
	}
	
	public void lanzaAGS()
	{
		alg.ejecuta();
	}

	
	
}
