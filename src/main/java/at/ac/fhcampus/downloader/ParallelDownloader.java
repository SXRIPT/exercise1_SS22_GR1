package at.ac.fhcampus.downloader;

import java.util.List;

// Class is needed for exercise 4 - ignore for exercise 3 solution
public class ParallelDownloader extends Downloader{

    // returns number of downloaded article urls
    @Override
    public int process(List<String> urls) {
        // TODO implement download function using multiple threads
        // Hint: use ExecutorService with Callables
        long currTime = System.currentTimeMillis();


        long currTime2 = System.currentTimeMillis();
        System.out.println("The runtime for the Sequential Download in milliseconds is: " + (currTime2-currTime));
        return 0;
    }
}
