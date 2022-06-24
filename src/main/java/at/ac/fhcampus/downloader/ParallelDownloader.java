package at.ac.fhcampus.downloader;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

// Class is needed for exercise 4 - ignore for exercise 3 solution
public class ParallelDownloader extends Downloader{

    // returns number of downloaded article urls
    @Override
    public int process(List<String> urls) {
        // TODO implement download function using multiple threads
        // Hint: use ExecutorService with Callables

        int numWorkers = Runtime.getRuntime().availableProcessors();
        ExecutorService pool = Executors.newFixedThreadPool(numWorkers);

        List<Future<String>> futures = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            int idx = i;
            Callable<String> task = () -> (saveUrl2File(urls.get(idx)));
            futures.add(pool.submit(task));
        }
        List<String> results = new ArrayList<>();
        for(Future<String> result : futures){
            try {
                if(result.get() != null){
                    results.add(result.get());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        return 0;
    }
}
