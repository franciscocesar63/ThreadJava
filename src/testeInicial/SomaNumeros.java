package testeInicial;

import java.util.ArrayList;
import java.util.List;

public class SomaNumeros implements Runnable{

	public ArrayList<Integer> minhaLista = new ArrayList<Integer>();
	public int inicio;
	public int fim;
	public static int somaFinal = 0;
	
	public SomaNumeros(ArrayList<Integer> lista, int inicio, int fim){
		
		this.minhaLista = lista;
		this.inicio = inicio;
		this.fim = fim;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> lista = new ArrayList<Integer>();
		
		for(int i=1; i <= 10; i++)
			lista.add(i);
		//1,2,3,4,5,6,7,8,9,10
		new Thread(new SomaNumeros(lista, 0, lista.size()/2 )).start();
		new Thread(new SomaNumeros(lista, lista.size()/2, lista.size())).start();
	}
	
	@Override
	public void run() {
		int soma = 0;
		System.out.println("Aqui na minha THREAD:" + Thread.currentThread().getId());
		
		for(int i= this.inicio; i < this.fim; i++) {
			soma += this.minhaLista.get(i);
		}
		
		System.out.println("Na Thread " + Thread.currentThread().getId() + " a soma foi:" + soma);
		
		somaFinal += soma;
		System.out.println("Na Thread " + Thread.currentThread().getId() + " a somaFINAL foi:" + somaFinal);
	}

}
