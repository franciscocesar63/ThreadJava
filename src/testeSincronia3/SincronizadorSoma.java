package testeSincronia3;

public class SincronizadorSoma {

	private int sum = 0;

	public void calcular(int valor) {
		
		//synchronized (this)
		{
			setSum(getSum() + valor);
		}
	}

	
	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

}
