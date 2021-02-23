package testeSincronia;

import java.util.HashMap;

public class Cubo {

	private int conteudo;
	private boolean disponivel;
	
	public synchronized int get() {
	
		while (disponivel == false) {
	        try {
	            //esperar o produtor colocar o valor
	            wait();
	        } catch (InterruptedException e) { }
	    }
	    disponivel = false;

	    notifyAll();
	    return this.conteudo;
	}
	
	
	public synchronized void put(int valor) {
	    while (disponivel == true) {
	        try {
	            //esperar o consumidor pegar o valor
	            wait();
	        } catch (InterruptedException e) { }
	    }
	    
	    this.conteudo = valor;
	    disponivel = true;
	    
	    //notificar os consumidores que o valor está disponível 
	    notifyAll();
		
	}
	
}
