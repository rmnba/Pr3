package main;


import controlador.Controlador;
import vista.Ventana;

public class Main {
	
	public static void main(String[] args) {	
		
		Ventana window = new Ventana();
		new Controlador(window);
	}
}
