package testeInicial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Analisa {


    public static void main(String[] args) throws ExecutionException {

        ExecutorService executor = Executors.newCachedThreadPool();

        List<Callable<Integer>> listOfCallable = Arrays.asList( 
        		() -> Analisa.dobro(2), () -> Analisa.dobro(3), () -> Analisa.dobro(4));
   
        try {

            List<Future<Integer>> futures = executor.invokeAll(listOfCallable);

            for (Future<Integer> future : futures) {
				System.out.println(future.get());
			}
            
            int sum = futures.parallelStream().map(f -> {
                try {
                    return f.get();
                } catch (Exception e) {
                    throw new IllegalStateException(e);
                }
            }).mapToInt(Integer::intValue).sum();

            System.out.println("SOMA:" + sum);

        } catch (InterruptedException e) {// thread was interrupted
            e.printStackTrace();
        } finally {

            // shut down the executor manually
            executor.shutdown();

        }

    }
    
    public static int dobro(int num) {
    	return num * num;
    }


    
    /*
     * 
     ExecutorService threadPool = Executors.newFixedThreadPool(threadNo);

	for (int i = 0; i < loop; i++) {
    	threadPool.submit(new Runnable() {public void run() { myclass.execTask(); });
	}
     */

}
