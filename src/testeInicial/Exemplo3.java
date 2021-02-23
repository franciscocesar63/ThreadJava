package testeInicial;

import java.util.ArrayList;

public class Exemplo3 {

	public static ArrayList<Integer> lista = new ArrayList<Integer>();
	
	public static void main(String[] args) {
	
		for(int x=1; x<10; x++)
			lista.add(x);
		
		
		new Thread(t1).start();
		new Thread(t2).start();
	
	}
	
	//interface funcional 
	private static Runnable t1 = new Runnable() {
		
		//precisa implementar o método run
		public void run() {
			int soma = 0;
			
			for(int i: lista) {
				soma += i;
				System.out.println("Thread 1: int"+i);
				
				try {
					Thread.currentThread().sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Resultado1:" + soma );
		}
	};

	private static Runnable t2 = new Runnable() {
		
		//precisa implementar o método run
		public void run() {
			int soma = 0;
			
			for(int i: lista) {
				soma += i;
				System.out.println("Thread 2: int"+i);
				
				try {
					Thread.currentThread().sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Resultado2:" + soma );
		}
	};

	

	
	
}
