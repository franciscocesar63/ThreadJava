package testeSincronia2;

public class Main {

    public static void main(String args[])
    {
        MathClass mathClass = new MathClass();
 
        Runnable r = () -> {
			
                try {
                    mathClass.printNumbers(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            
        };
       
        new Thread(r, "UM").start();
        new Thread(r, "DOIS").start();
    }
}
