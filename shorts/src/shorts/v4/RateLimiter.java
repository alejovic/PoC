package shorts.v4;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class RateLimiter {
    private final int maxRequests;
    private final long timeWindowMillis;
    private final AtomicInteger requestCount;
    private long lastResetTime;

    public RateLimiter(int maxRequests, long timeWindow, TimeUnit unit) {
        this.maxRequests = maxRequests;
        this.timeWindowMillis = unit.toMillis(timeWindow);
        this.requestCount = new AtomicInteger(0);
        this.lastResetTime = System.currentTimeMillis();
    }

    public synchronized boolean allowRequest() {
        long currentTime = System.currentTimeMillis();

        if (currentTime - lastResetTime > timeWindowMillis) {
            requestCount.set(0);
            lastResetTime = currentTime;
        }

        if (requestCount.incrementAndGet() <= maxRequests) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        RateLimiter limiter = new RateLimiter(50, 1, TimeUnit.MILLISECONDS);

        for (int i = 0; i < 100; i++) {
            System.out.println("Request " + (i + 1) + ": " + (limiter.allowRequest() ? "Allowed" : "Blocked"));
            Thread.sleep(200); // Simulating request interval
        }
    }
}
