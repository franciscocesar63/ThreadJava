package testeSincronia;

public class Exemplo {

	public static void main(String[] args) {
		CuboNaoSinc cubo = new CuboNaoSinc();
		Consumidor consumidor = new Consumidor(cubo, 1);
		Produtor produtor = new Produtor(cubo, 1);
		
		produtor.start();
		consumidor.start();
	}
}
