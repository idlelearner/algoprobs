package code.concurrency;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ExpirableCache {
	
	//http://stackoverflow.com/questions/7500448/simple-java-string-cache-with-expiration-possibility
	public static void main(String[] args) {
		// Declare your Map and executor service
		final Map<String, ScheduledFuture<String>> cacheNames = new HashMap<String, ScheduledFuture<String>>();
		ScheduledExecutorService executorService = Executors
				.newSingleThreadScheduledExecutor();
		
		
		//Then can remove the map entries after expiry.
		ScheduledFuture<String> task = executorService.schedule(new Callable<String>() {
			  @Override
			  public String call() {
			    cacheNames.remove("unique_string");
			    return "unique_string";
			  }
			}, 1, TimeUnit.SECONDS);
			cacheNames.put("unique_string", task);
	}
}
