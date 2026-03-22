package prj.multi.concurrentCollection;

import java.util.Map;

public class ConcurrentCache {
    // A shared cache used by multiple threads
    private static final Map<String, String> cache = new ConcurrentCacheMap<>();
    public static void main(String[] args) {
        // creates 10 threads that will access the cache concurrently
        for (int i = 0; i <10; i++)
        {
            final int threadNum = i;
            
            new Thread(() -> {
                String key = "key @"+threadNum;
                for (int j = 0; j < 3; j++) {
                    String value = getCachedValue(key);
                    System.out.println("Thread "+Thread.currentThread().getName()+" got "+key+"="+value);
                }

            }).start();
        }
    }

    private static String getCachedValue(final String key) {
        String value = cache.get(key);
        if (value == null) {
            value = compute(key);
            cache.put(key, value);
        }
        return value;
    }

    private static String compute(final String key) {
        System.out.println(key + "is not present in cache, computing value...");
        try {
            Thread.sleep(500); 
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Computed value for " + key;
    }
}
