package testeInicial;

import java.util.ArrayList;
import java.util.List;

public class Exemplo0 implements Runnable{

	public ArrayList<Integer> lista = new ArrayList<Integer>();
	public int inicial;
	
	public Exemplo0(List<Integer> lista) {
		this.lista = (ArrayList<Integer>) lista;
	}
	
	public static void main(String[] args) {
	
		List<Integer> listaConcreta1 = new ArrayList<Integer>();
		List<Integer> listaConcreta2 = new ArrayList<Integer>();
		
		for(int i=0; i < 34;i++)
			listaConcreta1.add(i);

		for(int i=12; i < 45;i++)
			listaConcreta2.add(i);
		
		
		Exemplo0 exemA = new Exemplo0(listaConcreta1);
		Exemplo0 exemB = new Exemplo0(listaConcreta2);
		
		new Thread(exemA).start();
		new Thread(exemB).start();
	}


	@Override
	public void run() {
		
		long id = Thread.currentThread().getId();
		
		System.out.println("Executando a thread " + id);
		int soma = 0;
		
		for(int i: this.lista)
			soma += i;
			
		try {
			Thread.currentThread().sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("A soma da thread " + id + " é " + soma);
		
	}

}
