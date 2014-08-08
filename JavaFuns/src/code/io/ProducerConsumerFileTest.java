package code.io;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ProducerConsumerFileTest {
    public static void main(String[] args) throws Exception {
        ExecutorService consumer = Executors.newFixedThreadPool(10);

        String filePath = "";
        BufferedReader br =
                new BufferedReader(
                new InputStreamReader(
                new FileInputStream(
                new File(args[0]))));
        
        

        String line = "";

        while ((line = br.readLine()) != null) {
            System.out.println(
                    "Producer producing: " + line);
            consumer.submit(new PrintJob(line));
        }

        consumer.shutdown();
        consumer.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
    }
}

class PrintJob implements Runnable {
    private String line;

    public PrintJob(String s) {
        line = s;
    }

    @Override
    public void run() {
        System.out.println(
                Thread.currentThread().getName() +
                        " consuming :" + line);
    }
}