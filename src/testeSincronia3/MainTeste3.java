package testeSincronia3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class MainTeste3 {

	public static void main(String args[]) {
		ExecutorService service = Executors.newFixedThreadPool(3);
		SincronizadorSoma somador = new SincronizadorSoma();

		IntStream.rangeClosed(1, 5).forEach(count -> service.submit( ()->somador.calcular(count)));
	
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {}
		
		service.shutdown();
		System.out.println( somador.getSum());
		
	}
}
