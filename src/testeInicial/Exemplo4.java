package testeInicial;

import java.util.ArrayList;

public class Exemplo4 {

	public static ArrayList<Integer> lista = new ArrayList<Integer>();
	public int inicial;
	
	public Exemplo4(int valor) {
		this.inicial = valor;
	}
	
	public static void main(String[] args) {
	
		Thread th = new Thread() {
			public void run() {
				System.out.println("Estou na thread:" + Thread.currentThread().getId());
				
				System.out.println("Finalizei a thread:" + Thread.currentThread().getId());
				
			}
		};
		
		th.start();
		
	}
}
