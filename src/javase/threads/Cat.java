package javase.threads;

public class Cat extends Thread {
    int times = 0;

    @Override
    public void run() { // Write your logic here
        while (true) {
            System.out.println("Nya " + (++times) +
                    " Thread Name: " + Thread.currentThread().getName());
            // Sleep for 1s
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (times == 50)
                break;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Cat cat = new Cat();
        cat.start(); // Launch the thread, invoke run()

        for (int i = 0; i < 50; i++) {
            System.out.println("Main Thread: " + i);
            Thread.sleep(1000);
        }
    }
}
