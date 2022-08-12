package javase.poly.polypara;

public class Testing {
    public static void main(String[] args) {
        Worker Alex = new Worker("Alex", 50000);
        Manager YG = new Manager("YG", 100000, 500000);
        Testing testing = new Testing();
        testing.getEmpAnnual(Alex);
        testing.getEmpAnnual(YG);

        testing.testWork(Alex);
        testing.testWork(YG);
    }

    public void getEmpAnnual(Employee e) {
        System.out.println(e.getName() + "'s Annual: " + e.getAnnual());
    }

    public void testWork(Employee e) {
        if (e instanceof Worker)
            ((Worker) e).work();
        else if (e instanceof Manager)
            ((Manager) e).manage();
        else
            System.out.println("No special method");
    }
}
