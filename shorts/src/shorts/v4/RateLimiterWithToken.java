package shorts.v4;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RateLimiterWithToken {

    private final int maxTokens;
    private final int refillRate;
    private int tokens;
    private final ScheduledExecutorService scheduler;

    public RateLimiterWithToken(int maxTokens, int refillRate) {
        this.maxTokens = maxTokens;
        this.refillRate = refillRate;
        this.tokens = maxTokens;
        this.scheduler = Executors.newScheduledThreadPool(1);
        this.scheduler.scheduleAtFixedRate(this::refill, 0, 1, TimeUnit.SECONDS);
    }

    private synchronized void refill() {
        if (tokens < maxTokens) {
            tokens += refillRate;
            if (tokens > maxTokens) {
                tokens = maxTokens;
            }
        }
    }

    public synchronized boolean tryAcquire() {
        if (tokens > 0) {
            tokens--;
            return true;
        }
        return false;
    }

    public void shutdown() {
        scheduler.shutdown();
    }

    public static void main(String[] args) {
        RateLimiterWithToken rateLimiter = new RateLimiterWithToken(5, 1);

        Runnable task = () -> {
            if (rateLimiter.tryAcquire()) {
                System.out.println("Request processed at " + System.currentTimeMillis());
            } else {
                System.out.println("Rate limit exceeded at " + System.currentTimeMillis());
            }
        };

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(task, 0, 200, TimeUnit.MILLISECONDS);

        // Run for 10 seconds
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executor.shutdown();
        rateLimiter.shutdown();
    }
}
