package testeSincronia;

public class Produtor extends Thread{

	 private CuboNaoSinc cubo;
	 private int number;

	    public Produtor(CuboNaoSinc c, int number) {
	        cubo = c;
	        this.number = number;
	    }

	    public void run() {
	        for (int i = 0; i < 10; i++) {
	            cubo.put(i);
	            System.out.println("Produtor colocou o número:" + i);
	            /*
	            try {
	    			Thread.currentThread().sleep(500);
	    		} catch (InterruptedException e) {} 
	    		*/
	        }
	    }
}
