package javase.poly.polypara;

public class Worker extends Employee {

    public Worker(String name, double salary) {
        super(name, salary);
    }

    public void work() {
        System.out.println("Worker " + getName() + " is working.");
    }

    @Override
    public double getAnnual() {
        return super.getAnnual();
    }
}
