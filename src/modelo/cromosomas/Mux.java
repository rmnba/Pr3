package modelo.cromosomas;

public class Mux 
{
	private boolean a0;
	private boolean a1;
	private boolean a2;
	
	private boolean d0;
	private boolean d1;
	private boolean d2;
	private boolean d3;
	private boolean d4;
	private boolean d5;
	private boolean d6;
	private boolean d7;
	
	private int elems;
	
	public Mux(int elems)
	{
		this.a0 = false;
		this.a1 = false;
		this.a2 = false;
		
		this.d0 = true;
		this.d1 = false;
		this.d2 = false;
		this.d3 = false;
		this.d4 = false;
		this.d5 = false;
		this.d6 = false;
		this.d7 = false;
		
		this.elems = elems;
	}
	
	public int evalua()
	{
		if (this.elems == 11)
		{
			this.d0 = (!this.a0 && !this.a1 && !this.a2);
			this.d1 = (!this.a0 && !this.a1 && this.a2);
			this.d2 = (!this.a0 && this.a1 && !this.a2);
			this.d3 = (!this.a0 && this.a1 && this.a2);
			this.d4 = (this.a0 && !this.a1 && !this.a2);
			this.d5 = (this.a0 && !this.a1 && this.a2);
			this.d6 = (this.a0 && this.a1 && !this.a2);
			this.d7 = (this.a0 && this.a1 && this.a2);
		}
		else
		{
			this.d0 = (!this.a0 && !this.a1);
			this.d1 = (!this.a0 && this.a1);
			this.d2 = (this.a0 && !this.a1);
			this.d3 = (this.a0 && this.a1);
		}
		
		return devolver();
	}
	
	private int devolver()
	{
		if (d0)
			return 0;
		else if (d1)
			return 1;
		else if (d2)
			return 2;
		else if (d3)
			return 3;
		else if (d4)
			return 4;
		else if (d5)
			return 5;
		else if (d6)
			return 6;
		else
			return 7;
	}

	public boolean isA0() {
		return a0;
	}

	public void setA0(boolean a0) {
		this.a0 = a0;
	}

	public boolean isA1() {
		return a1;
	}

	public void setA1(boolean a1) {
		this.a1 = a1;
	}

	public boolean isA2() {
		return a2;
	}

	public void setA2(boolean a2) {
		this.a2 = a2;
	}

	public boolean isD0() {
		return d0;
	}

	public void setD0(boolean d0) {
		this.d0 = d0;
	}

	public boolean isD1() {
		return d1;
	}

	public void setD1(boolean d1) {
		this.d1 = d1;
	}

	public boolean isD2() {
		return d2;
	}

	public void setD2(boolean d2) {
		this.d2 = d2;
	}

	public boolean isD3() {
		return d3;
	}

	public void setD3(boolean d3) {
		this.d3 = d3;
	}

	public boolean isD4() {
		return d4;
	}

	public void setD4(boolean d4) {
		this.d4 = d4;
	}

	public boolean isD5() {
		return d5;
	}

	public void setD5(boolean d5) {
		this.d5 = d5;
	}

	public boolean isD6() {
		return d6;
	}

	public void setD6(boolean d6) {
		this.d6 = d6;
	}

	public boolean isD7() {
		return d7;
	}

	public void setD7(boolean d7) {
		this.d7 = d7;
	}
}
