package javase.interface_;

public class TestInterface {
    public static void main(String[] args) {
        Phone phone = new Phone();
        Camera camera = new Camera();
        Computer computer = new Computer();
        // Plugin the phone into the computer by usb interface
        computer.work(phone);
        computer.work(camera);

    }
}
