package javase.threads;

public class DeadLock {
    public static void main(String[] args) {
        DeadLockSim t1 = new DeadLockSim(true);
        t1.setName("Thread 1");
        DeadLockSim t2 = new DeadLockSim(false);
        t2.setName("Thread 2");
        t1.start();
        t2.start();
    }
}

class DeadLockSim extends Thread {
    // Make sure multi threads share with the same object
    static Object o1 = new Object();
    static Object o2 = new Object();
    boolean flag;

    public DeadLockSim(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag) {
            synchronized (o1) {
                System.out.println(Thread.currentThread().getName() + " gets in o1");
                synchronized (o2) {
                    System.out.println(Thread.currentThread().getName() + " gets in o2");
                }
            }
        } else {
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName() + " gets in o3");
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName() + " gets in o4");
                }
            }
        }
    }
}
