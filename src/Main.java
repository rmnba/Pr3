import java.awt.EventQueue;

import vista.Ventana;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ventana ventana = new Ventana();
		EventQueue.invokeLater(new Runnable()
		{

			@Override
			public void run() 
			{
				ventana.setVisible(true);						
			}
			
		});
	}

}
