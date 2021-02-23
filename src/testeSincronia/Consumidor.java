package testeSincronia;

public class Consumidor extends Thread {

	private CuboNaoSinc cubo;
    private int number;

    public Consumidor(CuboNaoSinc c, int number) {
        cubo = c;
        this.number = number;
    }

    public void run() {
        int value = 0;
        for (int i = 0; i < 10; i++) {
            value = cubo.get();
            System.out.println("Consumidor pegou o número:" + value);
            try {
    			Thread.currentThread().sleep(1);
    		} catch (InterruptedException e) {}
        }
    }
}
