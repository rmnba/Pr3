package modelo;

public enum Operacion
{
	A0, A1, A2, D0, D1, D2, D3, D4, D5, D6, D7, AND, OR, NOT, IF;
	
	public static boolean esTerminal(Operacion o)
	{
		return ((o != Operacion.AND) && (o != Operacion.OR) && (o != Operacion.NOT) && (o != Operacion.IF));
	}
}
