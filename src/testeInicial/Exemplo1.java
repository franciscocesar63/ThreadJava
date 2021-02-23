package testeInicial;

import java.util.ArrayList;

public class Exemplo1 extends Thread{

	public static ArrayList<Integer> lista = new ArrayList<Integer>();
	public int inicial;
	
	public Exemplo1(int valor) {
		this.inicial = valor;
	}
	
	public static void main(String[] args) {
	
		for(int x=1; x<10; x++)
			lista.add(x);
		
		Exemplo1 exemA = new Exemplo1(0);
		Exemplo1 exemB = new Exemplo1(1);
		
		exemA.start();
		exemB.start();
			
	}
	
	public void run() {
		int soma = this.inicial;
		
		for(int i: lista) {
			soma += i;
			System.out.println("Thread id:" + Thread.currentThread().getId());
			
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Resultado:" + soma );
	}
		
}
