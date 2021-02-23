package testeInicial;

import java.util.ArrayList;

public class Exemplo2 {
	
	public static ArrayList<Integer> lista = new ArrayList<Integer>();
	
	public static void main(String[] args) {

		lista.add(4);
		lista.add(8);
		lista.add(10);
		
		Exemplo2.fazendoContas();
	
	}
	
	public static void fazendoContas() {

		new Thread() {
			public void run() {
				int soma = 0;
				
				for(int i: lista) {
					soma += i;
					try {
						Thread.currentThread().sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("Resultado:" + soma );
			}
			
		}.start();
	}
	
}
