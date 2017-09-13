package main;


import controlador.Control;
import vista.Ventana;

public class Main {
	
	public static void main(String[] args) {	
		
		Ventana window = new Ventana();
		new Control(window);
	}
}
