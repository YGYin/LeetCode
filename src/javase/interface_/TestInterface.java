package javase.interface_;

public class TestInterface {
    public static void main(String[] args) {
        Phone phone = new Phone();
        Computer computer = new Computer();
        // Plugin the phone into the computer by usb interface
        computer.work(phone);
    }
}
