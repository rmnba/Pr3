package modelo.ag;

import modelo.cruce.MetodoCruce;
import modelo.mutacion.MetodoMutacion;
import modelo.seleccion.MetodoSeleccion;

public class Parametros {
	public int tamPob;
	public int iteraciones;
	public int profMin;
	public int profMax;
	public boolean maximizar;
	public boolean elitismo;
	public boolean contractividad;
	public boolean bloating;
	public MetodoCruce cruce;
	public MetodoMutacion mutacion;
	public MetodoSeleccion seleccion;
	public double probCruce;
	public double probMutacion;
	public int seed;
	
	public Parametros(){
		
	}
	
	public Parametros(int t, int i, int pmin, int pmax, boolean m, boolean e, boolean c, boolean b, MetodoCruce cruce, MetodoMutacion mutacion, MetodoSeleccion seleccion, double probCruce, double probMutacion, int seed){
		this.tamPob = t;
		this.iteraciones = i;
		this.profMin = pmin;
		this.profMax = pmax;
		this.maximizar = m;
		this.elitismo = e;
		this.contractividad = c;
		this.bloating = b;
		this.cruce = cruce;
		this.mutacion = mutacion;
		this.seleccion = seleccion;
		this.seed = seed;
	}
	
	public String toString(){
		String ret = "";
		ret += "Semilla: " + seed + "\n";
		ret += "Poblacion: " + tamPob + "\n";
		ret += "Iteraciones: " + iteraciones + "\n";
		ret += "ProfMin: " + profMin + "\n";
		ret += "ProfMax: " + profMax + "\n";
		ret += "Elitismo: " + elitismo + "\n";
		ret += "Contractividad: " + contractividad + "\n";
		ret += "Bloating: " + bloating + "\n";
		ret += "Cruce: " + cruce + "\n";
		ret += "Mutacion: " + mutacion + "\n";
		ret += "Seleccion: " + seleccion + "\n";
		ret += "ProbCruce: " + probCruce + "\n";
		ret += "ProbMutacion: " + probMutacion + "\n";
		ret += "\n";
		return ret;
	}

}
