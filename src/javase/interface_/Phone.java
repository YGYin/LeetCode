package javase.interface_;

// Once Phone implements the UsbInterface
// 1. Phone must implement the method of UsbInterface
public class Phone implements UsbInterface {
    @Override
    public void start() {
        System.out.println("Phone is working.");
    }

    @Override
    public void stop() {
        System.out.println("Phone is stop working.");
    }
}
