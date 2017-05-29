package modelo;

import java.util.Random;

public class Rand 
{
	
	private static Random g = new Random();
	
	public static void setSeed(long seed)
	{
		g.setSeed(seed);
	}
	
	public static int nextInt(int bound)
	{
		return g.nextInt(bound);
	}
	
	public static int nextInt()
	{
		return g.nextInt();
	}
	
	public static double nextDouble()
	{
		return g.nextDouble();
	}
	
}
