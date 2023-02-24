import java.util.Random;

public class TokenBucketTest {
    private static long curToken = 0;
    private static long prevTime = System.currentTimeMillis();

    /**
     * @param capacity The max num of tokens in the bucket
     * @param rate     The number of tokens the system puts in every millisecond
     * @return true:   Current limiting
     * false:  Not current limiting
     */
    static boolean TokenBucketTest(int capacity, int rate) {
        long curTime = System.currentTimeMillis();
        // Time interval between requests
        long time = (curTime - prevTime);
        // Current tokens in the bucket
        curToken = Math.min(capacity, curToken + time * rate);
        prevTime = curTime;

        // No Token in the bucket
        if (curToken == 0)
            return true;
        // Take a token
        --curToken;
        return false;
    }

    public static void main(String[] args) {
        for (; ; ) {
            // Sleep for 1 second
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Testing for <= 1500 QPS
            int randomTime = new Random().nextInt(1500);
            for (int j = 0; j < randomTime; j++) {
                request();
            }
        }
    }


    private synchronized static void request() {
        if (TokenBucketTest(2000, 1)) {
            System.out.println("Current limited " + curToken);
        } else {
            System.out.println("Pass " + curToken);
        }
    }
}
