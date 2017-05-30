package modelo.ag;

import java.util.ArrayList;

import modelo.Rand;
import modelo.cromosomas.Cromosoma;
import modelo.cromosomas.FactoriaCromosoma;

public class AGS {
	private FactoriaCromosoma factoria;
	private Poblacion pob;
	private int indexElMejor;
	private Cromosoma elMejor;
	private Parametros param;
	private int generacion;
	private int generacionesDescartadas;
	
	private ArrayList<Observador> obs = new ArrayList<Observador>();
	
	public AGS(FactoriaCromosoma f, Parametros p){
		this.factoria = f;
		this.param = p;
		this.pob = new Poblacion(f);
	}
	
	public Cromosoma ejecuta() {
		double mediaActual, mediaAnterior;
		this.generacionesDescartadas = 0;
		this.generacion = 0;
		this.pob.generaPoblacionAleatoria(param.tamPob, factoria.getProfMin(), factoria.getProfMax());
		mediaAnterior = this.evaluarPoblacion();
		this.elMejor = null;
		while(generacion < param.iteraciones){
			int nElite = (int)(this.pob.tam * 0.02);
			Cromosoma[] elite = null;
			if(param.elitismo){
				elite = new Cromosoma[nElite];
				this.quicksort(this.pob.individuos, 0, this.pob.tam-1);
				for(int i=0; i < nElite; ++i){
					if(!param.maximizar){
						elite[i] = this.pob.individuos[i].copia();
					}
					else{
						elite[i] = this.pob.individuos[this.pob.tam-1-i].copia();
					}
				}
			}
			this.seleccion();
			this.reproduccion();
			this.mutacion();
			for(int i=0; i < this.pob.tam; ++i){
				//TODO
				//this.pob.individuos[i].eliminaIntrones();
			}
			if(param.bloating){
				for(int i=0; i < this.pob.tam; ++i){
					//TODO
					this.pob.individuos[i].bloating(param.profMax);			
				}
			}
			if(param.elitismo){
				this.quicksort(this.pob.individuos, 0, this.pob.tam-1);
				for(int i=0; i < nElite; ++i){
					// Elitismo: reemplazando por los peores 
					if(!param.maximizar){
						this.pob.individuos[this.pob.tam-1-i] = elite[i].copia();
					}
					else{
						this.pob.individuos[i] = elite[i].copia();
					}
				}
			}
			mediaActual = this.evaluarPoblacion();
			if(param.contractividad){
				if(param.maximizar){
					if(mediaAnterior < mediaActual){
						this.generacion++;
						notifyGeneracionTerminada(this.pob.individuos[this.indexElMejor], elMejor, mediaActual);
					}
					else{
						this.generacionesDescartadas++;
					}
				}
				else{
					if(mediaAnterior > mediaActual){
						this.generacion++;
						notifyGeneracionTerminada(this.pob.individuos[this.indexElMejor], elMejor, mediaActual);
					}
					else{
						this.generacionesDescartadas++;
					}
				}
				if(this.generacionesDescartadas > 10*param.iteraciones){
					param.contractividad = false;	// Si se descartan demasiadas generaciones se deshabilita
					System.out.println("Se ha deshabilitado la contractividad");
				}
			}
			else{
				this.generacion++;
				notifyGeneracionTerminada(this.pob.individuos[this.indexElMejor], elMejor, mediaActual);
			}
		}
		this.elMejor.evalua();
		notifyAGSTerminado(elMejor);
		return this.elMejor;
	}

	private void ajustaAptitud(){
		for(int i=0;  i < pob.tam; ++i){
			pob.individuos[i].evalua();	// Evalua actualiza por dentro el campo adaptacion
		}
	}
	
	private double evaluarPoblacion(){
		double maximo = Double.MIN_VALUE;
		double minimo = Double.MAX_VALUE;
		double aux = 0;
		double sumaAptitud = 0;
		double puntAcum = 0;
		double media = 0;
		
		ajustaAptitud();
		
		// Buscamos el maximo
		for(int i=0;  i < pob.tam; ++i){
			aux = pob.individuos[i].getAdaptacion();
			sumaAptitud += aux;
			if(maximo < aux){
				maximo = aux;
				indexElMejor = i;
			}	
		}
		for(int i=0; i < pob.tam; ++i){
			pob.individuos[i].setPunt((pob.individuos[i].getAdaptacion()/sumaAptitud));
			pob.individuos[i].setPuntAcum((pob.individuos[i].getPunt() + puntAcum));
			puntAcum += pob.individuos[i].getPunt();
		}
		// Si se quiere minimizar, se busca el minimo (la aptitud es igual a la aptitud del maximo - aptitud individuo)
		if(!param.maximizar){
			// Se reajustan las aptitudes 
			sumaAptitud = 0;
			for(int i=0;  i < pob.tam; ++i){
				aux = maximo - pob.individuos[i].getAdaptacion();
				sumaAptitud += aux;
			}
			// Se busca el minimo
			minimo = maximo;
			for(int i=0; i < pob.tam; ++i){
				if(pob.individuos[i].getAdaptacion() < minimo){
					minimo = pob.individuos[i].getAdaptacion();
					indexElMejor = i;
				}
			}
			puntAcum = 0;
			for(int i=0; i < pob.tam; ++i){
				pob.individuos[i].setPunt(((maximo - pob.individuos[i].getAdaptacion())/sumaAptitud));
				pob.individuos[i].setPuntAcum((pob.individuos[i].getPunt() + puntAcum));
				puntAcum += pob.individuos[i].getPunt();
			}
		}
		if(elMejor == null){
			elMejor = pob.individuos[indexElMejor].copia();
		}
		else{
			double evaluacionElMejor = this.elMejor.getAdaptacion();
			double evaluacionMejorActual = this.pob.individuos[indexElMejor].getAdaptacion();
			
			if(param.maximizar && (evaluacionMejorActual > evaluacionElMejor)){ // maximo
				elMejor = pob.individuos[indexElMejor].copia();
			}
			else if(!param.maximizar && (evaluacionMejorActual < evaluacionElMejor)){ // minimo
				elMejor = pob.individuos[indexElMejor].copia();
			}
		}
		
		for(int i=0; i < pob.tam; ++i){
			media += this.pob.individuos[i].getAdaptacion();
		}
		return (media / this.pob.tam);
	}
	
	private void seleccion(){
		param.seleccion.seleccionar(pob, param.maximizar);
	}
	
	private void mutacion() {
		double prob;
		for(int i=0; i < this.pob.tam; ++i){
			prob = Rand.nextDouble();
			if(prob < param.probMutacion){
				param.mutacion.mutar(this.pob.individuos[i]);
			}
		}	
		
	}

	private void reproduccion() {
		int seleccionados[] = new int[this.pob.tam];
		int numSeleCruce = 0;
		double prob;
		for(int i=0; i < this.pob.tam; ++i){
			prob = Rand.nextDouble();
			if(prob < param.probCruce){
				seleccionados[numSeleCruce] = i;
				numSeleCruce++;
			}
		}
		
		if(numSeleCruce % 2 == 1){
			numSeleCruce--;
		}
		for(int i=0; i < numSeleCruce; i+=2){
			param.cruce.cruzar(this.pob.individuos[seleccionados[i]], this.pob.individuos[seleccionados[i+1]]);			
		}	
		
	}
	//Ordena de menor a mayor
	private void quicksort(Cromosoma A[], int izq, int der) {
	  Cromosoma pivote= A[izq]; // tomamos primer elemento como pivote
	  int i=izq; // i realiza la busqueda de izquierda a derecha
	  int j=der; // j realiza la busqueda de derecha a izquierda
	  Cromosoma aux;
	 
	  while(i<j){            // mientras no se crucen las busquedas
	     while(A[i].getAdaptacion() <= pivote.getAdaptacion() && i<j) i++; // busca elemento mayor que pivote
	     while(A[j].getAdaptacion() > pivote.getAdaptacion()) j--;         // busca elemento menor que pivote
	     if (i<j) {                      // si no se han cruzado                      
	         aux= A[i];                  // los intercambia
	         A[i]=A[j];
	         A[j]=aux;
	     }
	   }
	   A[izq]=A[j]; // se coloca el pivote en su lugar de forma que tendremos
	   A[j]=pivote; // los menores a su izquierda y los mayores a su derecha
	   if(izq<j-1)
	      quicksort(A,izq,j-1); // ordenamos subarray izquierdo
	   if(j+1 <der)
	      quicksort(A,j+1,der); // ordenamos subarray derecho
	}
	
	public void addObserver(Observador o){
		if(!obs.contains(o)){
			obs.add(o);
		}
	}
	
	public void removeObserver(Observador o){
		if(obs.contains(o)){
			obs.remove(o);
		}
	}
	
	private void notifyAGSTerminado(Cromosoma c) {
		for(Observador o : obs)
			o.onAGSTerminado(c);
	}

	private void notifyGeneracionTerminada(Cromosoma c,
			Cromosoma elMejor, double media) {
		for(Observador o : obs)
			o.onGeneracionTerminada(pob, c, elMejor, media);
		
	}
}
