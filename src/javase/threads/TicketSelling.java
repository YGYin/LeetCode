package javase.threads;

// Use multi threads to sell tickets
public class TicketSelling {
    public static void main(String[] args) {
//        Sales01 sales011 = new Sales01();
//        Sales01 sales012 = new Sales01();
//        Sales01 sales013 = new Sales01();
//
//        sales011.start();
//        sales012.start();
//        sales013.start();

        Sales02 sales021 = new Sales02();
        new Thread(sales021).start(); // Thread 1
        new Thread(sales021).start(); // Thread 2
        new Thread(sales021).start(); // Thread 3
    }
}

class Sales01 extends Thread {
    private static int tkNum = 100;

    @Override
    public void run() {
        while (true) {
            if (tkNum <= 0) {
                System.out.println("Tickets were sold out.");
                break;
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Window " + Thread.currentThread().getName() + " sold one ticket."
                    + " Remain ticket: " + (--tkNum));
        }
    }
}

class Sales02 implements Runnable {
    // Because we only create one Sale02 instance, so it doesn't need to be static
    private int tkNum = 100;
    private boolean loop = true;

    public synchronized void sell() {
        if (tkNum <= 0) {
            System.out.println("Tickets were sold out.");
            loop = false;
            return;
        }
        System.out.println("Window " + Thread.currentThread().getName() + " sold one ticket."
                + " Remain ticket: " + (--tkNum));
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        while (loop)
            sell();
    }
}