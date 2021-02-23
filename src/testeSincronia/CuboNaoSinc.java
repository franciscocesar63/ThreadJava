package testeSincronia;

import java.util.HashMap;

public class CuboNaoSinc {

	private int conteudo;
	private boolean disponivel;
	
	public int get() {
	
		disponivel = false;
	    return this.conteudo;
	}
	
	public void put(int valor) {
	    
	    this.conteudo = valor;
	    disponivel = true;
	    
	}
	
}
